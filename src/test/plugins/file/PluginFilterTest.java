package test.plugins.file;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import plugins.file.PluginFilter;

/**
 * @author Sellenia Chikhoune
 * @author Mohammed Khomsi
 * @author Benjamin Lefebvre
 * @author Thibault Montois
 */
public class PluginFilterTest {

	private PluginFilter filter;

	@Before
	public void createPluginFilter() {
		this.filter = new PluginFilter();
		assertNotNull(this.filter);
	}

	@Test
	public void testAccept() {
		File source = new File("dropinsTest/APlugin.class");
		assertNotNull(source);
		assertTrue(this.filter.accept(null, source.getName()));

		source = new File("dropinsTest/NotAClassFile.class");
		assertNotNull(source);
		assertFalse(this.filter.accept(null, source.getName()));

		source = new File("dropinsTest/NotImplementsPlugin.class");
		assertNotNull(source);
		assertFalse(this.filter.accept(null, source.getName()));

		source = new File(
				"dropinsTest/NotHaveAConstructorWithoutParameters.class");
		assertNotNull(source);
		assertFalse(this.filter.accept(null, source.getName()));
	}

}
