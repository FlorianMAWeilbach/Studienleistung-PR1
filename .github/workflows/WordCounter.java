package WordCounter;

import java.util.*; //import of some needed packages 
import java.util.Collection;
import java.util.Scanner;

public class WordCounter { // start of the class WordCounter

	public static String enterText() { // begining of the enterText method

		System.out.println("Geben Sie Ihren Text ein"); // Screenoutput "Geben Sie Ihren Text ein"
		Scanner scan = new Scanner(System.in); // setting scanner
		String Text = scan.nextLine(); // initiate scanner

		Text.toLowerCase(); // convert letters

		return Text; // return convertet input
	} // ending of the enterText method

	public static String deleteAllNumbers(String text) { // start of the deleteAllNumbers method
		enterText(); // call of the enterText method
		text = enterText().replaceAll("[0-9]", text); // replace the numbers

		return text; // return value
	} // ending of the deleteAllNumbers method

	public static boolean checkEmptyText(String text) { // start of the checkEmptyText method
		deleteAllNumbers(text).isEmpty(); // check if text is empty

		if (deleteAllNumbers(text).isEmpty()) { // setting condition
			return true; // if condition is true returning true

		} else // initiate otherwise

			return false; // return false
	} // ending of the checkEmptyText method

	public static boolean checkifTextGotAtleastOneLetter(String text) { // start of the checkifTextGotAtleastOneLetter
																		// method
		deleteAllNumbers(text).isEmpty(); // setting condition

		if (deleteAllNumbers(text).isEmpty()) { // if condition is true returning false
			return false;

		} else

			return true; // otherwise return true

	} // ending of the checkifTextGotAtleastOneLetter method

}
