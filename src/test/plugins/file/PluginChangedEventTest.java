package test.plugins.file;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import java.io.File;

import plugins.Plugin;
import plugins.file.PluginChangedEvent;

public class PluginChangedEventTest {

	private PluginChangedEvent event;

	@Test
	public void createPluginChangedEventWithAPluginSource() {
		File source = new File("dropinsTest/APlugin.class");
		assertNotNull(source);
		
		this.event = new PluginChangedEvent(source);
		assertNotNull(this.event);
		
		Plugin plugin = this.event.getPlugin();
		assertNotNull(plugin);
		assertEquals("A Plugin", plugin.getLabel());
	}

	@Test
	public void pluginIsNullWhenCreatingAPluginChangedEventWithoutAPluginSource() {
		File source = new File("dropinsTest/NotHaveAConstructorWithoutParameters.class");
		assertNotNull(source);
		
		this.event = new PluginChangedEvent(source);
		assertNotNull(this.event);
		assertNull(this.event.getPlugin());
	}

}
