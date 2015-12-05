package plugins.file;

/**
 * The PluginChangedListener interface contains the signatures of the methods
 * that must be implemented by the PluginChangedListener's classes.
 * 
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public interface PluginChangedListener {

	/**
	 * Adds the plugin contained in the given event.
	 * 
	 * @param event
	 *            the event that contains the plugin to add
	 */
	public void addPlugin(PluginChangedEvent event);

	/**
	 * Removes the plugin contained in the given event.
	 * 
	 * @param event
	 *            the event that contains the plugin to remove
	 */
	public void removePlugin(PluginChangedEvent event);

}
