package test.plugins.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import plugins.editor.ToolsMenu;
import plugins.file.PluginChangedEvent;

/**
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class ToolsMenuTest {

	private ToolsMenu tools;

	@Before
	public void createToolsMenu() {
		this.tools = new ToolsMenu("ToolsMenuTest");
		assertNotNull(this.tools);
	}

	@Test
	public void testGetItems() {
		assertNotNull(this.tools.getItems());
	}

	@Test
	public void testAddAndRemovePlugin() {
		File file = new File("dropinsTest/APlugin.class");
		assertNotNull(file);

		PluginChangedEvent event = new PluginChangedEvent(this, file, true);
		assertNotNull(event);
		assertNotNull(event.getPlugin());
		assertNotNull(event.getItem());

		assertEquals(0, this.tools.getItemCount());
		assertFalse(this.tools.getItems().containsKey("A PLugin"));

		this.tools.addPlugin(event);
		assertEquals(1, this.tools.getItemCount());
		assertTrue(this.tools.getItems().containsKey("A Plugin"));

		this.tools.removePlugin(event);
		assertEquals(0, this.tools.getItemCount());
		assertFalse(this.tools.getItems().containsKey("A Plugin"));
	}

}
