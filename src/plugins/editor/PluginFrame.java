package plugins.editor;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PluginFrame extends JFrame {

	private ToolsMenu tools;
	private JTextArea input;

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

	public ToolsMenu getToolsMenu() {
		return this.tools;
	}

	public JTextArea getInput() {
		return this.input;
	}

}
