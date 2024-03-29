package address.data;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is used to test the AddressEntry class to make sure it works properly.
 * @author Jared Ferriols
 * @since JDK 17
 * @version 1.2
 */

public class AddressEntryTest {

    /**
     * A preloaded object of AddressEntry for AddressEntryTest methods
     */
    private static AddressEntry makeEntryA() {
        return new AddressEntry("John", "Smith", "1234 Address St", "Union City", "CA", 94587, "111-234-5678", "best1@gmail.com");
    }
    /**
     * A preloaded object of AddressEntry for AddressEntryTest methods
     */
    private static AddressEntry makeEntryB() {
        return new AddressEntry("Adrian", "Lester", "4321 Address St", "Fremont", "CA", 94536, "999-876-5432", "best2@gmail.com");
    }
    /**
     * A preloaded object of AddressEntry for AddressEntryTest methods
     */
    private static AddressEntry makeEntryC() {
        return new AddressEntry("Mary", "Smith", "5678 Address St", "San Francisco", "CA", 94101, "510-555-1234", "best3@gmail.com");
    }
    /**
     * A preloaded object of AddressEntry for AddressEntryTest methods
     */
    private static AddressEntry makeEntryD() {
        return new AddressEntry("Francis", "Gill", "1111 Address St", "Hayward", "CA", 94540, "510-555-1235", "best4@gmail.com");
    }


    /**
     * Test method for {@link AddressEntry#AddressEntry()}
     */
    @Test
    public void testAddressEntry() {
        AddressEntry a1 = makeEntryA();
        String expected1 = "John, Smith\n\t1234 Address St\n\tUnion City, CA 94587\n\tbest1@gmail.com\n\t111-234-5678";
        assertEquals(expected1, a1.toString());

        AddressEntry a2 = makeEntryC();
        String expected2 = "Mary, Smith\n\t5678 Address St\n\tSan Francisco, CA 94101\n\tbest3@gmail.com\n\t510-555-1234";
        assertEquals(expected2, a2.toString());
    }


    /**
     * Test method for {@link AddressEntry#toString()}.
     */
    @Test
    public void testToString() {

        assertEquals(makeEntryA().toString(), "John, Smith\n\t1234 Address St\n\tUnion City, CA 94587\n\tbest1@gmail.com\n\t111-234-5678");
        assertEquals(makeEntryB().toString(), "Adrian, Lester\n\t4321 Address St\n\tFremont, CA 94536\n\tbest2@gmail.com\n\t999-876-5432");
    }

    /**
     * Test method for {@link AddressEntry#compareTo(AddressEntry)}.
     */
    @Test
    public void testCompareTo() {
        AddressEntry aa = makeEntryA();
        AddressEntry bb = makeEntryA();
        AddressEntry cc = makeEntryB();
        AddressEntry dd = makeEntryC();
        AddressEntry ee = makeEntryD();


        assertEquals(aa.compareTo(bb), 0);
        assertTrue(aa.compareTo(cc) > 0);
        assertTrue(ee.compareTo(dd) < 0);
    }
    /**
     * Test method for {@link AddressEntry#setFirstName(java.lang.String)}
     */
    @Test
    public void testSetFirstName() {
        AddressEntry entryA = makeEntryA();
        entryA.setFirstName("Johnathan");
        assertEquals(entryA.getFirstName(), "Johnathan");
        AddressEntry entryB = makeEntryB();
        entryB.setFirstName("Adri");
        assertEquals(entryB.getFirstName(), "Adri");
        AddressEntry entryC = makeEntryC();
        entryC.setFirstName("Mari");
        assertEquals(entryC.getFirstName(), "Mari");

    }

    /**
     * Test method for {@link AddressEntry#setLastName(java.lang.String)}
     */
    @Test
    public void testSetLastName() {
        AddressEntry entryA = makeEntryA();
        entryA.setLastName("Smithy");
        assertEquals(entryA.getLastName(), "Smithy");
        AddressEntry entryB = makeEntryB();
        entryB.setLastName("Lest");
        assertEquals(entryB.getLastName(), "Lest");
        AddressEntry entryC = makeEntryC();
        entryC.setLastName("Smit");
        assertEquals(entryC.getLastName(), "Smit");

    }

