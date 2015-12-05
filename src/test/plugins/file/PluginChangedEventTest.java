package test.plugins.file;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import java.io.File;

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

		this.event = new PluginChangedEvent(this, file);
		assertNotNull(this.event);

		Plugin plugin = this.event.getPlugin();
		assertNotNull(plugin);
		assertEquals("A Plugin", plugin.getLabel());
	}

	@Test
	public void pluginIsNullWhenCreatingAPluginChangedEventWithoutAPluginSource() {
		File file = new File("dropinsTest/NotHasAConstructorWithoutParameters.class");
		assertNotNull(file);

		this.event = new PluginChangedEvent(this, file);
		assertNotNull(this.event);
		assertNull(this.event.getPlugin());
	}

}
