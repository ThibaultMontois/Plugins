package plugins.file;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class PluginFinder {

	private File directory;
	private PluginFilter filter;
	private List<File> plugins;
	private List<PluginListener> listeners;

	public PluginFinder(String directory) {
		this.directory = new File(directory);
		this.filter = new PluginFilter();
		this.plugins = new LinkedList<File>();
		this.listeners = new LinkedList<PluginListener>();
	}

	public void addListener(PluginListener listener) {
		this.listeners.add(listener);
	}

	private void handlePlugins(File[] plugins) {
		PluginEvent event;
		List<File> oldPlugins = new LinkedList<File>(this.plugins);
		this.plugins.clear();
		for (int i = 0; i < plugins.length; i++) {
			if (oldPlugins.contains(plugins[i]))
				oldPlugins.remove(plugins[i]);
			else {
				event = new PluginEvent(plugins[i]);
				for (PluginListener listener : this.listeners)
					listener.addedLogger(event);
			}
			this.plugins.add(plugins[i]);
		}
		for (File file : oldPlugins) {
			event = new PluginEvent(file);
			for (PluginListener listener : this.listeners)
				listener.removedLogger(event);
		}
	}

	public void checkPlugins() {
		File[] plugins = this.directory.listFiles(this.filter);
		if (plugins != null)
			this.handlePlugins(plugins);
	}

}
