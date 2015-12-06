package test.plugins.file;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

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
		File file = new File("dropinsTest/APlugin.class");
		assertNotNull(file);
		assertTrue(this.filter.accept(null, file.getName()));

		file = new File("dropinsTest/NotAClassFile");
		assertNotNull(file);
		assertFalse(this.filter.accept(null, file.getName()));

		file = new File("dropinsTest/NotInPluginsPackage.class");
		assertNotNull(file);
		assertFalse(this.filter.accept(null, file.getName()));
		
		file = new File("dropinsTest/NotImplementsPlugin.class");
		assertNotNull(file);
		assertFalse(this.filter.accept(null, file.getName()));

		file = new File("dropinsTest/NotHasAConstructorWithoutParameters.class");
		assertNotNull(file);
		assertFalse(this.filter.accept(null, file.getName()));
	}

}
