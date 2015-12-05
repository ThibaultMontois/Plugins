package plugins.editor;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * A PluginFrame is a frame that contains a tools menu and a text area.
 * 
 * The text area content can be transform thanks to plugins in relation to the
 * tools menu items
 * 
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
@SuppressWarnings("serial")
public class PluginFrame extends JFrame {

	private ToolsMenu tools;
	private JTextArea input;

	/**
	 * Constructs a PluginFrame.
	 */
	public PluginFrame() {
		JScrollPane scrollPane;
		JMenuBar menu = new JMenuBar();

		this.tools = new ToolsMenu("Tools");
		this.input = new JTextArea();

		menu.add(new JMenu("File"));
		menu.add(this.tools);
		menu.add(new JMenu("Help"));
		scrollPane = new JScrollPane(this.input);

		this.setSize(500, 250);
		this.setTitle("Extendable Editor");
		this.setJMenuBar(menu);
		this.add(scrollPane);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * @return the tools menu
	 */
	public ToolsMenu getToolsMenu() {
		return this.tools;
	}

	/**
	 * @return the text area
	 */
	public JTextArea getInput() {
		return this.input;
	}

}
