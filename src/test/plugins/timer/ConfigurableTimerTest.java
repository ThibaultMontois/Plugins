package test.plugins.timer;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import plugins.file.PluginFinder;
import plugins.timer.ConfigurableTimer;

public class ConfigurableTimerTest {

	private PluginFinder finder;
	private ConfigurableTimer timer;

	@Before
	public void createConfigurableTimer() {
		this.finder = new PluginFinder("dropinsTest/");
		assertNotNull(this.finder);

		this.timer = new ConfigurableTimer(2000, this.finder);
		assertNotNull(this.timer);
	}

	@Test
	public void testGetFinder() {
		assertSame(this.finder, this.timer.getFinder());
	}

	@Test
	public void testActionPerformed() {
		assertEquals(0, this.finder.getPlugins().size());
		
		this.timer.actionPerformed(null);
		assertEquals(1, this.finder.getPlugins().size());
		
		this.finder.setDirectory("dropinsTest/empty/");	
		this.timer.actionPerformed(null);
		assertEquals(0, this.finder.getPlugins().size());
	}

}
