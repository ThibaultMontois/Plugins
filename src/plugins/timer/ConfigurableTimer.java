package plugins.timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.Timer;

import plugins.file.Finder;

/**
 * A ConfigurableTimer is a timer that executes regularly the checkFiles
 * method of a given finder.
 * 
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
@SuppressWarnings("serial")
public class ConfigurableTimer extends Timer implements ActionListener {

	private List<Finder> finders;

	/**
	 * Constructs a ConfigurableTimer with given delay.
	 * 
	 * @param delay
	 *            the delay of recovery of the method actionPerformed
	 */
	public ConfigurableTimer(int delay) {
		super(delay, null);
		this.finders = new LinkedList<Finder>();
		this.addActionListener(this);
	}

	/**
	 * @return the finders list
	 */
	public List<Finder> getFinders() {
		return this.finders;
	}

	/**
	 * Adds a finder to the finders list.
	 * 
	 * @param finder
	 *            the finder to add
	 */
	public void addFinder(Finder finder) {
		this.finders.add(finder);
	}

	/**
	 * Removes a finder from the finders list.
	 * 
	 * @param finder
	 *            the finder to remove
	 */
	public void removeFinder(Finder finder) {
		this.finders.remove(finder);
	}

	/**
	 * Executes the checkFiles method of all the finders.
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent actionEvent) {
		for (Finder finder : this.finders)
			finder.checkFiles();
	}

}
