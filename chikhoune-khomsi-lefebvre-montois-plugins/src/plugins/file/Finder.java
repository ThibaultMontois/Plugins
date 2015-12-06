package plugins.file;

/**
 * The Finder interface contains the signatures of the methods that must be
 * implemented by the Finder's classes.
 * 
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public interface Finder {

	/**
	 * Search for added or removed files.
	 */
	public void checkFiles();

}
