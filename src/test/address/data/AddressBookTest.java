package address.data;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is used to test the AddressBook class to make sure it works properly.
 * @author Jared Ferriols
 * @since JDK 17
 * @version 1.2
 */
public class AddressBookTest {

    /**
     * A preloaded object of AddressEntry to load into AddressBook
     */
    private static AddressEntry makeEntryA() {
        return new AddressEntry("John", "Smith", "1234 Address St", "Union City", "CA", 94587, "best1@gmail.com", "111-234-5678");
    }
    /**
     * A preloaded object of AddressEntry to load into AddressBook
     */
    private static AddressEntry makeEntryB() {
        return new AddressEntry("Adrian", "Lester", "4321 Address St", "Fremont", "CA", 94536, "best2@gmail.com", "999-876-5432");
    }
    /**
     * A preloaded object of AddressEntry to load into AddressBook
     */
    private static AddressEntry makeEntryC() {
        return new AddressEntry("Mary", "Smith", "5678 Address St", "San Francisco", "CA", 94101, "best3@gmail.com", "510-555-1234");
    }


    /**
     * Test method for {@link AddressBook#list()}
     */
    @org.junit.jupiter.api.Test
    public void testList() {
        AddressBook ab = new AddressBook();
        ByteArrayOutputStream output1 = new ByteArrayOutputStream();
        ByteArrayOutputStream output2 = new ByteArrayOutputStream();
        PrintStream ps1 = new PrintStream(output1);
        PrintStream ps2 = new PrintStream(output2);

        ab.add(makeEntryA());
        String expected1 = "";
        expected1 += "1: John, Smith\n\t1234 Address St\n\tUnion City, CA 94587\n\t111-234-5678\n\tbest1@gmail.com\n";


        PrintStream old1 = System.out;
        System.setOut(ps1);

        ab.list();
        System.out.flush();
        System.setOut(old1);

        assertEquals(expected1, output1.toString());

        ab.add(makeEntryB());
        String expected2 = "";
        expected2 += "1: Adrian, Lester\n\t4321 Address St\n\tFremont, CA 94536\n\t999-876-5432\n\tbest2@gmail.com\n";
        expected2 += "2: John, Smith\n\t1234 Address St\n\tUnion City, CA 94587\n\t111-234-5678\n\tbest1@gmail.com\n";

        PrintStream old2 = System.out;
        System.setOut(ps2);
        ab.list();
        System.out.flush();
        System.setOut(old2);

        assertEquals(expected2, output2.toString());
    }

    /**
     * Test method for {@link AddressBook#add(AddressEntry)}
     */
    @org.junit.jupiter.api.Test
    public void testAdd() {
        AddressBook ab = new AddressBook();
        ByteArrayOutputStream output1 = new ByteArrayOutputStream();
        ByteArrayOutputStream output2 = new ByteArrayOutputStream();
        PrintStream ps1 = new PrintStream(output1);
        PrintStream ps2 = new PrintStream(output2);

        ab.add(makeEntryC());
        String expected1 = "";
        expected1 += "1: Mary, Smith\n\t5678 Address St\n\tSan Francisco, CA 94101\n\t510-555-1234\n\tbest3@gmail.com\n";

        PrintStream old1 = System.out;
        System.setOut(ps1);

        ab.list();
        System.out.flush();
        System.setOut(old1);

        assertEquals(expected1, output1.toString());

        ab.add(makeEntryB());
        String expected2 = "";
        expected2 += "1: Adrian, Lester\n\t4321 Address St\n\tFremont, CA 94536\n\t999-876-5432\n\tbest2@gmail.com\n";
        expected2 += "2: Mary, Smith\n\t5678 Address St\n\tSan Francisco, CA 94101\n\t510-555-1234\n\tbest3@gmail.com\n";

        PrintStream old2 = System.out;
        System.setOut(ps2);
        ab.list();
        System.out.flush();
        System.setOut(old2);

        assertEquals(expected2, output2.toString());
    }

    /**
     * Test method for {@link AddressBook#loadEntriesFromFile(java.lang.String)}
     */
    @org.junit.jupiter.api.Test
    public void testLoadEntriesFromFile() {
        AddressBook ab = new AddressBook();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);