    /**
     * Test method for {@link AddressEntry#setStreet(java.lang.String)}
     */
    @Test
    public void testSetStreet() {
        AddressEntry entryA = makeEntryA();
        entryA.setStreet("1239 Address St");
        assertEquals(entryA.getStreet(), "1239 Address St");
        AddressEntry entryB = makeEntryB();
        entryB.setStreet("2222 Address St");
        assertEquals(entryB.getStreet(), "2222 Address St");
        AddressEntry entryC = makeEntryC();
        entryC.setStreet("3333 Address St");
        assertEquals(entryC.getStreet(), "3333 Address St");


    }

    /**
     * Test method for {@link AddressEntry#setCity(java.lang.String)}
     */
    @Test
    public void testSetCity() {
        AddressEntry entryA = makeEntryA();
        entryA.setCity("Adelanto");
        assertEquals(entryA.getCity(), "Adelanto");
        AddressEntry entryB = makeEntryB();
        entryB.setCity("Los Angeles");
        assertEquals(entryB.getCity(), "Los Angeles");
        AddressEntry entryC = makeEntryC();
        entryC.setCity("Albany");
        assertEquals(entryC.getCity(), "Albany");


    }

    /**
     * Test method for {@link AddressEntry#setZip(int)}
     */
    @Test
    public void testSetZip() {
        AddressEntry entryA = makeEntryA();
        entryA.setZip(11111);
        assertEquals(entryA.getZip(), 11111);
        AddressEntry entryB = makeEntryB();
        entryB.setZip(11112);
        assertEquals(entryB.getZip(), 11112);
        AddressEntry entryC = makeEntryC();
        entryC.setZip(11113);
        assertEquals(entryC.getZip(), 11113);


    }

    /**
     * Test method for {@link AddressEntry#setPhone(java.lang.String)}
     */
    @Test
    public void testSetPhone() {
        AddressEntry entryA = makeEntryA();
        entryA.setPhone("111-111-1111");
        assertEquals(entryA.getPhone(), "111-111-1111");
        AddressEntry entryB = makeEntryB();
        entryB.setPhone("222-222-2222");
        assertEquals(entryB.getPhone(), "222-222-2222");
        AddressEntry entryC = makeEntryC();
        entryC.setPhone("333-333-3333");
        assertEquals(entryC.getPhone(), "333-333-3333");
    }

    /**
     * Test method for {@link AddressEntry#setEmail(java.lang.String)}
     */
    @Test
    public void testSetEmail() {
        AddressEntry entryA = makeEntryA();
        entryA.setEmail("ultimatebest1@gmail.com");
        assertEquals(entryA.getEmail(), "ultimatebest1@gmail.com");
        AddressEntry entryB = makeEntryB();
        entryB.setEmail("ultimatebest2@gmail.com");
        assertEquals(entryB.getEmail(), "ultimatebest2@gmail.com");
        AddressEntry entryC = makeEntryC();
        entryC.setEmail("ultimatebest3@gmail.com");
        assertEquals(entryC.getEmail(), "ultimatebest3@gmail.com");
    }

    /**
     * Test method for {@link AddressEntry#setState(java.lang.String)}
     */
    @Test
    public void testSetState() {
        AddressEntry entryA = makeEntryA();
        entryA.setState("AL");
        assertEquals(entryA.getState(), "AL");
        AddressEntry entryB = makeEntryB();
        entryB.setState("AK");
        assertEquals(entryB.getState(), "AK");
        AddressEntry entryC = makeEntryC();
        entryC.setState("AR");
        assertEquals(entryC.getState(), "AR");
    }

    /**
     * Test method for {@link AddressEntry#getFirstName()}
     */
    @Test
    public void testGetFirstName() {
        assertEquals("John", makeEntryA().getFirstName());
        assertEquals("Adrian", makeEntryB().getFirstName());
        assertEquals("Mary", makeEntryC().getFirstName());
        assertEquals("Francis", makeEntryD().getFirstName());
        assertNotEquals("Johnn", makeEntryA().getFirstName());
        assertNotEquals("Adriann", makeEntryB().getFirstName());
        assertNotEquals("Maryy", makeEntryC().getFirstName());
        assertNotEquals("Franciss", makeEntryD().getFirstName());
    }

