package plugins.file;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * A PluginFinder is in charge to search regularly for new plugins.
 * 
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class PluginFinder {

	private File directory;
	private PluginFilter filter;
	private List<File> plugins;
	private List<PluginChangedListener> listeners;

	/**
	 * Constructs a PluginFinder with given search directory.
	 * 
	 * @param directory
	 *            the directory where are searched the plugins
	 */
	public PluginFinder(String directory) {
		this.directory = new File(directory);
		this.filter = new PluginFilter();
		this.plugins = new LinkedList<File>();
		this.listeners = new LinkedList<PluginChangedListener>();
	}

	/**
	 * @return the search directory
	 */
	public File getDirectory() {
		return this.directory;
	}

	/**
	 * Set the new search directory with given value.
	 * 
	 * @param directory
	 *            the new search directory
	 */
	public void setDirectory(String directory) {
		this.directory = new File(directory);
	}

	/**
	 * @return the known plugins list
	 */
	public List<File> getPlugins() {
		return this.plugins;
	}

	/**
	 * @return the listeners list
	 */
	public List<PluginChangedListener> getListeners() {
		return this.listeners;
	}

	/**
	 * Adds a new listener to the listeners list.
	 * 
	 * @param listener
	 *            the listener to add
	 */
	public void addListener(PluginChangedListener listener) {
		this.listeners.add(listener);
	}

	/**
	 * Search for added or removed plugins.
	 */
	public void checkPlugins() {
		File[] plugins = this.directory.listFiles(this.filter);
		if (plugins != null)
			this.handlePlugins(plugins);
	}

	/**
	 * Adds and removes plugins.
	 * 
	 * Can fire PluginChangedEvents to the listeners
	 * 
	 * @param plugins
	 *            the plugins found in the search directory
	 */
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

	/**
	 * Fire PluginChangedEvent to the listeners when a new plugin is found.
	 * 
	 * @param plugin
	 *            the founded plugin.
	 */
	private void firePluginAdded(File plugin) {
		PluginChangedEvent event = new PluginChangedEvent(this, plugin);
		for (PluginChangedListener listener : this.listeners)
			listener.addPlugin(event);
	}

	/**
	 * Fire PluginChangedEvent to the listeners when a plugin disappears.
	 * 
	 * @param plugin
	 *            the missing plugin
	 */
	private void firePluginRemoved(File plugin) {
		PluginChangedEvent event = new PluginChangedEvent(this, plugin);
		for (PluginChangedListener listener : this.listeners)
			listener.removePlugin(event);
	}

}
