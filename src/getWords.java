
public class getWords {

	public static void main(String[] args) {
		
	}

	public static String[] getWords(String input) {
		StringBuilder word = new StringBuilder();
		String[] output = new String[(int) ((input.length()) * 0.5)];
		int outputCounter = 0;

		for (int i = 0; i < input.length(); i++) {

			if (!input.substring(i, i + 1).equals(" ")) {
				word.append(input.substring(i, i + 1));
			} else {
				if (!output[outputCounter].equals(" ")) {
					output[outputCounter] = word.toString();
					word = new StringBuilder();
					outputCounter++;
				}
			}


		}

		return output;
	}

}
