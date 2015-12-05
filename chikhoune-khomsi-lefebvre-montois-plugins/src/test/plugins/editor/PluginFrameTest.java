package test.plugins.editor;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import plugins.editor.PluginFrame;
import test.plugins.mock.PluginFrameMock;

/**
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class PluginFrameTest {

	private PluginFrame frame;

	@Before
	public void createPluginFrame() {
		this.frame = new PluginFrameMock();
		assertNotNull(this.frame);
	}

	@Test
	public void testGetToolsMenu() {
		assertNotNull(this.frame.getToolsMenu());
	}

	@Test
	public void testGetInput() {
		assertNotNull(this.frame.getInput());
	}

}
