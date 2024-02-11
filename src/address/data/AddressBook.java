
package address.data;


import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;


/** AddressBook: purpose is to represent an address book.
 * It is used to access and store multiple AddressEntry objects in one object.
 */

/**The AddressBook class represents a generic Address Book used to store multiple Address entries
 * for the user to add, remove, or look up.
 * @author Jared Ferriols
 * @since Jan. 25, 2023
 * @version 1.0
 */
// https://stackoverflow.com/questions/58113842/java-collections-use-treeset-as-value-for-treemap
// https://www.geeksforgeeks.org/treemap-values-method-in-java-with-examples/
// https://www.geeksforgeeks.org/treeset-in-java-with-examples/
// https://stackoverflow.com/questions/10937667/incompatible-types-sortedset-and-treeset
// https://www.geeksforgeeks.org/how-to-fix-java-lang-classcastexception-in-treeset/
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
     * @returns nothing, It is a void function, but it prints out a string on the console.
     */

    public void list() {
        // addressEntryList.values().forEach();
        // https://www.javacodeexamples.com/java-stringbuilder-tutorial-with-examples/1622
        // System.out.print(addressEntryList.entrySet());
        // https://stackoverflow.com/questions/1318980/how-to-iterate-over-a-treemap
        // https://www.geeksforgeeks.org/how-to-iterate-over-a-treemap-in-java/
        //https://stackoverflow.com/questions/43688506/how-to-format-the-output-of-a-treemap
        // https://stackoverflow.com/questions/13131890/for-each-loop-for-nested-tree-map
        // https://stackoverflow.com/questions/7278128/formatting-string-in-java-using-return-string-format
        // https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html

        // StringBuilder object used to make String class object
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
     * A method which adds an address entry object to the address book
     *
     * @param entry entry is an object of AddressEntry to add in the AddressBook
     * @returns nothing
     **/
    // https://www.baeldung.com/java-map-putifabsent-computeifabsent
    // https://stackoverflow.com/questions/65421001/treemapstring-new-treemapstring-integer-treemap-with-object
    public void add(AddressEntry newEntry0) {

        // java: incompatible types: boolean cannot be converted to java.util.TreeSet<address.data.AddressEntry>
        // TreeSet<AddressEntry> aETSet = new TreeSet<AddressEntry>();
        // addressEntryList.put(newEntry0.getLastName(), aETSet.add(newEntry0));

        // java: incompatible types: address.data.AddressEntry cannot be converted to java.util.TreeSet<address.data.AddressEntry>
        // addressEntryList.put(newEntry0.getLastName(), newEntry0);

        // Need to override compareTo for this one...
        // needs Boolean value? from add()

        // Exception in thread "main" java.lang.ClassCastException:
        // class address.data.AddressEntry cannot be cast to class
        // java.lang.Comparable (address.data.AddressEntry is in unnamed
        // module of loader 'app'; java.lang.Comparable is in module
        // java.base of loader 'bootstrap')

        // Add in contacts in a TreeMap<String, TreeSet<AddressEntry>> by checking
        // if the contents is already in the set
        addressEntryList.computeIfAbsent(newEntry0.getLastName(), k -> new TreeSet<>()).add(newEntry0);
    }

    public void loadEntriesFromFile(String fileName) {

        // https://stackoverflow.com/questions/25596985/java-unreported-exception-java-io-filenotfoundexception-must-be-caught-or-decl
        // https://stackoverflow.com/questions/32553871/java-wont-read-an-int-from-a-file
        // https://www.digitalocean.com/community/tutorials/java-read-file-line-by-line
        try{
            File file = new File(fileName);
            FileReader fReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fReader);
            String fileLine;

            // read strings except for zip, which is an int
            // firstName + lastName + street +  city + state +  zip + email +  phone;
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

    public void remove(String lastName) {

        // get entry sets based on first character of last name
        try {
            // try to remove entry sets based on size, or else there is no entry set
        }
        catch(InputMismatchException e) {
            System.out.println("Error: You need to enter a valid integer. Please try again.");
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("Error: Invalid element selection. Please try again.");
        }

    }

    public void find(String lastName) {

        // https://www.geeksforgeeks.org/stream-in-java/


        if(addressEntryList.size() > 0) {
            int i = 1;
            
            System.out.println("The following " + addressEntryList.values().stream().count() +
                    " entries were found in the address book" +
                    " for a last name starting with " + "\"" + lastName + "\"");
            for(Map.Entry<String, TreeSet<AddressEntry>> entry : addressEntryList.entrySet()) {
                for(AddressEntry item : entry.getValue()) {
                    System.out.printf("%-3s" + item + "\n\n", i + ":");
                    i++;
                }
            }
        }
        else
            System.out.println("There were no entries were found in the address book" +
                    " for a last name starting with " + "\"" + lastName + "\"");

    }
}