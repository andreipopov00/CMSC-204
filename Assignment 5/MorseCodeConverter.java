import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Utility class that converts Morse code into english
 * 
 * @author Rose Griffin
 *
 */
public class MorseCodeConverter {
	
	private static MorseCodeTree tree = new MorseCodeTree();
	
	/**
	 * Prints tree using toArrayList method in MorseCodeTree class
	 * @return
	 */
	public static String printTree() {
		StringBuilder sb = new StringBuilder();
		for (String term : tree.toArrayList()) {
			sb.append(term + " ");
		}
		return sb.toString();
	}
	
	/**
	 * Converts Morse code into English from a string by first splitting the code into words, 
	 * splitting the words into individual letters, and finally translating each letter using fetch
	 * 
	 * @param code - Initial Morse code
	 * @return - Translated message
	 */
	public static String convertToEnglish(String code) {
		StringBuilder sb = new StringBuilder();
		String[] words = code.split("/");
		String[] letters;
		for (int i = 0; i < words.length; i++) {
			letters = words[i].split("\\s+");
			for (int j = 0; j < letters.length; j++)
				sb.append(tree.fetch(letters[j]));
			
			//Append spaces between words
			if (i < words.length-1)
				sb.append(" ");
		}
		return sb.toString();
	}
	
	/**
	 * Converts Morse code from a file into English by first getting the message and calling convertToEnglish with String argument
	 * @param codeFile - File containing Morse code
	 * @return - Translated message
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		try {
			Scanner scanner = new Scanner(codeFile);
			StringBuilder sb = new StringBuilder();
			
			while (scanner.hasNextLine())
				sb.append(scanner.nextLine());
			scanner.close();
			return convertToEnglish(sb.toString());
		} catch (Exception FileNotFoundException) {
			throw new FileNotFoundException();
		}
	}
}
