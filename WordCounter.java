

import java.util.Scanner;

// Autoren Gideon Faber 001923921 und Florian Weilbach 002025069
public class WordCounter {
	public static void main(String[] args) {
		
		String text = enterText();
		if(!checkEmptyText(text) && checkIfTextGotAtleastOneLetter(text )){
			printWords(countWords(splitTextInWords(deleteAllNumbers(text))));
		}
		else {
			System.out.println("Text ist leer");
		}
		

	}
	

	public static String enterText() {          //Beginning of the enterText method


		System.out.println("Geben Sie Ihren Text ein");  //Screenoutput "Geben Sie Ihren Text ein"
		Scanner scan = new Scanner(System.in);           //setting scanner
		String Text = scan.nextLine().toLowerCase();     //initiate scanner and convert letters
		scan.close();

		return Text;                                     //return converted input
	}                                                    //ending of the enterText method


	public static String deleteAllNumbers(String text) {      //start of the deleteAllNumbers method
		                                      
		return text.replaceAll("[0-9]", "");                  //replace the numbers
                                                             
	}                                                         //ending of the deleteAllNumbers method

	public static boolean checkEmptyText(String text) {       //start of the checkEmptyText method	                                                        
		if (text.isEmpty()) {                                 //check if text is empty
			return true;                                      //if condition is true returning true

		}else                                                

			return false;                                     //return false
	}                                                         //ending of the checkEmptyText method




	public static boolean checkIfTextGotAtleastOneLetter(String text) {   //start of the checkifTextGotAtleastOneLetter method
                               //setting condition

		if (text.matches(".*[a-zA-ZäöüÄÖÜß]+.*")) {                       // check whether the text has at least one letter
		    return true;
		} else {
		  return false;                                                  //otherwise return false
		}                                                             
	}                                                                    //ending of the checkifTextGotAtleastOneLetter method


	// split the string with specified separators
	public static String[] splitTextInWords(String text) {
		String[] splittedText = text.split("[ .,;?!]+");                 // splitting the text
		return splittedText;

	}                                                                    //ending of the splitTextInWords method

	// Word count method
	public static String[][] countWords(String[] splittedText) {
		String[][] wordListWithEmpty = new String[splittedText.length][2]; // if two ore more words are the same the array will have an array with null
		int counter = 0;
		boolean exists = false;                                   // check whether the word exists in wordListWithEmpty
		for (int i = 0 ; i < splittedText.length ; i++) {
			exists = false;
			for(int j = 0 ; j < counter ; j++ ) {                 // if the word is not in wordList
				if (wordListWithEmpty[j][0].equals(splittedText[i])) {
					wordListWithEmpty[j][1] = String.valueOf(Integer.parseInt(wordListWithEmpty[j][1]) + 1);
					exists = true;
				} 
			}
			if (!exists) {                                        // if the word is  in wordList
				wordListWithEmpty[counter][0] = splittedText[i];
				wordListWithEmpty[counter][1] = "1";                       // setting the number of words to one 
				counter++;
			}
		} 
		String[][] wordList = new String[counter][2];                      // new array with the length of the counter
		counter = 0;
		for (int i = 0 ; i < wordListWithEmpty.length ; i++) {             
				if (wordListWithEmpty[i][0] != null) {
					wordList[counter][0] = wordListWithEmpty[i][0];
					wordList[counter][1] = wordListWithEmpty[i][1];
					counter++;
				}
			}
		return wordList;
		}                                                                  //ending of the countWords method
	                                                            

	// method for outputting the words with their number
	public static void printWords(String[][] wordList) {
		for (int i = 0; i < wordList.length; i++) {
			for( int j = 0; j < wordList[i].length ; j++) {				               
					System.out.print("|"+wordList[i][j]);			// output of the array	
			}	 
			System.out.print("|");
			System.out.println("");                           // new line
		}	 
	}                                                         //ending of the printWords method
}
