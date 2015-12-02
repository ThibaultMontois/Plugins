package plugins.file;

import java.io.File;
import java.io.FilenameFilter;

import plugins.Plugin;

public class PluginFilter implements FilenameFilter {

	private boolean hasAConstructorWithoutParameters(Class<?> classFile)
			throws NoSuchMethodException, SecurityException {
		return classFile.getConstructor() != null;
	}

	private boolean belongsToThePluginsPackage(Class<?> classFile) {
		return classFile.getPackage().getName().equals("plugins");
	}

	private boolean implementsPlugin(Class<?> classFile) {
		return Plugin.class.isAssignableFrom(classFile);
	}

	private boolean isAPlugin(String file) throws ClassNotFoundException,
			NoSuchMethodException, SecurityException {
		if (file.toLowerCase().endsWith(".class")) {
			String fileName = file.substring(0, file.length() - 6);
			Class<?> classFile = Class.forName("plugins." + fileName);
			return this.implementsPlugin(classFile)
					&& this.belongsToThePluginsPackage(classFile)
					&& this.hasAConstructorWithoutParameters(classFile);
		}
		return false;
	}

	public boolean accept(File directory, String filename) {
		try {
			return this.isAPlugin(filename);
		} catch (ClassNotFoundException | NoSuchMethodException
				| SecurityException e) {
			return false;
		}
	}

}
