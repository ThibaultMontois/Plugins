package plugins;

/**
 * Using for tests.
 * 
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class NotHaveAConstructorWithoutParameters implements Plugin {

	/**
	 * Hidden constructor without parameters.
	 */
	private NotHaveAConstructorWithoutParameters() {
	}

	/**
	 * @see plugins.Plugin#transform(String)
	 */
	@Override
	public String transform(String input) {
		return "I'm not a Plugin";
	}

	/**
	 * @see plugins.Plugin#getLabel()
	 */
	@Override
	public String getLabel() {
		return "Not a Plugin";
	}

}
