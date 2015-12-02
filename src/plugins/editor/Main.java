package plugins.editor;

import plugins.file.PluginFinder;
import plugins.file.PluginsChangedLogger;
import plugins.timer.ConfigurableTimer;

public class Main {

	public static void main(String[] args) {
		PluginFrame frame = new PluginFrame();
		PluginsChangedLogger pluginsLogger = new PluginsChangedLogger(frame);
		PluginFinder finder = new PluginFinder("./dropins");
		ConfigurableTimer timer = new ConfigurableTimer(2000, finder);
		finder.addListener(pluginsLogger);
		timer.start();
	}

}
