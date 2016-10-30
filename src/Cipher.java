import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Cipher {
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789,.() '\"![]/%-_;?-=:"
			+ '\n' + '\r';
	private static final String SIMPLE_ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	// Set this variable to the default alphabet you wish to use
	private static final String DEFAULT_ALPHABET = ALPHABET;

	public static void main(String[] args) {
		//hD-mT-nvueeqseivD-aIl D-aH-gJqnB-tJ-wvtkeBoeBhz-bzicC-nJE DA OpiN-oFiye
		String x = vigenereCipherCrackThreeLetter("hD-mT-nvueeqseivD-aIl D-aH-gJqnB-tJ-wvtkeBoeBhz-bzicC-nJE DA OpiN-oFiye", ALPHABET);
		System.out.println(x);

	}

	/**
	 * Returns plaintext encrypted by the rotation cipher with a shift of
	 * movement.
	 * 
	 * @param alphabet
	 *            the alphabet to be used for the encryption
	 * @param plainText
	 *            the plain text to be encrypted.
	 * @param shiftAmount
	 *            the number of characters in ALPHABET to shift by.
	 * @return returns the encrypted plainText.
	 */
	public static String rotationCipherEncrypt(String plain, int shift, String alphabet) {
		StringBuilder encryptedText = new StringBuilder();

		for (int i = 0; i < plain.length(); i++) {
			String letter = plain.substring(i, i + 1);
			letter = shift(letter, shift, alphabet);
			encryptedText.append(letter);
		}
		return encryptedText.toString();
	}

	public static String rotationCipherEncrypt(String plainText, int shiftAmount) {
		return rotationCipherEncrypt(plainText, shiftAmount, ALPHABET);
	}

	/**
	 * Returns a the result of decrypting cipherText by shiftAmount using the
	 * rotation cipher.
	 * 
	 * @param alphabet
	 *            the alphabet to be used for the encryption
	 * @param cipherText
	 *            the encrypted text.
	 * @param shiftAmount
	 *            the key to decrypt the cipher.
	 * @return returns the decrypted cipherText.
	 */
	public static String rotationCipherDecrypt(String cipher, int shift, String alphabet) {
		StringBuilder decryptedText = new StringBuilder();
		shift = -(shift);
		for (int i = 0; i < cipher.length(); i++) {
			String letter = cipher.substring(i, i + 1);
			letter = shift(letter, shift, alphabet);
			decryptedText.append(letter);
		}
		return decryptedText.toString();
	}

	public static String rotationCipherDecrypt(String cipherText, int shiftAmount) {
		return rotationCipherDecrypt(cipherText, shiftAmount, DEFAULT_ALPHABET);
	}

	public static String vigenereCipherEncrypt(String plain, String password, String alphabet) {
		StringBuilder cipheredText = new StringBuilder();
		int passwordCounter = 0;
		for (int plainChar = 0; plainChar < plain.length(); plainChar++) {// loop
																			// through
																			// unciphered
																			// text
			String uncipheredLetter = plain.substring(plainChar, plainChar + 1);// letter
																				// which
																				// we
																				// will
																				// encrypt
			int shiftAmount = alphabet.indexOf(password.substring(passwordCounter, passwordCounter + 1));
			String encryptedLetter = rotationCipherEncrypt(uncipheredLetter, shiftAmount, alphabet);
			cipheredText.append(encryptedLetter);
			passwordCounter++;
			if (passwordCounter > password.length() - 1) {
				passwordCounter = 0;// can't be larger than pass
			}
		}
		return cipheredText.toString();
	}

	public static String vigenereCipherEncrypt(String plainText, String code) {
		return vigenereCipherEncrypt(plainText, code, DEFAULT_ALPHABET);
	}

	// returns the decoded text by brute force (or freq.) cracking
	public static String rotationCipherCrack(String cipher, String alphabet) {
		for (int i = 0; i < alphabet.length() - 1; i++) {// all possible shifts
			String decrypted = rotationCipherDecrypt(cipher, i, alphabet);
			if (Cipher.isEnglish(decrypted))
				return decrypted;
		}
		return "";// undecipherable by rotation
	}

	public static String vigenereCipherCrack(String cipher, int passwordLength, String alphabet) {
		String password = "";
		// returns password

		// 1 make passwordLength amount of groups
		// 2 get most frequent letter via making a letterbag
		// 3 determine shift amount from most frequent to space
		// 4 shift all group by shift amount
		// 5 repeat
		// combine
		int startingAt = 0;
		for (int groupLooper = 0; groupLooper < passwordLength; groupLooper++) {// amount
																				// of
			// groups
			String group = "";
			LetterBag groupBag = new LetterBag();
			for (int groupIndices = startingAt; groupIndices < cipher.length() - 1; groupIndices += passwordLength) {
				// groups start at different places at cipher
				group += cipher.substring(groupIndices, groupIndices + 1);
				groupBag.add(cipher.substring(groupIndices, groupIndices + 1));
			} // now have a group and a group bag
			String mostFreqLetter = groupBag.getMostFrequent();// hopefully
																// space
			// now determine the shift amount
			String space = " ";
			int spaceIndex = alphabet.indexOf(space);
			int indexMostFreq = alphabet.indexOf(mostFreqLetter);
			// shift amount is what you did to space to get to freq
			int shiftAmount = 0;
			if (spaceIndex == indexMostFreq) {
				shiftAmount = 0;
			} else {
				shiftAmount = indexMostFreq - spaceIndex;
			} // now we have a shift amount
				// need to find the original letter

			int originalIndex = indexMostFreq + shiftAmount;
			if (originalIndex > alphabet.length() - 1) {
				originalIndex %= alphabet.length() - 1;
			}
			if (originalIndex < 0) {
				originalIndex = (alphabet.length() - 1) + originalIndex;
			}

			String letter = alphabet.substring(originalIndex, originalIndex + 1);
			password += letter;

			startingAt++;
		}

		return password;

	}

	// RETURNS THE PASSSSSSSSWWWWWOOOOORRRRRRDDDD
	public static String vigenereCipherCrackThreeLetter(String cipher, String alphabet) {
		// password is 3 letters long
		String password = "";
		// 1 create a string thats one group of letters(every first letter / 3)
		// 2 get the most frequent letter out of it by creating a bag of
		// cipheredText
		// 3 determine shift amount based on what you did to most frequent
		// letter to get a most frequent English letter like "e"
		// 4 shift all of group 1 by the shift amount
		// 5 repeat for other groups
		// 6 combine all groups in output String, return it
		String group1 = "";
		String group2 = "";
		String group3 = "";
		LetterBag group1Bag = new LetterBag();
		LetterBag group2Bag = new LetterBag();
		LetterBag group3Bag = new LetterBag();
		int counter = 0;
		for (int i = 0; i < cipher.length() - 1; i++) {
			if (counter >= 3)
				counter = 0;
			if (counter == 0) {
				group1 += cipher.substring(i, i + 1);
				group1Bag.add(cipher.substring(i, i + 1));
			}
			if (counter == 1) {
				group2 += cipher.substring(i, i + 1);
				group2Bag.add(cipher.substring(i, i + 1));
			}
			if (counter == 2) {
				group3 += cipher.substring(i, i + 1);
				group3Bag.add(cipher.substring(i, i + 1));
			}
		} // length is a full circuit loop
		int shiftAmount = 0;
		String group1FreqLetter = group1Bag.getMostFrequent();
		shiftAmount = (alphabet.indexOf(group1FreqLetter)) - (alphabet.indexOf(" "));
		if (shiftAmount == 0) {// zero
			password += "a";
		}
		if (shiftAmount > 0) {// positive
			String letter = alphabet.substring(shiftAmount, shiftAmount + 1);
			password += letter;
		}
		if (shiftAmount < 0) {// negative
			int index = alphabet.length() - shiftAmount;
			String letter = alphabet.substring(index, index + 1);
			password += letter;
		}

		String group2FreqLetter = group1Bag.getMostFrequent();
		shiftAmount = (alphabet.indexOf(group2FreqLetter)) - (alphabet.indexOf(" "));
		if (shiftAmount == 0) {// zero
			password += "a";
		}
		if (shiftAmount > 0) {// positive
			String letter = alphabet.substring(shiftAmount, shiftAmount + 1);
			password += letter;
		}
		if (shiftAmount < 0) {// negative
			int index = alphabet.length() - shiftAmount;
			String letter = alphabet.substring(index, index + 1);
			password += letter;
		}

		String group3FreqLetter = group1Bag.getMostFrequent();
		shiftAmount = (alphabet.indexOf(group3FreqLetter)) - (alphabet.indexOf(" "));
		if (shiftAmount == 0) {// zero
			password += "a";
		}
		if (shiftAmount > 0) {// positive
			String letter = alphabet.substring(shiftAmount, shiftAmount + 1);
			password += letter;
		}
		if (shiftAmount < 0) {// negative
			int index = alphabet.length() - shiftAmount;
			String letter = alphabet.substring(index, index + 1);
			password += letter;
		}

		return password;
	}

	private static LetterBag getBagFor(String group) {
		LetterBag output = new LetterBag();
		for (int i = 0; i < group.length(); i++) {
			output.add(group.substring(i, i + 1));
		}
		return output;
	}

	public static String getGroup(String cipheredText, int groupIndex, int passwordLength) {
		String group = "";// create a new empty group
		for (int i = groupIndex; i < cipheredText.length(); i += passwordLength) {
			group += cipheredText.substring(i, i + 1);// first group made
		} // create group and group bag, identical

		return group;
	}

	public static String combineThreeGroups(ArrayList<String> input) {
		String a = input.get(0);
		int aCounter = 0;
		String b = input.get(1);
		int bCounter = 0;
		String c = input.get(2);
		int cCounter = 0;
		String[] outputArray = new String[a.length() + b.length() + c.length()];
		// fill outputArray with the correct ordering
		for (int i = 0; i < a.length(); i += 3) {
			outputArray[i] = a.substring(aCounter, aCounter + 1);
			aCounter++;
		}
		for (int i = 1; i < b.length(); i += 3) {
			outputArray[i] = b.substring(bCounter, bCounter + 1);
			bCounter++;
		}
		for (int i = 2; i < c.length(); i += 3) {
			outputArray[i] = c.substring(cCounter, cCounter + 1);
			cCounter++;
		}
		// convert array into string
		return Arrays.toString(outputArray);
	}

	// this works for sure
	public static String shift(String shiftThis, int shiftValue, String alph) {
		int beginIndex = alph.indexOf(shiftThis);
		if (Math.abs(shiftValue) >= alph.length()) {
			shiftValue %= alph.length();
		} // "real" shift value is left

		if (shiftValue > 0) {// positive
			if (beginIndex + shiftValue > alph.length() - 1) {
				int output = (beginIndex + shiftValue) - alph.length();
				return alph.substring(output, output + 1);
			}
			return alph.substring((beginIndex + shiftValue), (beginIndex + shiftValue) + 1);
		} else {// negative
			if (beginIndex + shiftValue < 0) {
				int output = (beginIndex + shiftValue) + alph.length() - 1;
				return alph.substring(output, output + 1);
			}

			return alph.substring((beginIndex + shiftValue), (beginIndex + shiftValue) + 1);
		}
	}

	/**
	 * Returns the result of decrypting cipherText with the key code.
	 * 
	 * @param alphabet
	 *            the alphabet to be used for the encryption
	 * @param cipherText
	 *            the encrypted text.
	 * @param code
	 *            the decryption key
	 * @return returns the decrypted cipherText.
	 */
	public static String vigenereCipherDecrypt(String cipher, String password, String alphabet) {
		StringBuilder cipheredText = new StringBuilder();
		int num = 0;
		for (int i = 0; i < cipher.length(); i++) {

			String character = cipher.substring(i, i + 1);
			num++;
			if (num >= password.length()) {
				num = 0;
			}
			int shiftAmount = alphabet.indexOf(password.substring(num, num + 1));
			shiftAmount = -(shiftAmount);
			character = shift(character, shiftAmount, alphabet);
			cipheredText.append(character);
		}
		return cipheredText.toString();
	}

	public static String vigenereCipherDecrypt(String cipherText, String code) {
		return vigenereCipherDecrypt(cipherText, code, DEFAULT_ALPHABET);
	}

	/**
	 * returns a copy of the input plaintext String with invalid characters
	 * stripped out.
	 * 
	 * @param plaintext
	 *            The plaintext string you wish to remove illegal characters
	 *            from
	 * @param alphabet
	 *            A string of all legal characters.
	 * @return String A copy of plain with all characters not in alphabet
	 *         removed.
	 */
	private static String stripInvalidChars(String plaintext, String alphabet) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < plaintext.length(); i++) { // loop through plaintext
			if (alphabet.indexOf(plaintext.charAt(i)) >= 0) // get index of char
				b.append(plaintext.charAt(i)); // if it exists, keep it
			else
				// otherwise skip it &
				System.out.println("Stripping letter: \"" + plaintext.charAt(i) // display
																				// a
																				// message
						+ "\"");
		}
		return b.toString();
	}

	/***
	 * returns string array with individual words inside of input
	 * 
	 * @param input
	 *            input string
	 * @return returns output array
	 */
	public static String[] getWords(String input) {
		// if the last spot in index isnt a space
		if (!(input.substring(input.length() - 1, input.length()) == " ")) {
			input += " ";// add a space to index's last index
		}
		// loop through input
		// find the first letter, find first space after that
		// a word is everything in between

		int index = 0;
		int nextIndex = 0;
		ArrayList<String> words = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			while (input.substring(i, i + 1) == " ") {
				i++;// find a not a space letter
			}
			index = i;// index is the beginning of a word
			nextIndex = input.indexOf(" ", index);// next index is the first
													// space after a word
			words.add(input.substring(index, nextIndex));
			// everything in between is a word
			i = nextIndex;
		}
		// convert the words list into an array
		String[] output = new String[words.size()];
		for (int j = 0; j < output.length; j++) {
			output[j] = words.get(j);
		}
		return output;
	}

	/***
	 * 
	 * @param plaintext
	 *            text which will be ciphered
	 * @param permutation
	 *            the substitutions which will make unciphered text be ciphered
	 * @param alphabet
	 *            alphabet "code"
	 * @return returns ciphered text based on permutation
	 */

	public static String substitutionCipher(String plainText, int[] permutation, String alphabet) {
		StringBuilder cipheredText = new StringBuilder();
		if (isValidPermutation(permutation)) {
			for (int i = 0; i < plainText.length(); i++) {
				// the letter in index i of plaintext becomes spot
				// (permutation[i]) of alphabet
				int spot = permutation[i];
				String character = alphabet.substring(spot, spot + 1);
				cipheredText.append(character);
			}
		}
		return cipheredText.toString();
	}

	/***
	 * returns true if permutation is valid, false if not
	 * 
	 * @param permutation
	 *            input permutation which will be tested
	 * @return returns true if all indices are unique
	 */

	public static boolean isValidPermutation(int[] permutation) {
		for (int i = 0; i < permutation.length; i++) {
			for (int j = i; j < permutation.length; j++) {
				if (permutation[i] == permutation[j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static String crackCipher1(String encryptedText, String alphabet) {

		for (int i = 0; i < alphabet.length(); i++) {
			String decryptedText = rotationCipherDecrypt(encryptedText, i);
			if (isEnglish(decryptedText)) {
				return decryptedText;
			}
		}
		return null;// undecryptable
	}

	/***
	 * gives a random permutation with input length
	 * 
	 * @param length
	 *            the length of the output permutation
	 * @return returns a random permutation
	 */

	public static int[] randomPermutation(int length) {
		int[] permutation = new int[length];
		for (int i = 0; i < permutation.length; i++) {
			permutation[i] = (int) (Math.random() * ALPHABET.length());
		}
		return permutation;
	}

	/**
	 * checks if plaintext is valid English.
	 * 
	 * @param plaintext
	 *            the text you wish to test for whether it's valid English
	 * @return boolean returns true if plaintext is valid English.
	 */
	private static boolean isEnglish(String plaintext) {

		String[] words = getWords(plaintext);
		Dictionary d = Dictionary.buildDictionary("words.txt");
		for (int i = 0; i < words.length; i++) {
			if (!d.isWord(words[i])) {
				return false;
			}
		}
		return true;
	}

}