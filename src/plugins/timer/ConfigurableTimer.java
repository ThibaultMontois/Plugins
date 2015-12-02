package plugins.timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import plugins.file.PluginFinder;

@SuppressWarnings("serial")
public class ConfigurableTimer extends Timer implements ActionListener {

	private PluginFinder finder;

	public ConfigurableTimer(int delay, PluginFinder finder) {
		super(delay, null);
		this.finder = finder;
		this.addActionListener(this);
	}

	public void actionPerformed(ActionEvent actionEvent) {
		this.finder.checkPlugins();
	}

}
