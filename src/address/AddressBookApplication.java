package address;

import address.data.AddressBook;
import address.data.AddressEntry;
// https://stackoverflow.com/questions/65421001/treemapstring-new-treemapstring-integer-treemap-with-object
// import java.awt.*;
import java.lang.*;
import java.util.*;

/**
 * The AddressBookApplication class represents a generic Address Book Application used to invoke methods
 * of the other classes to the user.
 * @author Jared Ferriols
 * @since JDK 17
 * @version 1.2
 */
public class AddressBookApplication {

    /**
     * The main method which creates an AddressBook and
     * prompts the user to manipulate the AddressBook class by
     * allowing adding, deleting, listing, and searching for entries.
     * @param args is the command line arguments passed to main
     */
    public static void main(String[] args) {


        AddressBook addB = new AddressBook();
        startApplication(addB);


    }

    /**
     * This method initializes 2 AddressEntry objects with predefined data.
     * Then it adds entries to AddressBook class passed to function and prints
     * out the entries in a sorted manner in terms of the last name in alphabetical order.
     * @param ab is an object of the AddressBook class that will hold the two address entries.
     * @returns nothing as it is supposed to return nothing as a void function, but it
     * actually prints out the sorted entries in console.
     */
      public static void initAddressBookExercise(AddressBook ab){

        // create two address entries with predefined data
        AddressEntry addressEntry10 = new AddressEntry("Jared","Ferriols","12345 Whittington","Union City","CA",94587,"510-244-8031","best1@gmail.com");

        AddressEntry addressEntry20 = new AddressEntry("John","Smith","45678 Whittington","Union City","CA",94586,"510-555-1234","best2@gmail.com");

        // Add both address entries into address book and print out sorted list in terms of last name
        ab.add(addressEntry10);
        ab.add(addressEntry20);
        ab.list();
    }


    /**
     * This method allows the user to select their desired choices to manipulate
     * the AddressBook instance based on the menu's display.
     * @param ab is an object of the AddressBook class that will hold,
     * manipulate, and display the address entries.
     * @returns nothing as it is supposed to call the functions of the AddressBook
     * and AddressEntry classes based on the user's input
     */
    public static void startApplication(AddressBook ab){
        Scanner keyboard = new Scanner(System.in);
        String choice;
        boolean continueProgram = true;
        while(continueProgram) {
            Menu.displayMenu();
            choice = keyboard.nextLine();
            switch (choice) {
                case "a" -> {
                    System.out.println("Enter in FileName:");
                    ab.loadEntriesFromFile(keyboard.nextLine());
                }
                case "b" -> {
                    ab.add(new AddressEntry(Menu.prompt_FirstName(), Menu.prompt_LastName(), Menu.prompt_Street(), Menu.prompt_City(), Menu.prompt_State(), Menu.prompt_Zip(), Menu.prompt_Telephone(), Menu.prompt_Email()));
                }
                case "c" -> {
                    System.out.println("Enter in Last Name of contact to remove:");
                    ab.remove(keyboard.nextLine());
                }
                case "d" -> {
                    System.out.println("Enter in all or beginning of last name you wish to find:");
                    ab.find(keyboard.nextLine());
                }
                case "e" -> {
                    ab.list();
                }
                case "f" -> {
                    System.out.println("Quitting.");
                    continueProgram = false;
                }
                default -> {
                    System.out.println("Error: " + choice + " is not a valid input. Please try again.");
                }
            }


        }
    }


}