        ab.loadEntriesFromFile("testFile.txt");
        String expected1 = "";
        expected1 += "1: Adrian, Lester\n\t4321 Address St\n\tFremont, CA 94536\n\t999-876-5432\n\tbest2@gmail.com\n";
        expected1 += "2: John, Smith\n\t1234 Address St\n\tUnion City, CA 94587\n\t111-234-5678\n\tbest1@gmail.com\n";
        expected1 += "3: Mary, Smith\n\t5678 Address St\n\tSan Francisco, CA 94101\n\t510-555-1234\n\tbest3@gmail.com\n";

        PrintStream old = System.out;
        System.setOut(ps);
        String input1 = "y";
        ByteArrayInputStream input2 = new ByteArrayInputStream(input1.getBytes());
        System.setIn(input2);
        ab.list();
        System.out.flush();
        System.setOut(old);

        assertEquals(expected1, output.toString());

    }

    /**
     * Test method for {@link AddressBook#remove(java.lang.String)}
     */
    @org.junit.jupiter.api.Test
    public void testRemove() {
        AddressBook ab = new AddressBook();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        ab.add(makeEntryB());
        String result1 = "The following entry was found in the address book.\r\n" +
                "   " + makeEntryB().toString() + "\n" + "Hit 'y' to remove the entry or 'n' to return to main menu\r\n";
        String input1 = "y";
        ByteArrayInputStream input2 = new ByteArrayInputStream(input1.getBytes());
        System.setIn(input2);
        PrintStream old = System.out;
        System.setOut(ps);
        ab.remove("L");
        System.out.flush();
        System.setOut(old);
        assertEquals(result1, output.toString());



    }

    /**
     * Test method for {@link AddressBook#find(java.lang.String)}
     */
    @org.junit.jupiter.api.Test
    public void testFind() {
        AddressBook ab = new AddressBook();
        ab.loadEntriesFromFile("testFile.txt");
        ByteArrayOutputStream output1 = new ByteArrayOutputStream();
        ByteArrayOutputStream output2 = new ByteArrayOutputStream();
        ByteArrayOutputStream output3 = new ByteArrayOutputStream();
        ByteArrayOutputStream output4 = new ByteArrayOutputStream();
        PrintStream ps1 = new PrintStream(output1);
        PrintStream ps2 = new PrintStream(output2);
        PrintStream ps3 = new PrintStream(output3);
        PrintStream ps4 = new PrintStream(output4);

        String input1 = "";
        String input2 = "A";
        String input3 = "L";
        String input4 = "S";

        String result1 = "The following 3 entries were found in the address book" +
                " for a last name starting with \"\"\r\n" + "1: " + makeEntryB().toString() + "\n\n"
                + "2: " + makeEntryA().toString() + "\n\n" + "3: " + makeEntryC().toString() + "\n\n";

        String result2 = "There were no entries were found in the address book" +
                " for a last name starting with " + "\"" + input2 + "\"\r\n";
        String result3 = "The following 1 entries were found in the address book" +
                " for a last name starting with " + "\"" + input3 + "\"\r\n" + "1: " + makeEntryB().toString() + "\n\n";
        String result4 = "The following 2 entries were found in the address book" +
                " for a last name starting with " + "\"" + input4 + "\"\r\n" + "1: " + makeEntryA().toString() + "\n\n"
                + "2: " + makeEntryC().toString() + "\n\n";


        PrintStream old1 = System.out;
        System.setOut(ps1);
        ab.find(input1);
        assertEquals(result1, output1.toString());
        System.out.flush();
        System.setOut(old1);

        PrintStream old2 = System.out;
        System.setOut(ps2);
        ab.find(input2);
        assertEquals(result2, output2.toString());
        System.out.flush();
        System.setOut(old2);

        PrintStream old3 = System.out;
        System.setOut(ps3);
        ab.find(input3);
        assertEquals(result3, output3.toString());
        System.out.flush();
        System.setOut(old3);

        PrintStream old4 = System.out;
        System.setOut(ps4);
        ab.find(input4);
        assertEquals(result4, output4.toString());
        System.out.flush();
        System.setOut(old4);

    }

}