    /**
     * Test method for {@link AddressEntry#getLastName()}
     */
    @Test
    public void testGetLastName() {
        assertEquals("Smith", makeEntryA().getLastName());
        assertEquals("Lester", makeEntryB().getLastName());
        assertEquals("Smith", makeEntryC().getLastName());
        assertEquals("Gill", makeEntryD().getLastName());
        assertNotEquals("Smithh", makeEntryA().getLastName());
        assertNotEquals("Lesterr", makeEntryB().getLastName());
        assertNotEquals("Smithh", makeEntryC().getLastName());
        assertNotEquals("Gilll", makeEntryD().getLastName());
    }

    /**
     * Test method for {@link AddressEntry#getStreet()}
     */
    @Test
    public void testGetStreet() {
        assertEquals("1234 Address St", makeEntryA().getStreet());
        assertEquals("4321 Address St", makeEntryB().getStreet());
        assertEquals("5678 Address St", makeEntryC().getStreet());
        assertEquals("1111 Address St", makeEntryD().getStreet());
        assertNotEquals("1235 Address St", makeEntryA().getStreet());
        assertNotEquals("4322 Address St", makeEntryB().getStreet());
        assertNotEquals("5679 Address St", makeEntryC().getStreet());
        assertNotEquals("1112 Address St", makeEntryD().getStreet());
    }

    /**
     * Test method for {@link AddressEntry#getCity()}
     */
    @Test
    public void testGetCity() {
        assertEquals("Union City", makeEntryA().getCity());
        assertEquals("Fremont", makeEntryB().getCity());
        assertEquals("San Francisco", makeEntryC().getCity());
        assertEquals("Hayward", makeEntryD().getCity());
        assertNotEquals("Oakland", makeEntryA().getCity());
        assertNotEquals("Alameda", makeEntryB().getCity());
        assertNotEquals("San Bernardino", makeEntryC().getCity());
        assertNotEquals("Los Angeles", makeEntryD().getCity());
    }

    /**
     * Test method for {@link AddressEntry#getState()}
     */
    @Test
    public void testGetState() {
        assertEquals(makeEntryA().getState(), "CA");
        assertEquals(makeEntryB().getState(), "CA");
        assertEquals(makeEntryC().getState(), "CA");
        assertEquals(makeEntryD().getState(), "CA");
        assertNotEquals(makeEntryA().getState(), "WA");
        assertNotEquals(makeEntryB().getState(), "WA");
        assertNotEquals(makeEntryC().getState(), "WA");
        assertNotEquals(makeEntryD().getState(), "WA");
    }

    /**
     * Test method for {@link AddressEntry#getZip()}
     */
    @Test
    public void testGetZip() {
        assertEquals(makeEntryA().getZip(), 94587);
        assertEquals(makeEntryB().getZip(), 94536);
        assertEquals(makeEntryC().getZip(), 94101);
        assertEquals(makeEntryD().getZip(), 94540);
        assertNotEquals(makeEntryA().getZip(), 94588);
        assertNotEquals(makeEntryB().getZip(), 94537);
        assertNotEquals(makeEntryC().getZip(), 94102);
        assertNotEquals(makeEntryD().getZip(), 94541);


    }

    /**
     * Test method for {@link AddressEntry#getPhone()}
     */
    @Test
    public void testGetPhone() {

        assertEquals(makeEntryA().getPhone(), "111-234-5678");
        assertEquals(makeEntryB().getPhone(), "999-876-5432");
        assertEquals(makeEntryC().getPhone(), "510-555-1234");
        assertEquals(makeEntryD().getPhone(), "510-555-1235");

        assertNotEquals(makeEntryA().getPhone(), "111-234-5679");
        assertNotEquals(makeEntryB().getPhone(), "999-876-5433");
        assertNotEquals(makeEntryC().getPhone(), "510-555-1235");
        assertNotEquals(makeEntryD().getPhone(), "510-555-1236");
    }

    /**
     * Test method for {@link AddressEntry#getEmail()}
     */
    @Test
    public void testGetEmail() {
        assertEquals(makeEntryA().getEmail(), "best1@gmail.com");
        assertEquals(makeEntryB().getEmail(), "best2@gmail.com");
        assertEquals(makeEntryC().getEmail(), "best3@gmail.com");
        assertEquals(makeEntryD().getEmail(), "best4@gmail.com");
        assertNotEquals(makeEntryA().getEmail(), "best5@gmail.com");
        assertNotEquals(makeEntryB().getEmail(), "best6@gmail.com");
        assertNotEquals(makeEntryC().getEmail(), "best7@gmail.com");
        assertNotEquals(makeEntryD().getEmail(), "best8@gmail.com");
    }
}