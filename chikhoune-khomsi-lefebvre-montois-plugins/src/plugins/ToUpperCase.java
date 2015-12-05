package plugins;

/**
 * Using to set the input text characters to upper case.
 * 
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class ToUpperCase implements Plugin {

	/**
	 * Sets all the input text characters to upper case.
	 * 
	 * @see plugins.Plugin#transform(String)
	 */
	@Override
	public String transform(String input) {
		return input.toUpperCase();
	}

	/**
	 * @see plugins.Plugin#getLabel()
	 */
	@Override
	public String getLabel() {
		return "To Upper Case";
	}

}
