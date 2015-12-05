package test.plugins.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import plugins.Plugin;
import plugins.editor.PluginFrame;
import plugins.file.PluginEventListener;
import test.plugins.mock.PluginMock;

/**
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class PluginEventListenerTest {

	private PluginFrame frame;
	private Plugin plugin;
	private PluginEventListener listener;

	@Before
	public void createPluginEventListener() {
		this.frame = new PluginFrame(false);
		assertNotNull(this.frame);

		this.plugin = new PluginMock();
		assertNotNull(this.plugin);
		assertEquals("Plugin's Mock", this.plugin.getLabel());

		this.listener = new PluginEventListener(this.frame, this.plugin);
		assertNotNull(this.listener);
	}

	@Test
	public void testGetFrame() {
		assertSame(this.frame, this.listener.getFrame());
	}

	@Test
	public void testGetPlugin() {
		assertSame(this.plugin, this.listener.getPlugin());
	}

	@Test
	public void testActionPerformed() {
		assertTrue(this.frame.getInput().getText().isEmpty());

		this.listener.actionPerformed(null);
		assertFalse(this.frame.getInput().getText().isEmpty());
		assertEquals("I'm a plugin's mock", this.frame.getInput().getText());
	}

}
