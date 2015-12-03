package plugins.editor;

import plugins.file.PluginFinder;
import plugins.file.PluginChangedLogger;
import plugins.timer.ConfigurableTimer;

public class Main {

	public static void main(String[] args) {
		PluginFrame frame = new PluginFrame();
		PluginChangedLogger pluginsLogger = new PluginChangedLogger(frame);
		PluginFinder finder = new PluginFinder("dropins/");
		ConfigurableTimer timer = new ConfigurableTimer(2000, finder);
		finder.addListener(pluginsLogger);
		timer.start();
	}

}
