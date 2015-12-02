package plugins.file;

public interface PluginListener {

	public void addedLogger(PluginEvent event);

	public void removedLogger(PluginEvent event);

}
