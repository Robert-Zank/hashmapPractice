package hashmapPractice;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class: RobertZankProject3Problem1
 * 
 * @author Robert Zank
 * @version 1.0 Course : CSE 274 Fall 2023 Written: November 9, 2023
 *
 *          Class description - This class will parse through a file provided 
 *          by the user. It will then parse through the data in the file and
 *          create uniqueIds and address objects with the data. It will
 *          then add that data into a hashMap that holds all of data read.
 *
 *          Purpose: – Someone can use this class to search through a file to
 *          get a certain address pertaining to a specific individual, whose
 *          first and last name the user will provide
 **/

public class RobertZankProject4FrontEnd {

    /**
     * This class will parse through the file provided by the user. Taking the
     * data and creating objects from them, then adding them to a HashMap.
     * 
     * @param addyMap The hashMap that stores all of the data
     * @return
     */
    private static HashMap<String, Address> read(
            HashMap<String, Address> addyMap, Scanner key) {
        // Get the filename from the user
        System.out.print("Please enter the input filename\n"
                + "(or press 1 to use addresses.txt): ");

        // Get the input
        String inputFile = key.nextLine();
        if (inputFile.equals("1")) {
            inputFile = "addresses.txt";
        }

        // Scanner to read the data from the file
        Scanner read;
        try {
            // initialize scanner
            read = new Scanner(new File(inputFile));

            // Loop to parse through the data in the file
            while (read.hasNext()) {
                try {
                    String lastName = read.nextLine();
                    String firstName = read.nextLine();
                    String streetAddy = read.nextLine();
                    int zip = Integer.parseInt(read.nextLine());
                    String phoneNum = read.nextLine();
                    
                    // Create new address object with new data
                    Address temp = new Address(firstName, lastName, zip,
                            streetAddy, phoneNum);

                    // Create a uniqueID for each address object
                    String uniqueID = firstName + " " + lastName;

                    // Add the address object to the Hashmap
                    addyMap.put(uniqueID, temp);
                } catch (NumberFormatException e) {
                    System.out.println("The file provided does not match the"
                            + " required format!");
                    System.exit(0);
                } catch ( NoSuchElementException e) {
                    System.out.println("File was not found in working directory!");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found in working directory!");
            System.exit(0);
        } 
        return addyMap;
    }

    /**
     * Method to allow the user to search for a particular person's address and
     * returns the output.
     * 
     * @param addyMap The hashMap that stores all of the data
     */
    private static void search(HashMap<String, Address> addyMap, Scanner key) {
        // String to hold the users input
        String entry = "";

        while (!entry.equals("-1")) {
            System.out.print(
                    "Who would you like to search for"
                            + " (or enter -1 to exit program)? ");

            // initializing entry to the users new input
            entry = key.nextLine().toLowerCase();

            // boolean to check if the person was found
            boolean check = false;

            for (Entry<String, Address> e : addyMap.entrySet()) {
                if (e.getKey().toLowerCase().equals(entry.toLowerCase())) {
                    Address temp = e.getValue();
                    System.out.println(
                            temp.getFirstName() + " " + temp.getLastName());
                    System.out.println(
                            temp.getStreetAddress() + " " + temp.getZipcode());
                    System.out.println(temp.getPhoneNumber());
                    check = true;
                }
            }

            // display message if the entry was not found
            if (!check && !entry.equals("-1")) {
                System.out.println("Entry not found.");
            }
        }
        System.out.println("Good bye.");
    }

    /**
     * This class is responsible for driving the whole process of this program
     * 
     * @param args an array associated with the main method
     */
    public static void main(String args[]) {
        // HashMap used to store the data
        HashMap<String, Address> addyMap = new HashMap<>();

        // Scanner to get inputs from the user
        Scanner key = new Scanner(System.in);

        // read in the data and store it in the new map
        addyMap = read(addyMap, key);

        // Start the search phase
        search(addyMap, key);
    }
}
