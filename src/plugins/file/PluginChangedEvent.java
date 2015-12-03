package plugins.file;

import java.io.File;

import plugins.Plugin;

public class PluginChangedEvent {

	private Plugin plugin;

	public PluginChangedEvent(File source) {
		this.plugin = this.toPlugin(source);
	}

	public Plugin getPlugin() {
		return this.plugin;
	}

	private Plugin toPlugin(File source) {
		String filename = source.getName();
		filename = filename.substring(0, filename.indexOf(".class"));
		Class<?> classFile;
		try {
			classFile = Class.forName("plugins." + filename);
			return (Plugin) classFile.newInstance();
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			return null;
		}
	}

}
