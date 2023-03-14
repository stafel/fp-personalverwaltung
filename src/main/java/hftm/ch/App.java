package hftm.ch;

import hftm.ch.models.Ortschaft;
import hftm.ch.utils.Repository;;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        App.testRepository();
    }

    public static void testRepository() {
        Repository.load();

        // add ortschaft
        Ortschaft ort = Repository.newOrtschaft();
        ort.setOrt("Grenchen");
        ort.setPlz("2540");
        Repository.addOrtschaft(ort);
        System.out.println(ort.getId());

        ort = Repository.newOrtschaft();
        ort.setOrt("Solothurn");
        ort.setPlz("Wasauchimmer");
        Repository.addOrtschaft(ort);
        System.out.println(ort.getId());

        ort = Repository.newOrtschaft();
        ort.setOrt("Bettlach");
        ort.setPlz("2520?");
        Repository.addOrtschaft(ort);
        System.out.println(ort.getId());

        // delete ortschaft
        Ortschaft toDelete = Repository.getOrtschaftById(1L);
        System.out.println(toDelete.getOrt());
        Repository.removeOrtschaft(toDelete);
        System.out.println();

        // save and reload
        Repository.save();
        Repository.load();

        // get all ortschaften
        for (Ortschaft o: Repository.getOrtschaften()) {
            System.out.println(o.getOrt());
        }
    }
}
