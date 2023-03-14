package hftm.ch.utils;

import java.io.Serializable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;

import javax.persistence.EntityManager;

import hftm.ch.models.Adresse;
import hftm.ch.models.Ortschaft;
import hftm.ch.models.Person;

/** singleton repository to interact with database */
public class Repository implements Serializable {
    static final long serialVersionUID = 42L;

    private static Repository instance; 
    public static Repository getInstance() {
        if(Repository.instance == null) {
            Repository.instance = new Repository();
        }
        return Repository.instance;
    }

    public static void overrideInstance(Repository repository) {
        Repository.instance = repository;
    }

    public List<Person> personen;
    public List<Adresse> adressen;
    public List<Ortschaft> ortschaften;

    private transient Connection connection;

    private Repository() {
        personen = new ArrayList<>();
        adressen = new ArrayList<>();
        ortschaften = new ArrayList<>();

        try {
            //connection = DriverManager.getConnection("jdbc:sqlite:sqlite.db");
            //createDatabase();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /** creates sqlite tables */
    private void createDatabase() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS personen ( " +
                "id integer PRIMARY KEY, " +
                "name text NOT NULL, " +
                "lastname text NOT NULL, " +
                "birthday text NOT NULL, " +
                "homeplace text NOT NULL " +
            ");");
            connection.commit();

            statement.execute("CREATE TABLE IF NOT EXISTS adressen ( " +
                "id integer PRIMARY KEY, " +
                "strasse text NOT NULL, " +
                "nummer text NOT NULL, " +
                "validfrom date NOT NULL, " +
                "validto date NOT NULL " +
                "ortfk integer NOT NULL " +
            ");");
            connection.commit();

            statement.execute("CREATE TABLE IF NOT EXISTS ortschaft ( " +
                "id integer PRIMARY KEY, " +
                "plz text NOT NULL, " +
                "ort text NOT NULL " +
            ");");
            connection.commit();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /** Personen modif */
    public static List<Person> getPersonen() {
        return Repository.getInstance().personen;
    }

    public static Person getPersonById(Long id) {
        for (Person p: Repository.getInstance().personen) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public static void addPerson(Person person) {
        Repository.getInstance().personen.add(person);
    }

    public static void removePerson(Person person) {
        Repository.getInstance().personen.remove(person);
    }

    /** new person with correct id */
    public static Person newPerson() {
        Long id = 0L;
        for (Person p: Repository.getInstance().personen) {
            if (p.getId() >= id) {
                id = p.getId() + 1L;
            }
        }
        Person person = new Person();
        person.setId(id);
        return person;
    }

    /** Ortschaft modif */
    public static List<Ortschaft> getOrtschaften() {
        return Repository.getInstance().ortschaften;
    }

    public static Ortschaft getOrtschaftById(Long id) {
        for (Ortschaft o: Repository.getInstance().ortschaften) {
            if (o.getId() == id) {
                return o;
            }
        }
        return null;
    }

    public static void addOrtschaft(Ortschaft ortschaft) {
        Repository.getInstance().ortschaften.add(ortschaft);
    }

    public static void removeOrtschaft(Ortschaft ortschaft) {
        Repository.getInstance().ortschaften.remove(ortschaft);
    }

    /** new ortschaft with correct id */
    public static Ortschaft newOrtschaft() {
        Long id = 0L;
        for (Ortschaft o: Repository.getInstance().ortschaften) {
            if (o.getId() >= id) {
                id = o.getId() + 1L;
            }
        }
        Ortschaft ort = new Ortschaft();
        ort.setId(id);
        return ort;
    }

    /** Adresse modif */
    public static List<Adresse> getAdressen() {
        return Repository.getInstance().adressen;
    }

    public static Adresse getAdresseById(Long id) {
        for (Adresse a: Repository.getInstance().adressen) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public static void addAdresse(Adresse adresse) {
        Repository.getInstance().adressen.add(adresse);
    }

    public static void removeAdresse(Adresse adresse) {
        Repository.getInstance().adressen.remove(adresse);
    }

    /** new adresse with correct id */
    public static Adresse newAdresse() {
        Long id = 0L;
        for (Adresse a: Repository.getInstance().adressen) {
            if (a.getId() >= id) {
                id = a.getId() + 1L;
            }
        }
        Adresse adr = new Adresse();
        adr.setId(id);
        return adr;
    }

    // Serializes the Repository to a file
    private static void toFile(String path) {
        try {
            // Create streams
            FileOutputStream fileStream = new FileOutputStream(path);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            // Write object to streams
            objectStream.writeObject(Repository.getInstance());
            // Close streams
            objectStream.close();
            fileStream.close();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
    }

    // Desirializes the Repository from a file
    private static void fromFile(String path) {
        try {
            // Create streams
            FileInputStream fileStream = new FileInputStream(path);
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);
            Repository.overrideInstance((Repository)objectStream.readObject());
            // Close streams
            objectStream.close();
            fileStream.close();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
    }

    // Loads the state from the specified state path
    // This is called from the entrypoint
    public static void load() {
        // Check if file exists before loading
        File stateFile = new File(getFilePath());
        if (stateFile.exists()) {
            fromFile(getFilePath());
        } else {
            System.out.println("file not found to load");
        }
    }

    // Saves the state to the specified state path
    public static void save() {
        toFile(getFilePath());
    }

    public static String getFilePath() {
        return "save.bin";
    }
}
