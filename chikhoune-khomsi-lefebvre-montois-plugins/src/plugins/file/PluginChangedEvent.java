package plugins.file;

import java.io.File;
import java.util.EventObject;

import javax.swing.JMenuItem;

import plugins.Plugin;

/**
 * A PluginChangedEvent is fire to listeners when a plugin is added or removed.
 * 
 * A plugin is created from the source file during the event instantiation and
 * a menu item may be created if it's an add event
 * 
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
@SuppressWarnings("serial")
public class PluginChangedEvent extends EventObject {

	private Plugin plugin;
	private JMenuItem item;

	/**
	 * Constructs a PluginChangedEvent with given source, plugin file and add
	 * predicate.
	 * 
	 * @param source
	 *            the source that fire this event
	 * @param file
	 *            the file using to create a plugin
	 * @param addEvent
	 *            true if it's an add event, else false
	 */
	public PluginChangedEvent(Object source, File file, boolean addEvent) {
		super(source);
		this.plugin = this.toPlugin(file);

		if (this.plugin != null && addEvent)
			this.item = new JMenuItem(this.plugin.getLabel());
	}

	/**
	 * @return the event's plugin
	 */
	public Plugin getPlugin() {
		return this.plugin;
	}

	/**
	 * @return the event's item
	 */
	public JMenuItem getItem() {
		return this.item;
	}

	/**
	 * Creates a plugin from a source file.
	 * 
	 * @param file
	 *            the file using to create a plugin
	 * @return the plugin instance corresponding to the source file, null if
	 *         this source file doesn't correspond to a plugin
	 */
	private Plugin toPlugin(File file) {
		String filename = file.getName();
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
