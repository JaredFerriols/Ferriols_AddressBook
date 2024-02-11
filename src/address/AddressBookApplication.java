package address;

import address.data.AddressBook;
import address.data.AddressEntry;
// https://stackoverflow.com/questions/65421001/treemapstring-new-treemapstring-integer-treemap-with-object
// import java.awt.*;
import java.lang.*;
import java.util.*;

/**
 * main AddressBookApplication: The purpose is to invoke some
 * methods of the Menu class
 */

/**
 * The AddressBookApplication class represents a generic Address Book Application used to invoke methods
 * of the other classes to the user.
 * @author Jared Ferriols
 * @since Jan. 25, 2023
 * @version 1.0
 */
public class AddressBookApplication {
    public static void main(String[] args) {

        // Make addressBook object
        AddressBook addB = new AddressBook();
        // Use object to add two entries in addB and list them.
        // initAddressBookExercise(addB);
        startApplication(addB);


    }

    /**
     * This method initializes 2 AddressEntry objects with predefined data.
     * Then it adds entries to AddressBook class passed to function and prints
     * out the entries in a sorted manner in terms of the last name in alphabetical order.
     * @param ab is an object of the AddressBook class that will hold the two address entries.
     * @returns nothing It is supposed to return nothing as a void function, but it
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
     * This method allows the user to select their desired choices based on the menu's
     * display.
     * @param ab ab is an object of the AddressBook class that will hold and manipulate the address entries.
     * @returns nothing While this method returns nothing, it is supposed to call
     * the functions of the AddressBook and AddressEntry classes based on the
     * user's input
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
                    // Loading of entries from a file.
                    System.out.println("Enter in FileName:");
                    ab.loadEntriesFromFile(keyboard.nextLine());
                }
                case "b" -> {
                    //  Addition - prompting user for information
                    //  to be used to create a new AddressEntry
                    ab.add(new AddressEntry(Menu.prompt_FirstName(), Menu.prompt_LastName(), Menu.prompt_Street(), Menu.prompt_City(), Menu.prompt_State(), Menu.prompt_Zip(), Menu.prompt_Telephone(), Menu.prompt_Email()));

                }
                case "c" -> {
                    // Removal - removing of an AddressEntry from the AddressBook.
                    // First a find is done (see below example session) and then
                    // the user selects from the find results what entry to remove.
                    System.out.println("Enter in Last Name of contact to remove:");
                    ab.remove(keyboard.nextLine());
                }
                case "d" -> {
                    // Find - prompts users for the begining of the users last name
                    // (they can enter a complete last name or just the start....all
                    // entries with that as the first part of their last name will
                    // be displayed). Note in the case when more then one entry
                    // is found a set will be returned.
                    System.out.println("Enter in all or beginning of last name you wish to find:");
                    ab.find(keyboard.nextLine());

                }
                case "e" -> {
                    // Listing - listing (a "dump") of the
                    // addresses in alphabetic order by the person's last name.
                    ab.list();
                }
                case "f" -> {
                    //  Quit -note we are NOT saving any newly created AddressEntry
                    //  objects (or removing objects either are not updated to
                    //  the file) to the file, this data is lost, we will
                    //  handle this issue in Project 2 when we store data
                    //  more appropriately in a database.
                    System.out.println("Quitting.");
                    continueProgram = false;
                }
                default -> {
                    // Error statement
                    System.out.println("Error: " + choice + " is not a valid input. Please try again.");
                }
            }


        }
    }


}