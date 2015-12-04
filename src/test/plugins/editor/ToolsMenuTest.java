package test.plugins.editor;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import javax.swing.JMenuItem;

import plugins.editor.ToolsMenu;

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
	public void testAddAndRemoveItem() {
		assertEquals(0, this.tools.getItemCount());
		assertFalse(this.tools.getItems().containsKey("LabelTest"));

		this.tools.addItem(new JMenuItem(), "LabelTest");
		assertEquals(1, this.tools.getItemCount());
		assertTrue(this.tools.getItems().containsKey("LabelTest"));

		this.tools.removeItem("LabelTest");
		assertEquals(0, this.tools.getItemCount());
		assertFalse(this.tools.getItems().containsKey("LabelTest"));
	}

}
