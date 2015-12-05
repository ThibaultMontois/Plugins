package plugins;

/**
 * Using to set the input text characters to lower case.
 * 
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class ToLowerCase implements Plugin {

	/**
	 * Sets all the input text characters to lower case.
	 * 
	 * @see plugins.Plugin#transform(String)
	 */
	@Override
	public String transform(String input) {
		return input.toLowerCase();
	}

	/**
	 * @see plugins.Plugin#getLabel()
	 */
	@Override
	public String getLabel() {
		return "To Lower Case";
	}

}
