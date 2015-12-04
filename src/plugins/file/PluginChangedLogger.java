package plugins.file;

import javax.swing.JMenuItem;

import plugins.Plugin;
import plugins.editor.PluginFrame;

public class PluginChangedLogger implements PluginChangedListener {

	private PluginFrame frame;

	public PluginChangedLogger(PluginFrame frame) {
		this.frame = frame;
	}

	public PluginFrame getFrame() {
		return this.frame;
	}

	@Override
	public void addPlugin(PluginChangedEvent event) {
		Plugin plugin = event.getPlugin();
		if (plugin != null) {
			JMenuItem item = new JMenuItem(plugin.getLabel());
			item.addActionListener(new PluginEventListener(this.frame, plugin));
			this.frame.getToolsMenu().addItem(item, plugin.getLabel());
		}
	}

	@Override
	public void removePlugin(PluginChangedEvent event) {
		Plugin plugin = event.getPlugin();
		if (plugin != null)
			this.frame.getToolsMenu().removeItem(plugin.getLabel());
	}

}
