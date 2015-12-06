package plugins.editor;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import plugins.Plugin;
import plugins.file.PluginChangedEvent;
import plugins.file.PluginChangedListener;

/**
 * A ToolsMenu is a menu using to add and remove items related plugins.
 * 
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
@SuppressWarnings("serial")
public class ToolsMenu extends JMenu implements PluginChangedListener {

	private Map<String, JMenuItem> items;

	/**
	 * Constructs a ToolsMenu with given label.
	 * 
	 * @param label
	 *            the label of the tools menu
	 */
	public ToolsMenu(String label) {
		super(label);
		this.items = new HashMap<String, JMenuItem>();
	}

	/**
	 * @return the map that contains the tools menu items
	 */
	public Map<String, JMenuItem> getItems() {
		return this.items;
	}

	/**
	 * Adds an item to the tools menu.
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
			this.items.put(plugin.getLabel(), item);
			this.add(item);
		}
	}

	/**
	 * Removes an item from the tools menu.
	 * 
	 * @see plugins.file.PluginChangedListener#removePlugin(plugins.file.PluginChangedEvent)
	 */
	@Override
	public void removePlugin(PluginChangedEvent event) {
		JMenuItem item;
		Plugin plugin = event.getPlugin();
		if (plugin != null) {
			item = this.items.remove(plugin.getLabel());
			this.remove(item);
		}
	}

}
