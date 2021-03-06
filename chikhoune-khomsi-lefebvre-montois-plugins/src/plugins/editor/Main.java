package plugins.editor;

import plugins.file.PluginChangedLogger;
import plugins.file.PluginFinder;
import plugins.timer.ConfigurableTimer;

/**
 * Executes the Plugins programm.
 * 
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class Main {

	public static void main(String[] args) {
		PluginFrame frame = new PluginFrame(true);
		PluginChangedLogger pluginsLogger = new PluginChangedLogger(frame);
		PluginFinder finder = new PluginFinder("dropins/");
		ConfigurableTimer timer = new ConfigurableTimer(2000);
		finder.addListener(pluginsLogger);
		finder.addListener(frame.getToolsMenu());
		timer.addFinder(finder);
		timer.start();
	}

}
