package address;
// import java.awt.*;
import java.util.*;

/**
 * Menu class currently only has static methods to prompt to standard output information about a Contact like name,etc
 */

/**The Menu class represents a generic Menu used to display menu options to the user.
 * This only uses empty or unfinished prompt methods for now
 * @author Jared Ferriols
 * @since Jan. 25, 2023
 * @version 1.0
 */

public class Menu {


    /**
     * prompt for First Name
     * @return the First Name entered in by the user, if nothing entered in will use default
     */
    public static String prompt_FirstName(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("First Name: ");
        return keyboard.nextLine();
    }

    /**
     * prompt for Last Name
     * @return the Last Name entered in by the user, if nothing entered in will use default
     */
    public static String prompt_LastName(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Last Name: ");
        return keyboard.nextLine();

    }

    /**
     * prompt for Street
     * @return the Street entered in by the user, if nothing entered in will use default
     */
    public static String prompt_Street(){

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Street: ");


        return keyboard.nextLine();

    }

    /**
     * prompt for City
     * @return the City entered in by the user, if nothing entered in will use default
     */
    public static String prompt_City(){

        Scanner keyboard = new Scanner(System.in);
        System.out.println("City: ");


        return keyboard.nextLine();

    }


    /**
     * prompt for State
     * @return the State entered in by the user, if nothing entered in will use default
     */
    public static String prompt_State(){

        Scanner keyboard = new Scanner(System.in);
        System.out.println("State: ");
        return keyboard.nextLine();

    }


    /**
     * prompt for Zip
     * @return the Zip entered in by the user, if nothing entered in will use default
     */
    public static int prompt_Zip(){

        // return "Zip:";
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Zip: ");
        return keyboard.nextInt();

    }



    /**
     * prompt for Telephone
     * @return the Telephone entered in by the user, if nothing entered in will use default
     */
    public static String prompt_Telephone(){

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Telephone: ");
        return keyboard.nextLine();

    }


    /**
     * prompt for Email
     * @return the Email entered in by the user, if nothing entered in will use default
     */
    public static String prompt_Email(){

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Email: ");
        return keyboard.nextLine();

    }

    public static void displayMenu(){
        System.out.print("""
                *************************
                Please enter your menu selection
                a) Loading From File
                b) Addition
                c) Removal
                d) Find
                e) Listing
                f) Quit
                *************************
                """);
    }






}