
package address.data;



// https://stackoverflow.com/questions/8699195/cannot-be-cast-to-java-lang-comparable
// https://stackoverflow.com/questions/3718383/why-should-a-java-class-implement-comparable

/**
 * The AddressEntry class represents a generic Address Entry used to store all the information or data
 * for a user's address entry.
 * @author Jared Ferriols
 * @since Jan. 25, 2023
 * @version 1.0
 */
public class AddressEntry implements Comparable<AddressEntry>{


    /**
     * The first name of this contact.
     */
    private String firstName;
    /**
     * The last name of this contact.
     */
    private String lastName;
    /**
     * The street name of the contact.
     */
    private String street;

    /**
     * The city of the contact.
     */
    private String city;

    /**
     * The state of the contact.
     */
    private String state;

    /**
     * The zip of the contact.
     */
    private Integer zip;

    /**
     * The phone number of the contact.
     */
    private String phone;

    /**
     * The email address of this contact
     */
    private String email;

    /** The empty AddressEntry constructor
     * This initializes the values in terms of empty strings and empty values (not null)
     */
    public AddressEntry(){
        this("","","","","",0,"","");
    }

    /** The AddressEntry constructor
     * This initializes the values with the data provided in the parameters.
     * @param firstName is a firstname
     * @param lastName is a lastname
     * @param street is a street
     * @param city is a city
     * @param state is a state
     * @param zip is a zip code
     * @param phone is a phone number
     * @param email is an email
     * @returns nothing
     */
    public AddressEntry(String firstName, String lastName, String street, String city, String state, int zip, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }


    /** Takes data elements and composes a nicely formatted string from its values and returns this string
     * @param nothing
     * @return a formatted string of the data
     */
    // @Override
    public String toString(){
        return firstName + ", " + lastName + '\n'
                + '\t' + street + '\n' + '\t'
                + city + ", " + state + " " + zip
                + '\n' + '\t' + email + '\n'
                + '\t' + phone;
    }

    /**
     * Used to properly add elements in the TreeMap for the add module in AddressBook
     * as it needs to "return" a boolean value in TreeSet<AddressEntry>add().
     * @param AddressEntry an AddressEntry object
     * @return a boolean value of 0 and 1, it compares the data of the address entry from last name
     * to zip code.
     */
    public int compareTo(AddressEntry other) {
        if(this.lastName.compareTo(other.lastName) != 0) {
            return this.lastName.compareTo(other.lastName);
        }
        else if(this.firstName.compareTo(other.firstName) == 0 &&
                this.city.compareTo(other.city) == 0 &&
                this.phone.compareTo(other.phone) == 0 &&
                this.state.compareTo(other.state) == 0 &&
                this.street.compareTo(other.street) == 0 &&
                this.email.compareTo(other.email) == 0 &&
                this.zip.compareTo(other.zip) == 0) {
            return 0;
        }
        else
            return 1;
    }

    /**
     * Method used to set the first name of the address entry
     * @param firstName is a first name
     * @returns nothing
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Method used to set the last name of the address entry
     * @param lastName is a last name
     * @returns nothing
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Method used to set the street of the address entry
     * @param street is a street
     * @returns nothing
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Method used to set the city of the address entry
     * @param city is a city
     * @returns nothing
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Method used to set the zip code of the address entry
     * @param zip is a zip code
     * @returns nothing
     */
    public void setZip(int zip) {
        this.zip= zip;
    }

    /**
     * Method used to set the phone number of the address entry
     * @param phone is a phone number
     * @returns nothing
     */
    public void setPhone(String phone) {
        this.phone= phone;
    }

    /**
     * Method used to set the email of the address entry
     * @param email is an email address
     * @returns nothing
     */
    public void setEmail(String email) {
        this.email= email;
    }

    /**
     * Method used to set the state of the address entry
     * @param state is a state
     * @returns nothing
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Method used to get the first name of the address entry as a string
     * @param nothing
     * @returns a String which represents the first name of a person
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Method used to get the first name of the address entry as a string
     * @param nothing
     * @returns a String which represents the last name of a person
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method used to get the street of the address entry as a string
     * @param nothing
     * @returns a String which represents the street name where the person lives at
     */
    public String getStreet() {
        return street;
    }

    /**
     * Method used to get the city of the address entry as a string
     * @param nothing
     * @returns a String which represents the city name or the large town where the person lives at
     */
    public String getCity() {
        return city;
    }

    /**
     * Method used to get the state of the address entry as a string
     * @param nothing
     * @returns a String which represents the state name or the small nation where the person lives at
     */
    public String getState() {
        return state;
    }
    /**
     * Method used to get the zip of the address entry as a string
     * @param nothing
     * @returns a String which represents the zip area code of a person
     */
    public int getZip() {
        return zip;
    }

    /**
     * Method used to get the phone number of the address entry as a string
     * @param nothing
     * @returns a String which represents the phone number of the person to directly call
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Method used to get the email of the address entry as a string
     * @param nothing
     * @returns a String which represents the email of the person to message information electronically
     */
    public String getEmail() {
        return email;
    }
}





