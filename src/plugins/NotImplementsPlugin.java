package plugins;

/**
 * Using for tests.
 * 
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class NotImplementsPlugin {

	/**
	 * @see plugins.Plugin#transform(String)
	 */
	public String transform(String input) {
		return "I'm not a Plugin";
	}

	/**
	 * @see plugins.Plugin#getLabel()
	 */
	public String getLabel() {
		return "Not a Plugin";
	}

}
