package test.plugins.timer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import plugins.file.PluginFinder;
import plugins.timer.ConfigurableTimer;

/**
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class ConfigurableTimerTest {

	private PluginFinder finder;
	private ConfigurableTimer timer;

	@Before
	public void createConfigurableTimer() {
		this.finder = new PluginFinder("dropinsTest/");
		assertNotNull(this.finder);

		this.timer = new ConfigurableTimer(2000);
		assertNotNull(this.timer);
	}

	@Test
	public void testGetFinders() {
		assertNotNull(this.timer.getFinders());
	}

	@Test
	public void testAddAndRemoveFinder() {
		assertEquals(0, this.timer.getFinders().size());

		this.timer.addFinder(this.finder);
		assertEquals(1, this.timer.getFinders().size());
		assertSame(this.finder, this.timer.getFinders().get(0));
		
		this.timer.removeFinder(this.finder);
		assertEquals(0, this.timer.getFinders().size());
	}
	
	@Test
	public void testActionPerformed() {
		this.timer.addFinder(this.finder);
		
		assertEquals(0, this.finder.getPlugins().size());

		this.timer.actionPerformed(null);
		assertEquals(1, this.finder.getPlugins().size());

		this.finder.setDirectory("dropinsTest/empty/");
		this.timer.actionPerformed(null);
		assertEquals(0, this.finder.getPlugins().size());
	}

}
