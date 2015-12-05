package test.plugins.mock;

import plugins.Plugin;

/**
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class PluginMock implements Plugin {

	@Override
	public String transform(String input) {
		return "I'm a plugin's mock";
	}

	@Override
	public String getLabel() {
		return "Plugin's Mock";
	}

}
