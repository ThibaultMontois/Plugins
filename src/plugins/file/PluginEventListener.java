package plugins.file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import plugins.Plugin;
import plugins.editor.PluginFrame;

/**
 * Executes the method actionPerformed when one click on the corresponding item
 * in the tools menu.
 * 
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class PluginEventListener implements ActionListener {

	private PluginFrame frame;
	private Plugin plugin;

	/**
	 * Constructs a PluginEventListener with given frame and plugin.
	 * 
	 * @param frame
	 *            the programm's frame that contains the text area to transform
	 * @param plugin
	 *            the plugin that's contains the transform method to execute
	 */
	public PluginEventListener(PluginFrame frame, Plugin plugin) {
		super();
		this.frame = frame;
		this.plugin = plugin;
	}

	/**
	 * @return the listener's frame
	 */
	public PluginFrame getFrame() {
		return this.frame;
	}

	/**
	 * @return the listener's plugin
	 */
	public Plugin getPlugin() {
		return this.plugin;
	}

	/**
	 * Gets the frame text input and changes it with the plugin's transform
	 * method.
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String input = this.frame.getInput().getText();
		String output = this.plugin.transform(input);
		this.frame.getInput().setText(output);
	}

}
