import address.data.AddressBook;
import address.data.AddressEntry;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

public class AddressBookTest {
//  For a particular test class you should test
//  its corresponding class's methods at least 2
//  times for each method (this is a minimum)

    private static AddressEntry makeEntryA() {
        return new AddressEntry("John", "Smith", "1234 Address St", "Union City", "CA", 94587, "best1@gmail.com", "111-234-5678");
    }
    private static AddressEntry makeEntryB() {
        return new AddressEntry("Adrian", "Lester", "4321 Address St", "Fremont", "CA", 94536, "best2@gmail.com", "999-876-5432");
    }
    private static AddressEntry makeEntryC() {
        return new AddressEntry("Mary", "Smith", "5678 Address St", "San Francisco", "CA", 94101, "best3@gmail.com", "510-555-1234");
    }
    private static AddressEntry makeEntryD() {
        return new AddressEntry("Francis", "Gill", "1111 Address St", "Hayward", "CA", 94540, "best4@gmail.com", "510-555-1235");
    }


    @org.junit.jupiter.api.Test
    public void testList() {
        fail("Not yet implemented");
    }

    @org.junit.jupiter.api.Test
    public void testAdd() {

        fail("Not yet implemented");
    }

    @org.junit.jupiter.api.Test
    public void testLoadEntriesFromFile() {
        fail("Not yet implemented");
    }

    @org.junit.jupiter.api.Test
    public void testRemove() {
        fail("Not yet implemented");
    }

    @org.junit.jupiter.api.Test
    public void testFind() {
        fail("Not yet implemented");
    }
}