import java.util.ArrayList;
import java.util.Arrays;

public class LetterBag {
	private final String alphabet = "abcdefghijklmnopqrstuvwxyz ";
	private int[] letterFrequencies;

	public LetterBag() {
		letterFrequencies = new int[27]; // 26 letters
	}

	/***
	 * adds letter to the bag
	 * 
	 * @param letter
	 *            input letter
	 */

	public void add(String letter) {
		String lower = letter.toLowerCase();
		int index = getIndexForLetter(lower);
		letterFrequencies[index]++;
	}	

	/***
	 * returns the index of the input letter
	 * 
	 * @param lower
	 *            the input letter
	 * @return returns index of lower
	 */
	private int getIndexForLetter(String lower) {
		int index = -1;
		for (int i = 0; i < alphabet.length(); i++) {
			if (lower.equals(alphabet.substring(i, i + 1))) {
				index = i;
			}
		}
		return index;
	}

	/***
	 * returns total letters in the bag
	 * 
	 * @return sum of letters
	 */
	public int getTotalWords() {
		int sum = 0;
		for (int i = 0; i < alphabet.length(); i++) {
			sum += letterFrequencies[i];
		}
		return sum;
	}

	/***
	 * returns the number of unique characters, not all characters
	 * 
	 * @return returns number of unique words
	 */
	public int getNumUniqueWords() {
		int numUnique = 0;
		ArrayList<String> words = new ArrayList<>();

		for (int i = 0; i < alphabet.length(); i++) {
			if ((letterFrequencies[i] > 0) && (wordNotPresent(alphabet.substring(i, i + 1), words))) {
				words.add(alphabet.substring(i, i + 1));
				numUnique++;
			}
		}
		return numUnique;
	}

	/***
	 * tells if the input word exists in the bag
	 * 
	 * @param wordinput
	 *            word
	 * @return returns false if word appears in the bag
	 */
	private boolean wordNotPresent(String word, ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(word)) {
				return false;// false means it is present
			}
		}
		return true;
	}

	/***
	 * returns the number of times input appears in bag
	 * 
	 * @param string
	 *            input letter
	 * @return number of times input appears
	 */
	public int getNumOccurances(String word) {
		int index = alphabet.indexOf(word);
		return letterFrequencies[index];
	}

	/***
	 * returns most frequently occurring letter
	 * 
	 * @return the most frequent letter
	 */
	public String getMostFrequent() {
		int maxIndex = 0;
		for (int i = 1; i < letterFrequencies.length; i++) {
			if (letterFrequencies[i] > letterFrequencies[maxIndex]) {
				maxIndex = i;
			}
		}
		return alphabet.substring(maxIndex, maxIndex + 1);
	}

	

	/***
	 * returns most frequently occurring letter, changing its occurrences to -1
	 * 
	 * @return the most frequently occurring letter
	 */
	public String getMostFrequentN() {
		int maxIndex = 0;
		for (int i = 1; i < letterFrequencies.length; i++) {
			if (letterFrequencies[i] > letterFrequencies[maxIndex]) {
				maxIndex = i;
			}
		}
		letterFrequencies[maxIndex] = -1;
		return alphabet.substring(maxIndex, maxIndex + 1);
	}

	/***
	 * returns a printed out array of the i most frequently occurring words
	 * 
	 * @param i
	 *            number of most frequent words
	 * @return printed array of the 'i' most frequently occurring words
	 */
	public String getNMostFrequentStrings(int i) {
		String[] mostFrequents = new String[i];
		for (int j = 0; j < i; j++) {// i times
			mostFrequents[j] = getMostFrequentN();
		}
		return Arrays.toString(mostFrequents);
	}

}