package test.plugins.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import plugins.editor.PluginFrame;
import plugins.editor.ToolsMenu;
import plugins.file.PluginChangedEvent;
import plugins.file.PluginChangedLogger;
import test.plugins.mock.PluginFrameMock;

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
		this.frame = new PluginFrameMock();
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
		ToolsMenu tools = this.frame.getToolsMenu();
		assertEquals(0, tools.getItemCount());
		assertFalse(tools.getItems().containsKey("A Plugin"));

		File source = new File("dropinsTest/APlugin.class");
		assertNotNull(source);

		PluginChangedEvent event = new PluginChangedEvent(source);
		assertNotNull(event);

		this.logger.addPlugin(event);
		assertEquals(1, tools.getItemCount());
		assertTrue(tools.getItems().containsKey("A Plugin"));
		assertEquals(1,
				tools.getItems().get("A Plugin").getActionListeners().length);

		this.logger.removePlugin(event);
		assertEquals(0, tools.getItemCount());
		assertFalse(tools.getItems().containsKey("A Plugin"));
	}

}
