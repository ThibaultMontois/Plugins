package plugins;

/**
 * The Plugin interface contains the signatures of the methods that must be
 * implemented by the Plugin's classes.
 * 
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public interface Plugin {

	/**
	 * Transforms the input text.
	 * 
	 * @param input
	 *            the text to transform
	 * @return the transformed text
	 */
	public String transform(String input);

	/**
	 * @return the plugin's label
	 */
	public String getLabel();

}
