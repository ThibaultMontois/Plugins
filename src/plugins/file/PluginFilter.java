package plugins.file;

import java.io.File;
import java.io.FilenameFilter;

import plugins.Plugin;

public class PluginFilter implements FilenameFilter {

	public boolean accept(File directory, String filename) {
		try {
			return this.isAPlugin(filename);
		} catch (ClassNotFoundException e) {
			return false;
		}
	}

	private boolean isAPlugin(String file) throws ClassNotFoundException {
		String filename;
		Class<?> classFile;

		if (!file.toLowerCase().endsWith(".class"))
			return false;

		filename = file.substring(0, file.indexOf(".class"));
		classFile = Class.forName("plugins." + filename);

		return this.implementsPlugin(classFile)
				&& this.hasAConstructorWithoutParameters(classFile);
	}

	private boolean implementsPlugin(Class<?> classFile) {
		return Plugin.class.isAssignableFrom(classFile);
	}

	private boolean hasAConstructorWithoutParameters(Class<?> classFile) {
		try {
			classFile.getConstructor();
		} catch (NoSuchMethodException | SecurityException e) {
			return false;
		}
		return true;
	}

}
