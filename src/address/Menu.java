package address;
import java.util.*;

/**
 * The Menu class represents a generic Menu used to display menu options to the user,
 * and allows the user to enter in data to AddressEntry through prompts
 * @author Jared Ferriols
 * @since JDK 17
 * @version 1.2
 */

public class Menu {


    /**
     * A method which prompts the user for a first name entered in by the user
     * and returns a string
     * @return a String which represents a person's first name
     */
    public static String prompt_FirstName(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("First Name: ");
        return keyboard.nextLine();
    }

    /**
     * A method which prompts the user for a last name entered in by the user
     * and returns a string
     * @return a String which represents a person's last name
     */
    public static String prompt_LastName(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Last Name: ");
        return keyboard.nextLine();

    }

    /**
     * A method which prompts the user for a street entered in by the user
     * and returns a string
     * @return a String which represents a person's street
     */
    public static String prompt_Street(){

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Street: ");
        return keyboard.nextLine();

    }

    /**
     * A method which prompts the user for a city entered in by the user
     * and returns a string
     * @return a String which represents a person's city
     */
    public static String prompt_City(){

        Scanner keyboard = new Scanner(System.in);
        System.out.println("City: ");
        return keyboard.nextLine();

    }


    /**
     * A method which prompts the user for a state entered in by the user
     * and returns a string
     * @return a String which represents a person's state
     */
    public static String prompt_State(){

        Scanner keyboard = new Scanner(System.in);
        System.out.println("State: ");
        return keyboard.nextLine();

    }


    /**
     * A method which prompts the user for a zip code entered in by the user
     * and returns an integer
     * @return an integer which represents a person's zip code
     */
    public static int prompt_Zip(){

        // return "Zip:";
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Zip: ");
        return keyboard.nextInt();

    }



    /**
     * A method which prompts the user for a telephone number entered in by the user
     * and returns a string
     * @return a String which represents a person's telephone number
     */
    public static String prompt_Telephone(){

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Telephone: ");
        return keyboard.nextLine();

    }


    /**
     * A method which prompts the user for an email address entered in by the user
     * and returns a string
     * @return a String which represents a person's email address
     */
    public static String prompt_Email(){

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Email: ");
        return keyboard.nextLine();

    }

    /**
     * Prints out a menu which prompts a user a selection of options
     * to manipulate the AddressBook class
     */
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