package test.plugins.editor;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import plugins.editor.PluginFrame;

public class PluginFrameTest {

	private PluginFrame frame;

	@Before
	public void createPluginFrame() {
		this.frame = new PluginFrame();
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
