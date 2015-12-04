package test.plugins.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import plugins.file.PluginChangedListener;
import plugins.file.PluginFinder;
import test.plugins.mock.ListenerMock;

public class PluginFinderTest {

	private int numberOfListeners = 10;
	private PluginFinder finder;

	@Before
	public void createPluginFinderAndAddListener() {
		this.finder = new PluginFinder("dropinsTest/");
		assertNotNull(this.finder);

		for (int i = 0; i < this.numberOfListeners; i++) {
			this.finder.addListener(new ListenerMock());
			assertEquals(i + 1, this.finder.getListeners().size());
		}
	}

	@Test
	public void testGetAndSetDirectory() {
		assertEquals("dropinsTest", this.finder.getDirectory().getPath());
		this.finder.setDirectory("dropins/");
		assertEquals("dropins", this.finder.getDirectory().getPath());
	}

	@Test
	public void testGetPlugins() {
		assertNotNull(this.finder.getPlugins());
		assertEquals(0, this.finder.getPlugins().size());
	}

	@Test
	public void testGetListeners() {
		assertNotNull(this.finder.getListeners().size());
		assertEquals(this.numberOfListeners, this.finder.getListeners().size());
	}

	@Test
	public void testCheckPlugins() {
		assertEquals(0, this.finder.getPlugins().size());
		this.finder.checkPlugins();
		assertEquals(1, this.finder.getPlugins().size());
		this.finder.setDirectory("dropinsTest/empty/");
		this.finder.checkPlugins();
		assertEquals(0, this.finder.getPlugins().size());
	}

	@Test
	public void testFirePluginAddedAndRemoved() {
		for (PluginChangedListener listener : this.finder.getListeners()) {
			assertEquals(0, ((ListenerMock) listener).getAddedEventsReceived());
		}

		for (PluginChangedListener listener : this.finder.getListeners()) {
			assertEquals(0,
					((ListenerMock) listener).getRemovedEventsReceived());
		}

		for (int i = 1; i <= 1001; i++) {
			this.finder.setDirectory("dropinsTest/");

			this.finder.checkPlugins();
			for (PluginChangedListener listener : this.finder.getListeners()) {
				assertEquals(i,
						((ListenerMock) listener).getAddedEventsReceived());
			}

			this.finder.checkPlugins();
			for (PluginChangedListener listener : this.finder.getListeners()) {
				assertEquals(i,
						((ListenerMock) listener).getAddedEventsReceived());
			}

			this.finder.setDirectory("dropinsTest/empty/");

			this.finder.checkPlugins();
			for (PluginChangedListener listener : this.finder.getListeners()) {
				assertEquals(i,
						((ListenerMock) listener).getRemovedEventsReceived());
			}
		}
	}

}
