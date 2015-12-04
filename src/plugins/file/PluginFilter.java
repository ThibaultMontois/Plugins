package plugins.file;

import java.io.File;
import java.io.FilenameFilter;

import plugins.Plugin;

/**
 * A PluginFilter is a filter that accepts only files that corresponds to a
 * plugin.
 * 
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class PluginFilter implements FilenameFilter {

	/**
	 * Tests if the given file is a plugin.
	 * 
	 * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
	 */
	public boolean accept(File directory, String fileName) {
		String className;
		Class<?> classFile;

		if (!fileName.toLowerCase().endsWith(".class"))
			return false;

		className = fileName.substring(0, fileName.indexOf(".class"));

		try {
			classFile = Class.forName("plugins." + className);
		} catch (ClassNotFoundException e) {
			return false;
		}

		return this.implementsPlugin(classFile)
				&& this.hasAConstructorWithoutParameters(classFile);
	}

	/**
	 * Tests if the given class implements Plugin.
	 * 
	 * @param classFile
	 *            the class to test
	 * @return true if the class implements Plugin, else false
	 */
	private boolean implementsPlugin(Class<?> classFile) {
		return Plugin.class.isAssignableFrom(classFile);
	}

	/**
	 * Tests if the class has a constructor without parameters.
	 * 
	 * @param classFile
	 *            the class to test
	 * @return true if the class has a constructor without parameters, else
	 *         false
	 */
	private boolean hasAConstructorWithoutParameters(Class<?> classFile) {
		try {
			classFile.getConstructor();
		} catch (NoSuchMethodException | SecurityException e) {
			return false;
		}
		return true;
	}

}
