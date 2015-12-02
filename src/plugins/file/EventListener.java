package plugins.file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import plugins.Plugin;
import plugins.editor.PluginFrame;

public class EventListener implements ActionListener {

	private PluginFrame frame;
	private Plugin plugin;

	public EventListener(PluginFrame frame, Plugin plugin) {
		super();
		this.frame = frame;
		this.plugin = plugin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String input = this.frame.getInput().getText();
		String output = this.plugin.transform(input);
		this.frame.getInput().setText(output);
	}

}
