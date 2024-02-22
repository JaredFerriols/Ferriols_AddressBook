
package address.data;


import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;


/**
 * The AddressBook class represents a generic Address Book used to store multiple Address entries
 * for the user to add, remove, or look up.
 * @author Jared Ferriols
 * @since JDK 17
 * @version 1.2
 */

public class AddressBook {

    /**
     * The specific data structures used to store the data or address entries in address book.
     * It uses TreeMap where the key is a String(the last name of the AddressEntry and the value is the a TreeSet
     * AddressEntry. This is because java does not contain a multiset in standard libraries.
     * Tree is used instead of hash because tree preserves the natural ordering of key which makes printing in
     * sorted order by last name(key) easy.
     */
    private final TreeMap<String, TreeSet<AddressEntry>> addressEntryList = new TreeMap<>();

    /**
     * The method which prints out all the data of each of the entries within the address book.
     * The AddressBook's list() method cycles through the collection of AddressEntry
     * objects using an iterator the contained in AddressBook and prints outs the
     * information to the console window calling toString() methods on
     * each of its AddressEntry objects.
     *
     * @param nothing
     * @returns nothing, It is a void function, but it prints all the address entries
     * in the address book
     */

    public void list() {

        StringBuilder contents = new StringBuilder();
        int i = 1;
        // iterate TreeMap
        for (Map.Entry<String, TreeSet<AddressEntry>> setContents : addressEntryList.entrySet()) {
            // iterate TreeSet and get its value
            for (AddressEntry element : setContents.getValue()) {
                if (element != null) {
                    contents.append(String.format("%-3s" + element + "\n", i + ":"));
                    i++;
                }
            }
        }
        // print out contents with toString conversion
        System.out.print(contents.toString());


    }

    /**
     * A method which adds an address entry object to the address book.
     * @param entry is an object of AddressEntry to add to the AddressBook
     * @returns nothing
     *
     * If the key is new, then a new TreeSet is created to contain the address entry
     * If the key is not new, then it checks compareTo method to see if the address entry
     * data is different in other data such as first name.
     **/

    public void add(AddressEntry entry) {
        addressEntryList.computeIfAbsent(entry.getLastName(), k -> new TreeSet<>()).add(entry);
    }

    /**
     * A method which reads the address entries from a text file and adds them to the address book.
     *
     * @param fileName is a string which is the name of a text file that contains the address Entry data.
     *
     * The format for the text file is firstName\nlastName\nstreet\ncity\nstate\nzip\nphone\nemail
     */
    public void loadEntriesFromFile(String fileName) {

        try{
            File file = new File(fileName);
            FileReader fReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fReader);
            String fileLine;

            // read strings except for zip, which is an int
            // firstName + lastName + street +  city + state + zip + phone +  email;
            while((fileLine = br.readLine()) != null) {
                this.add(new AddressEntry(fileLine, br.readLine(), br.readLine(), br.readLine(),
                        br.readLine(), Integer.parseInt(br.readLine()), br.readLine(), br.readLine()));
            }
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * A method which removes an address entry from the address book.
     *
     * @param lastName is the last name or the part of the last name of the
     * person contained in the AddressEntry to be removed, as there could be multiple
     * entires with the same first character of the last name
     *
     * First we find and store AddressEntry into a data structure.
     * If there is only one AddressEntry instance, then print out AddressEntry and
     * prompt user if they wish to delete. If there is more than 1 element,
     * then print all elements and ask user to select element based on index.
     */
    public void remove(String lastName) {
        // Find all entries based on part of the last name and store them in TreeSet
        SortedMap<String, TreeSet<address.data.AddressEntry>> usableMap;
        usableMap = addressEntryList.subMap(lastName, lastName + Character.MAX_VALUE);
        TreeSet<AddressEntry> selectedSet = new TreeSet<>();
        for(Map.Entry<String, TreeSet<AddressEntry>> entry : usableMap.entrySet()) {
            selectedSet.addAll(entry.getValue());
        }
        Scanner keyboard = new Scanner(System.in);

        try {
            if (selectedSet.size() == 1) {
                // Use ArrayList to get the AddressEntry easily.
                ArrayList<AddressEntry> onlyList = new ArrayList<>();
                for (AddressEntry entry : selectedSet) {
                    onlyList.add(entry);
                }
                int oneIndex = 0;
                System.out.println("The following entry was found in the address book.");
                System.out.printf("%-3s" + onlyList.get(oneIndex) + "\n", " ");
                System.out.println("Hit 'y' to remove the entry or 'n' to return to main menu");
                if (keyboard.nextLine().compareTo("y") == 0) {
                    addressEntryList.get(onlyList.get(oneIndex).getLastName()).remove(onlyList.get(oneIndex));
                }
            } else if (selectedSet.size() > 1) {
                    // Use ArrayList to get the specific AddressEntry object easily
                    ArrayList<AddressEntry> selectedList = new ArrayList<>();
                    int i = 1;
                    System.out.println("The following entries were found in the address book," +
                            "select number of entry you wish to remove:\n");
                    for (AddressEntry entry : selectedSet) {
                        selectedList.add(entry);
                        System.out.printf("%-3s" + entry + "\n\n", i + ":");
                        i++;
                    }
                    // Index is based on array, so choice 1 is actually 0 for ArrayList
                    int selectedIndex = keyboard.nextInt() - 1;
                    keyboard.nextLine();
                    if (selectedIndex < selectedList.size() && selectedIndex >= 0) {
                        System.out.println("Hit 'y' to remove the following entry or 'n' to return to main menu:\n");
                    }
                    System.out.printf("%-3s" + selectedList.get(selectedIndex) + "\n\n", "  ");
                    if (keyboard.nextLine().compareTo("y") == 0) {
                        addressEntryList.get(selectedList.get(selectedIndex).getLastName()).remove(selectedList.get(selectedIndex));
                    }

            } else {
                System.out.println("No entries with last name " + lastName + " were found.");
            }
        }
        catch(InputMismatchException e) {
            System.out.println("Error: You need to enter a valid integer. Please try again.");
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("Error: Invalid element selection. Please try again.");
        }

    }

    /**
     * A method which finds the desired address entry based on the user's input
     * and displays one or multiple address entries
     * @param partLastName is a string which contains either a full last name or the first part
     * of a last name in an AddressEntry
     */
    public void find(String partLastName) {

        SortedMap<String, TreeSet<address.data.AddressEntry>> usableMap;
        usableMap = addressEntryList.subMap(partLastName, partLastName + Character.MAX_VALUE);

        if(usableMap.size() > 0) {
            int i = 1;
            int j = 0;

            // Get size of SortedMap, as .size() returns 1 instead of actual number of elements
            for(Map.Entry<String, TreeSet<address.data.AddressEntry>> entry : usableMap.entrySet()) {
                for(address.data.AddressEntry item : entry.getValue()) {
                    j++;
                }
            }

            System.out.println("The following " + j +
                    " entries were found in the address book" +
                    " for a last name starting with " + "\"" + partLastName + "\"");
            for(Map.Entry<String, TreeSet<address.data.AddressEntry>> entry : usableMap.entrySet()) {
                for(address.data.AddressEntry item : entry.getValue()) {
                    System.out.printf("%-3s" + item + "\n\n", i + ":");
                    i++;
                }
            }
        }
        else
            System.out.println("There were no entries were found in the address book" +
                    " for a last name starting with " + "\"" + partLastName + "\"");

    }
}