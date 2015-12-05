package test.plugins;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import plugins.ToLowerCase;

public class ToLowerCaseTest {

	private ToLowerCase toLowerCase;

	@Before
	public void createToUpperCase() {
		this.toLowerCase = new ToLowerCase();
		assertNotNull(this.toLowerCase);
	}

	@Test
	public void testTransform() {
		String input = "TO LOWER";
		assertEquals("to lower", this.toLowerCase.transform(input));
	}

	@Test
	public void testGetLabel() {
		assertEquals("To Lower Case", this.toLowerCase.getLabel());
	}

}
