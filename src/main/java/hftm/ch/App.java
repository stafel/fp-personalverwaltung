package hftm.ch;

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
        Repository.load();

        Repository.save();
    }
}
