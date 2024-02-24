package address;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is used to test the Menu class to make sure it works properly.
 * @author Jared Ferriols
 * @since JDK 17
 * @version 1.2
 */

public class MenuTest {

    /**
     * Test method for {@link Menu#prompt_FirstName()}
     */
    @Test
    public void testPrompt_FirstName() {
        InputStream sysInBackup = System.in;
        String firstName = "John";
        ByteArrayInputStream input = new ByteArrayInputStream(firstName.getBytes());
        System.setIn(input);
        assertEquals(firstName, Menu.prompt_FirstName());
        System.setIn(sysInBackup);
    }

    /**
     * Test method for {@link Menu#prompt_LastName()}
     */
    @Test
    public void testPrompt_LastName() {
        InputStream sysInBackup = System.in;
        String lastName = "Smith";
        ByteArrayInputStream input = new ByteArrayInputStream(lastName.getBytes());
        System.setIn(input);
        assertEquals(lastName, Menu.prompt_LastName());
        System.setIn(sysInBackup);
    }

    /**
     * Test method for {@link Menu#prompt_Street()}
     */
    @Test
    public void testPrompt_Street() {
        InputStream sysInBackup = System.in;
        String street = "1234 Address St";
        ByteArrayInputStream input = new ByteArrayInputStream(street.getBytes());
        System.setIn(input);
        assertEquals(street, Menu.prompt_Street());
        System.setIn(sysInBackup);
    }

    /**
     * Test method for {@link Menu#prompt_City()}
     */
    @Test
    public void testPrompt_City() {
        InputStream sysInBackup = System.in;
        String city = "Hayward";
        ByteArrayInputStream input = new ByteArrayInputStream(city.getBytes());
        System.setIn(input);
        assertEquals(city, Menu.prompt_City());
        System.setIn(sysInBackup);
    }

    /**
     * Test method for {@link Menu#prompt_State()}
     */
    @Test
    public void testPrompt_State() {
        InputStream sysInBackup = System.in;
        String state = "CA";
        ByteArrayInputStream input = new ByteArrayInputStream(state.getBytes());
        System.setIn(input);
        assertEquals(state, Menu.prompt_State());
        System.setIn(sysInBackup);
    }

    /**
     * Test method for {@link Menu#prompt_Zip()}
     */
    @Test
    public void testPrompt_Zip() {
        InputStream sysInBackup = System.in;
        String zip = "94586";
        ByteArrayInputStream input = new ByteArrayInputStream(zip.getBytes());
        System.setIn(input);
        assertEquals(Integer.parseInt(zip), Menu.prompt_Zip());
        System.setIn(sysInBackup);
    }

    /**
     * Test method for {@link Menu#prompt_Telephone()}
     */
    @Test
    public void testPrompt_Telephone() {
        InputStream sysInBackup = System.in;
        String telephone = "510-555-1234";
        ByteArrayInputStream input = new ByteArrayInputStream(telephone.getBytes());
        System.setIn(input);
        assertEquals(telephone, Menu.prompt_Telephone());
        System.setIn(sysInBackup);
    }

    /**
     * Test method for {@link Menu#prompt_Email()}
     */
    @Test
    public void testPrompt_Email() {
        InputStream sysInBackup = System.in;
        String email = "best1@gmail.com";
        ByteArrayInputStream input = new ByteArrayInputStream(email.getBytes());
        System.setIn(input);
        assertEquals(email, Menu.prompt_Email());
        System.setIn(sysInBackup);
    }

    /**
     * Test method for {@link Menu#displayMenu()}
     */
    @Test
    public void testDisplayMenu() {

        ByteArrayOutputStream output1 = new ByteArrayOutputStream();
        PrintStream ps1 = new PrintStream(output1);
        String expected1 = """
                *************************
                Please enter your menu selection
                a) Loading From File
                b) Addition
                c) Removal
                d) Find
                e) Listing
                f) Quit
                *************************
                """;

        PrintStream old = System.out;
        System.setOut(ps1);

        Menu.displayMenu();

        System.out.flush();
        System.setOut(old);

        assertEquals(expected1, output1.toString());

    }
}