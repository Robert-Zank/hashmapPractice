package hashmapPractice;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Address class for use in CSE 274 Programming Project.
 * @author Dr. Johnson
 * September 8 ,2022
 *
 */
public class Address implements Comparable<Address>
{

    //attributes of the address
    private String firstName;
    private String lastName;
    private int zipcode;
    private String streetAddress;
    private String phoneNumber;
    
    
    /**
     * Default Constructor
     */
    public Address()
    {
        // do nothing - all variables equal null until set methods called.
       
    }

    /**
     * Constructor with initialization of all attributes
     * 
     * @param firstName
     * @param lastName
     * @param zipcode
     * @param streetAddress
     * @param phoneNumber
     */
    public Address(String firstName, String lastName, int zipcode, String streetAddress, String phoneNumber)
    {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipcode = zipcode;
        this.streetAddress = streetAddress;
        this.phoneNumber = phoneNumber;
    } 
    
    
    /**
     * Getter method for first name
     * 
     * @return the firstName
     */
    public String getFirstName()
    {
        return firstName;
    }


    /**
     * Setter method for first name
     * 
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }


    /**
     * Getter method for last name
     * 
     * @return the lastName
     */
    public String getLastName()
    {
        return lastName;
    }


    /**
     * Setter method for last name
     * 
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }


    /**
     * Getter method for zip code
     * 
     * @return the zipcode
     */
    public int getZipcode()
    {
        return zipcode;
    }


    /**
     * Setter method for zip code
     * 
     * @param zipcode the zipcode to set
     */
    public void setZipcode(int zipcode)
    {
        this.zipcode = zipcode;
    }


    /**
     * Getter metho for street address
     * 
     * @return the streetAddress
     */
    public String getStreetAddress()
    {
        return streetAddress;
    }


    /**
     * Setter method for street address
     * 
     * @param streetAddress the streetAddress to set
     */
    public void setStreetAddress(String streetAddress)
    {
        this.streetAddress = streetAddress;
    }


    /**
     * Getter method for phone number
     * 
     * @return the phoneNumber
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }


    /**
     * Setter method for phone number
     * 
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }


    @Override
    /**
     * CompareTo method to allow two addresses to be compared to each other. Required
     * method to implement Comparable interface.
     * 
     * @param Address
     */
    public int compareTo(Address o)
    {
        // we will sort only on first and last name
        // assumes no two entries have the same first and last name
        if (this.firstName.equals(o.firstName) && this.lastName.equals(o.lastName))
        {
            // they are equal- return 0
            return 0;
        }
        else if (this.lastName.equals(o.lastName))
        {
            // if the last names are equal - sort based on first name
            // since firstName is a String - use the String compareTo method
            return this.firstName.compareTo(o.firstName);
        }
        else
        {
            // not equal and last names are different- sort on last name
            return this.lastName.compareTo(o.lastName);
        }
       
    }

    @Override
    /**
     * Method to return a user friendly looking string of address data
     * for printing
     * 
     * @return String
     */
    public String toString()
    {
        return   firstName + " " + lastName + "\n" + streetAddress + "\n" + phoneNumber ;
    }

}
