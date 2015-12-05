package plugins.editor;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * A ToolsMenu is a menu using to add and remove items related plugins.
 * 
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
@SuppressWarnings("serial")
public class ToolsMenu extends JMenu {

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
	 * @param item
	 *            the item to add
	 * @param label
	 *            the item's label
	 */
	public void addItem(JMenuItem item, String label) {
		this.items.put(label, item);
		this.add(item);
	}

	/**
	 * Removes an item from the tools menu.
	 * 
	 * @param label
	 *            the item's label
	 */
	public void removeItem(String label) {
		JMenuItem item = this.items.remove(label);
		this.remove(item);
	}

}
