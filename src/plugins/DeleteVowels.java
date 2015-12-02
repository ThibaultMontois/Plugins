package plugins;

import java.util.ArrayList;
import java.util.List;

public class DeleteVowels implements Plugin {

	private List<Character> vowels;

	public DeleteVowels() {
		this.vowels = new ArrayList<Character>();
		this.InitializeVowels();
	}

	private void InitializeVowels() {
		String vowels = "aàâäeéèêêiîïoôöuûüyŷÿAÀÂÄEÉÈÊËIÎÏOÔÖUÛÜYŶŸ";
		for (int i = 0; i < vowels.length(); i++)
			this.vowels.add(vowels.charAt(i));
	}

	public String transform(String input) {
		String vowelLess = "";
		char current;
		for (int i = 0; i < input.length(); i++) {
			current = input.charAt(i);
			if (!this.vowels.contains(current))
				vowelLess += current;
		}
		return vowelLess;
	}

	public String getLabel() {
		return "Delete Vowels";
	}

}
