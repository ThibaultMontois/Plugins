package plugins.file;

public interface PluginChangedListener {

	public void addPlugin(PluginChangedEvent event);

	public void removePlugin(PluginChangedEvent event);

}
