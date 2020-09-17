import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Static class that checks the validity of passwords.
 * A password is valid if it is at least 6 characters long, does not repeat the same character more than twice in a row, and contains
 * at least one lowercase character, uppercase character, special character, and digit.
 * At password that is between 6 to 9 characters long is valid but considered weak.
 * 
 * @author Rose Griffin
 *
 */
public class PasswordCheckerUtility {
	
	/**
	 * Compares the equality of two passwords.
	 * 
	 * @param password	String to be checked.
	 * @param passwordConfirm	String to be checked against.
	 * @throws UnmatchedException	Thrown if passwords are not equal.
	 */
	public static void comparePasswords (String password, String passwordConfirm) throws UnmatchedException {
		if (!password.equals(passwordConfirm))
			throw new UnmatchedException();
	}
	
	/**
	 * Compares the equality of two passwords.
	 * 
	 * @param password	String to be checked.
	 * @param passwordConfirm	STring to be checked against.
	 * @return	return true if passwords are equal.
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		return password.equals(passwordConfirm);
	}
	
	/**
	 * Creates an ArrayList of invalid passwords read from a file, with reason.
	 * 
	 * @param passwords	List of passwords.
	 * @return	List of invalid passwords with reason.
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		ArrayList<String> invalidPasswords = new ArrayList<String>();
		for (int i = 0; i < passwords.size(); i++) {
			try {
				if (!isValidPassword(passwords.get(i)))
					invalidPasswords.add(passwords.get(i));
			} catch (LengthException e) {
				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
				e.printStackTrace();
			} catch (NoDigitException e) {
				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
				e.printStackTrace();
			} catch (NoLowerAlphaException e) {
				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
				e.printStackTrace();
			} catch (NoUpperAlphaException e) {
				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
				e.printStackTrace();
			} catch (NoSpecialCharacterException e) {
				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
				e.printStackTrace();
			} catch (InvalidSequenceException e) {
				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
				e.printStackTrace();
			} 
		}
		return invalidPasswords;
	}
	
	/**
	 * Checks if a password length is between 6 to 9 characters.
	 * 
	 * @param password	The password to be checked.
	 * @return	returns true if password is between 6 and 9.
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		return password.length() >= 6 && password.length() <= 9;
	}

	/**
	 * Checks if a password contains at least one digit.
	 * 
	 * @param password The password to be checked.
	 * @return	Returns true if password contains at least one digit.
	 * @throws NoDigitException	Thrown if password does not contain at least one digit.
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		int num = 0;
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) >= 48 && password.charAt(i) <= 57)
				num++;
		}
		
		if (num > 0)
			return true;
		else 
			throw new NoDigitException();
	}
	
	/**
	 * Checks if password has at least one lowercase character.
	 * 
	 * @param password	The password to be checked
	 * @return	Returns true if password contains at least one lowercase character.
	 * @throws NoLowerAlphaException	Thrown if password does not contain at least one lowercase character.
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		int num = 0;
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) >= 97 && password.charAt(i) <= 122)
				num++;
		}
		
		if (num > 0)
			return true;
		else 
			throw new NoLowerAlphaException();
	}
	
	/**
	 * Checks if a password does not contain more than 2 characters in a row.
	 * 
	 * @param password	The password to be checked.
	 * @return	returns true if the password does not contain more than 2 characters in a row.
	 * @throws InvalidSequenceException	Thrown if password contains more than 2 characters in a row.
	 */
	public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException {
		int num = 0;
		for (int i = 0; i < password.length(); i++) {
			if (num < 2 && i+1 < password.length() && password.charAt(i) == password.charAt(i+1))
				num++;
			else if (num < 2 && i+1 < password.length() && password.charAt(i) != password.charAt(i+1))
				num = 0;
		}
		
		if (num < 2) {
			System.out.println("VALID " + password + " : " + num);
			return true;
		} else {
			System.out.println("INVALID " + password + " : " + num);
			throw new InvalidSequenceException();
		}
		
	}
	
	/**
	 * Checks if password contains at least one special character.
	 * 
	 * @param password	The password to be checked.
	 * @return	Returns true if password contains at least one special character.
	 * @throws NoSpecialCharacterException	Thrown if password does not contain at least one special character.
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		
		if (!matcher.matches())
			return true;
		else
			throw new NoSpecialCharacterException();
	}
	
	/**
	 * Checks if a password contains at least one uppercase character
	 * 
	 * @param password	The password to be checked
	 * @return	Returns true if password contains at least one uppercase character.
	 * @throws NoUpperAlphaException	Thrown if password does not contain at least one uppercase character
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		int num = 0;
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) >= 65 && password.charAt(i) <= 90)
				num++;
		}

		if (num > 0) {
			return true;
		} else {
			throw new NoUpperAlphaException();
		}
	}
	
	/**
	 * Checks to see if the password is at least 6 characters long.
	 * 
	 * @param password	 The password to be checked.
	 * @return	Returns true if password is at least 6 characters long.
	 * @throws LengthException	Thrown if password is less than 6 characters long.
	 */
	public static boolean isValidLength(String password) throws LengthException {
		if (password.length() >= 6)
			return true;
		else 
			throw new LengthException();
	}
	
	/**
	 * Checks if a password passes all the criteria to be valid
	 * 
	 * @param password	The password to be checked.
	 * @return	Returns true if password passes all criteria.
	 * @throws LengthException	Thrown if password is less than 6 characters long.
	 * @throws NoDigitException	Thrown if password does not contain at least one digit.
	 * @throws NoLowerAlphaException	Thrown if password does not contain at least one lowercase character.
	 * @throws NoUpperAlphaException	Thrown if password does not contain at least one uppercase character.
	 * @throws NoSpecialCharacterException	Thrown if password does not contain at least one special character.
	 * @throws InvalidSequenceException	Thrown if password does not contain more than 2 characters in a row.
	 */
	public static boolean isValidPassword(String password) throws  LengthException, NoDigitException, NoLowerAlphaException, NoUpperAlphaException, NoSpecialCharacterException,  InvalidSequenceException{
		return isValidLength(password) && hasDigit(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasSpecialChar(password) && hasSameCharInSequence(password);
	}
	
	/**
	 * 
	 * @param password	The password to be checked.
	 * @return	Returns true if password is valid and is more than 10 characters long.
	 * @throws WeakPasswordException	Thrown if password is less than 10 characters long but of otherwise valid length.
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException{
		if (!hasBetweenSixAndNineChars(password))
			return true;
		else 
			throw new WeakPasswordException();
	}
}
