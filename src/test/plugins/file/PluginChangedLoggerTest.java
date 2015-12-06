package test.plugins.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import plugins.editor.PluginFrame;
import plugins.file.PluginChangedEvent;
import plugins.file.PluginChangedLogger;

/**
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class PluginChangedLoggerTest {

	private PluginFrame frame;
	private PluginChangedLogger logger;

	@Before
	public void createPluginChangedLogger() {
		this.frame = new PluginFrame(false);
		assertNotNull(this.frame);

		this.logger = new PluginChangedLogger(frame);
		assertNotNull(this.logger);
	}

	@Test
	public void testGetFrame() {
		assertSame(this.frame, this.logger.getFrame());
	}

	@Test
	public void testAddAndRemovePlugin() {
		File file = new File("dropinsTest/APlugin.class");
		assertNotNull(file);

		PluginChangedEvent event = new PluginChangedEvent(this, file, true);
		assertNotNull(event);
		assertNotNull(event.getPlugin());
		assertNotNull(event.getItem());
		assertEquals(0, event.getItem().getActionListeners().length);

		this.logger.addPlugin(event);
		assertEquals(1, event.getItem().getActionListeners().length);

		this.logger.removePlugin(event);
		assertEquals(0, event.getItem().getActionListeners().length);
	}

}
