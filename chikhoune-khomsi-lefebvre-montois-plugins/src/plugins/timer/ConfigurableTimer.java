package plugins.timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import plugins.file.PluginFinder;

/**
 * A ConfigurableTimer is a timer that executes regularly the checkPlugins
 * method of a given plugin finder.
 * 
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
@SuppressWarnings("serial")
public class ConfigurableTimer extends Timer implements ActionListener {

	private PluginFinder finder;

	/**
	 * Constructs a ConfigurableTimer with given delay and plugin finder.
	 * 
	 * @param delay
	 *            the delay of recovery of the method actionPerformed
	 * @param finder
	 *            the plugin finder
	 */
	public ConfigurableTimer(int delay, PluginFinder finder) {
		super(delay, null);
		this.finder = finder;
		this.addActionListener(this);
	}

	/**
	 * @return the plugin finder
	 */
	public PluginFinder getFinder() {
		return this.finder;
	}

	/**
	 * Executes the checkPlugins method of the plugin finder.
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent actionEvent) {
		this.finder.checkPlugins();
	}

}
