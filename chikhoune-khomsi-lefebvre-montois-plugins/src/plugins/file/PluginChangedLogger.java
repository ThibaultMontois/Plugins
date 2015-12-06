package plugins.file;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JMenuItem;

import plugins.Plugin;
import plugins.editor.PluginFrame;

/**
 * A PluginChangedLogger is using to add or remove a plugin from a plugin event.
 * 
 * It may need to create a menu item with a specific action before transmitting
 * it to the tools menu
 * 
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class PluginChangedLogger implements PluginChangedListener {

	private PluginFrame frame;
	private Map<String, JMenuItem> items;

	/**
	 * Constructs a PluginChangedLogger with given frame.
	 * 
	 * @param frame
	 *            the programm's frame that contains the tools menu to change
	 */
	public PluginChangedLogger(PluginFrame frame) {
		this.frame = frame;
		this.items = new HashMap<String, JMenuItem>();
	}

	/**
	 * @return the logger's frame
	 */
	public PluginFrame getFrame() {
		return this.frame;
	}

	/**
	 * Gets the item contains in the given event and adds an action listener to
	 * it.
	 * 
	 * @see plugins.file.PluginChangedListener#addPlugin(plugins.file.PluginChangedEvent)
	 */
	@Override
	public void addPlugin(PluginChangedEvent event) {
		JMenuItem item = null;
		Plugin plugin = event.getPlugin();
		if (plugin != null)
			item = event.getItem();
		if (item != null) {
			item.addActionListener(new PluginEventListener(this.frame, plugin));
			this.items.put(plugin.getLabel(), item);
		}
	}

	/**
	 * Removes the action listener from the item contains in the given event.
	 * 
	 * @see plugins.file.PluginChangedListener#removePlugin(plugins.file.PluginChangedEvent)
	 */
	@Override
	public void removePlugin(PluginChangedEvent event) {
		JMenuItem item;
		Plugin plugin = event.getPlugin();
		if (plugin != null) {
			item = this.items.remove(plugin.getLabel());
			item.removeActionListener(item.getActionListeners()[0]);
		}
	}

}
