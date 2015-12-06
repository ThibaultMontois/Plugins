package test.plugins.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;

import javax.swing.JMenuItem;

import org.junit.Test;

import plugins.Plugin;
import plugins.file.PluginChangedEvent;

/**
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class PluginChangedEventTest {

	private PluginChangedEvent event;

	@Test
	public void createPluginChangedEventWithAPluginSource() {
		File file = new File("dropinsTest/APlugin.class");
		assertNotNull(file);

		this.event = new PluginChangedEvent(this, file, true);
		assertNotNull(this.event);

		Plugin plugin = this.event.getPlugin();
		assertNotNull(plugin);
		assertEquals("A Plugin", plugin.getLabel());
	}

	@Test
	public void pluginIsNullWhenCreatingAPluginChangedEventWithoutAPluginSource() {
		File file = new File(
				"dropinsTest/NotHasAConstructorWithoutParameters.class");
		assertNotNull(file);

		this.event = new PluginChangedEvent(this, file, false);
		assertNotNull(this.event);
		assertNull(this.event.getPlugin());
	}

	@Test
	public void createAJMenuItemWhenAddEventIsTrue() {
		File file = new File("dropinsTest/APlugin.class");
		assertNotNull(file);

		this.event = new PluginChangedEvent(this, file, true);
		assertNotNull(this.event);

		JMenuItem item = this.event.getItem();
		assertNotNull(item);
	}

	@Test
	public void notCreateAJMenuItemWhenAddEventIsFalse() {
		File file = new File("dropinsTest/APlugin.class");
		assertNotNull(file);

		this.event = new PluginChangedEvent(this, file, false);
		assertNotNull(this.event);

		JMenuItem item = this.event.getItem();
		assertNull(item);
	}

}
