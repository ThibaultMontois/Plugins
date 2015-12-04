package test.plugins.mock;

import plugins.file.PluginChangedEvent;
import plugins.file.PluginChangedListener;

public class ListenerMock implements PluginChangedListener {

	private int addedEventsReceived;
	private int removedEventsReceived;

	public ListenerMock() {
		this.addedEventsReceived = 0;
		this.removedEventsReceived = 0;
	}

	public int getAddedEventsReceived() {
		return this.addedEventsReceived;
	}

	public int getRemovedEventsReceived() {
		return this.removedEventsReceived;
	}

	@Override
	public void addPlugin(PluginChangedEvent event) {
		this.addedEventsReceived++;
	}

	@Override
	public void removePlugin(PluginChangedEvent event) {
		this.removedEventsReceived++;
	}
}
