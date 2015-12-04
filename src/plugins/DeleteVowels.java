package plugins;

import java.util.ArrayList;
import java.util.List;

/**
 * Using to deletes the input text vowels.
 * 
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class DeleteVowels implements Plugin {

	private List<Character> vowels;

	/**
	 * Constructs a DeleteVowels plugin.
	 */
	public DeleteVowels() {
		this.vowels = new ArrayList<Character>();
		this.InitializeVowels();
	}

	/**
	 * Adds all the vowels to the list.
	 */
	private void InitializeVowels() {
		String vowels = "aàâäeéèêêiîïoôöuûüyŷÿAÀÂÄEÉÈÊËIÎÏOÔÖUÛÜYŶŸ";
		for (int i = 0; i < vowels.length(); i++)
			this.vowels.add(vowels.charAt(i));
	}

	/**
	 * @return the vowels list
	 */
	public List<Character> getVowels() {
		return this.vowels;
	}

	/**
	 * Deletes all the vowels from the input text.
	 * 
	 * @see plugins.Plugin#transform(String)
	 */
	@Override
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

	/**
	 * @see plugins.Plugin#getLabel()
	 */
	@Override
	public String getLabel() {
		return "Delete Vowels";
	}

}
