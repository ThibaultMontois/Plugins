package plugins.file;

import javax.swing.JMenuItem;

import plugins.Plugin;
import plugins.editor.PluginFrame;

public class PluginsChangedLogger implements PluginListener {

	private PluginFrame frame;

	public PluginsChangedLogger(PluginFrame frame) {
		this.frame = frame;
	}

	@Override
	public void addedLogger(PluginEvent event) {
		Plugin plugin = event.getPlugin();
		if (plugin != null) {
			JMenuItem item = new JMenuItem(plugin.getLabel());
			item.addActionListener(new EventListener(this.frame, plugin));
			this.frame.getToolsMenu().addItem(item, plugin.getLabel());
		}
	}

	@Override
	public void removedLogger(PluginEvent event) {
		Plugin plugin = event.getPlugin();
		if (plugin != null)
			this.frame.getToolsMenu().removeItem(plugin.getLabel());
	}

}
