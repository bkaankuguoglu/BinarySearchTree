import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * This class simply reads the data from the given .txt files by using
 * Java I/O utilities and puts the input values into an arraylists to be
 * used later on.
 * 
 * @author  Berk Kaan Kuguoglu
 * @version 1.0
 * @since   2016-02-28 
 */

public class DatabaseReader {
	private static ArrayList<String[]> phoneBook = new ArrayList<String[]>();
	private static ArrayList<String[]> phoneBookQuery = new ArrayList<String[]>();

	public static ArrayList<String[]> getPhoneBook() {
		return phoneBook;
	}
	/**
	 * Reads the .txt file "database.txt" and stores the values obtained from the file
	 * as name, surname, and number in the arraylist called phoneBook.
	 * 
	 */
	public static void readDatabase() {
		
		BufferedReader bufferedReader = null;

		try {

			String sCurrentLine;

			bufferedReader = new BufferedReader(new FileReader("database.txt"));

			while ((sCurrentLine = bufferedReader.readLine()) != null) {
				System.out.println(sCurrentLine);
				String [] addressLine = new String[3];
			    String [] tokens = sCurrentLine.split("\\s+");
			    String name = tokens[0];
			    String surname = tokens[1];
			    String number = tokens[2];
			    addressLine[0] = name;
			    addressLine[1] = surname;
			    addressLine[2] = number;
			    phoneBook.add(addressLine);
			}
			
			System.out.println("\nThe phonebook database is read successfully. \n");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null)bufferedReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
	
	/**
	 * Reads the .txt file "query.txt" and stores the values obtained from the file
	 * as command, name, surname, and number in the arraylist called phoneBookQuery.
	 * 
	 */
	public static void readQuery(){

		BufferedReader bufferedReader = null;

		try {

			String sCurrentLine;

			bufferedReader = new BufferedReader(new FileReader("query.txt"));

			while ((sCurrentLine = bufferedReader.readLine()) != null) {
				System.out.println(sCurrentLine);
				String [] commandLine = new String[4];
			    String [] tokens = sCurrentLine.split("\\s+");
			    String command = tokens [0];
			    String name = tokens[1];
			    String surname = tokens[2];
			    String number = tokens[3];
			    commandLine[0] = command;
			    commandLine[1] = name;
			    commandLine[2] = surname;
			    commandLine[3] = number;
			    phoneBookQuery.add(commandLine);
			}
			
			System.out.println("\nThe query is read successfully. \n");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null)bufferedReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	
	}
	public static ArrayList<String[]> getPhoneBookQuery() {
		return phoneBookQuery;
	}
	public static void setPhoneBookQuery(ArrayList<String[]> phoneBookQuery) {
		DatabaseReader.phoneBookQuery = phoneBookQuery;
	}
	public static void setPhoneBook(ArrayList<String[]> phoneBook) {
		DatabaseReader.phoneBook = phoneBook;
	}
	

	 
	
}

