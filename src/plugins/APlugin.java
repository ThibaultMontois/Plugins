package plugins;

/**
 * Using for tests.
 * 
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class APlugin implements Plugin {

	/**
	 * @see plugins.Plugin#transform(String)
	 */
	@Override
	public String transform(String input) {
		return "I'm a Plugin";
	}

	/**
	 * @see plugins.Plugin#getLabel()
	 */
	@Override
	public String getLabel() {
		return "A Plugin";
	}

}
