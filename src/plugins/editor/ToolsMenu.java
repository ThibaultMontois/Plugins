package plugins.editor;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class ToolsMenu extends JMenu {

	private Map<String, JMenuItem> items;

	public ToolsMenu(String name) {
		super(name);
		this.items = new HashMap<String, JMenuItem>();
	}

	public void addItem(JMenuItem item, String label) {
		this.items.put(label, item);
		this.add(item);
	}

	public void removeItem(String label) {
		JMenuItem item = this.items.get(label);
		this.remove(item);
	}

}
