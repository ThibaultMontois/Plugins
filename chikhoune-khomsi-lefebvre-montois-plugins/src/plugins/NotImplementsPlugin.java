package plugins;

/**
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class NotImplementsPlugin {

	/**
	 * Transforms the input text.
	 * 
	 * @param input
	 *            the text to transform
	 * @return the transformed text
	 */
	public String transform(String input) {
		return "I'm not a Plugin";
	}

	/**
	 * @return the plugin's label
	 */
	public String getLabel() {
		return "Not a Plugin";
	}

}
