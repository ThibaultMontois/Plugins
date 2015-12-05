package plugins.file;

import java.io.File;

import plugins.Plugin;

/**
 * A PluginChangedEvent is fire to listeners when a plugin is added or removed.
 * 
 * A plugin is automatically created from the source file during the event
 * instantiation
 * 
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class PluginChangedEvent {

	private Plugin plugin;

	public PluginChangedEvent(File source) {
		this.plugin = this.toPlugin(source);
	}

	/**
	 * @return the event's plugin
	 */
	public Plugin getPlugin() {
		return this.plugin;
	}

	/**
	 * Creates a plugin from a source file.
	 * 
	 * @param source
	 *            the file using to create a plugin
	 * @return the plugin instance corresponding to the source file, null if
	 *         this source file doesn't correspond to a plugin
	 */
	private Plugin toPlugin(File source) {
		String filename = source.getName();
		filename = filename.substring(0, filename.indexOf(".class"));
		Class<?> classFile;
		try {
			classFile = Class.forName("plugins." + filename);
			return (Plugin) classFile.newInstance();
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			return null;
		}
	}

}
