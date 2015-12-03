package plugins.file;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class PluginFinder {

	private File directory;
	private PluginFilter filter;
	private List<File> plugins;
	private List<PluginChangedListener> listeners;

	public PluginFinder(String directory) {
		this.directory = new File(directory);
		this.filter = new PluginFilter();
		this.plugins = new LinkedList<File>();
		this.listeners = new LinkedList<PluginChangedListener>();
	}

	public void addListener(PluginChangedListener listener) {
		this.listeners.add(listener);
	}

	private void firePluginRemoved(File plugin) {
		PluginChangedEvent event = new PluginChangedEvent(plugin);
		for (PluginChangedListener listener : this.listeners)
			listener.removePlugin(event);
	}

	private void firePluginAdded(File plugin) {
		PluginChangedEvent event = new PluginChangedEvent(plugin);
		for (PluginChangedListener listener : this.listeners)
			listener.addPlugin(event);
	}

	private void handlePlugins(File[] plugins) {
		List<File> pluginsToRemove = new LinkedList<File>(this.plugins);
		for (File plugin : plugins) {
			if (this.plugins.contains(plugin))
				pluginsToRemove.remove(plugin);
			else {
				this.firePluginAdded(plugin);
				this.plugins.add(plugin);
			}
		}
		for (File plugin : pluginsToRemove) {
			this.firePluginRemoved(plugin);
			this.plugins.remove(plugin);
		}
	}

	public void checkPlugins() {
		File[] plugins = this.directory.listFiles(this.filter);
		if (plugins != null)
			this.handlePlugins(plugins);
	}

}
