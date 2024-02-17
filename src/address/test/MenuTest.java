import address.data.AddressBook;
import address.data.AddressEntry;
import address.Menu;
import org.junit.jupiter.api.Test;


import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {


    // https://stackoverflow.com/questions/6415728/junit-testing-with-simulated-user-input
    // https://stackoverflow.com/questions/3894798/hide-java-output
    @Test
    public void testPrompt_FirstName() {
        InputStream sysInBackup = System.in;
        String firstName = "John";
        ByteArrayInputStream input = new ByteArrayInputStream(firstName.getBytes());
        System.setIn(input);
        assertEquals(firstName, Menu.prompt_FirstName());
        System.setIn(sysInBackup);
    }

    @Test
    public void testPrompt_LastName() {
        InputStream sysInBackup = System.in;
        String lastName = "Smith";
        ByteArrayInputStream input = new ByteArrayInputStream(lastName.getBytes());
        System.setIn(input);
        assertEquals(lastName, Menu.prompt_LastName());
        System.setIn(sysInBackup);
    }

    @Test
    public void testPrompt_Street() {
        InputStream sysInBackup = System.in;
        String street = "1234 Address St";
        ByteArrayInputStream input = new ByteArrayInputStream(street.getBytes());
        System.setIn(input);
        assertEquals(street, Menu.prompt_Street());
        System.setIn(sysInBackup);
    }

    @Test
    public void testPrompt_City() {
        InputStream sysInBackup = System.in;
        String city = "Hayward";
        ByteArrayInputStream input = new ByteArrayInputStream(city.getBytes());
        System.setIn(input);
        assertEquals(city, Menu.prompt_City());
        System.setIn(sysInBackup);
    }

    @Test
    public void testPrompt_State() {
        InputStream sysInBackup = System.in;
        String state = "CA";
        ByteArrayInputStream input = new ByteArrayInputStream(state.getBytes());
        System.setIn(input);
        assertEquals(state, Menu.prompt_State());
        System.setIn(sysInBackup);
    }

    @Test
    public void testPrompt_Zip() {
        InputStream sysInBackup = System.in;
        String zip = "94586";
        ByteArrayInputStream input = new ByteArrayInputStream(zip.getBytes());
        System.setIn(input);
        assertEquals(Integer.parseInt(zip), Menu.prompt_Zip());
        System.setIn(sysInBackup);
    }

    @Test
    public void testPrompt_Telephone() {
        InputStream sysInBackup = System.in;
        String telephone = "510-555-1234";
        ByteArrayInputStream input = new ByteArrayInputStream(telephone.getBytes());
        System.setIn(input);
        assertEquals(telephone, Menu.prompt_Telephone());
        System.setIn(sysInBackup);
    }

    @Test
    public void testPrompt_Email() {
        InputStream sysInBackup = System.in;
        String email = "best1@gmail.com";
        ByteArrayInputStream input = new ByteArrayInputStream(email.getBytes());
        System.setIn(input);
        assertEquals(email, Menu.prompt_Telephone());
        System.setIn(sysInBackup);
    }

    // https://stackoverflow.com/questions/246038/unit-testing-void-methods
    @Test
    public void testDisplayMenu() {

            Menu.displayMenu();
            return; // indicates success

    }
}