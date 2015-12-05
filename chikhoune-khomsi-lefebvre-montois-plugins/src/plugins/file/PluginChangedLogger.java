package plugins.file;

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

	/**
	 * Constructs a PluginChangedLogger with given frame.
	 * 
	 * @param frame
	 *            the programm's frame that contains the tools menu to change
	 */
	public PluginChangedLogger(PluginFrame frame) {
		this.frame = frame;
	}

	/**
	 * @return the logger's frame
	 */
	public PluginFrame getFrame() {
		return this.frame;
	}

	/**
	 * Creates a JMenuItem from the plugin contained in the given event, adds an
	 * action to this item and transmits it to the tools menu so that it can be
	 * added.
	 * 
	 * @see plugins.file.PluginChangedListener#addPlugin(plugins.file.PluginChangedEvent)
	 */
	@Override
	public void addPlugin(PluginChangedEvent event) {
		Plugin plugin = event.getPlugin();
		if (plugin != null) {
			JMenuItem item = new JMenuItem(plugin.getLabel());
			item.addActionListener(new PluginEventListener(this.frame, plugin));
			this.frame.getToolsMenu().addItem(item, plugin.getLabel());
		}
	}

	/**
	 * Gets the plugin contained in the given event and transmits its label to
	 * the tools menu so that it can be removed.
	 * 
	 * @see plugins.file.PluginChangedListener#removePlugin(plugins.file.PluginChangedEvent)
	 */
	@Override
	public void removePlugin(PluginChangedEvent event) {
		Plugin plugin = event.getPlugin();
		if (plugin != null)
			this.frame.getToolsMenu().removeItem(plugin.getLabel());
	}

}
