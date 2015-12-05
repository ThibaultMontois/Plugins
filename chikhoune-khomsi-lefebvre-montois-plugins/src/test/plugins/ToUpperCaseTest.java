package test.plugins;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import plugins.ToUpperCase;

public class ToUpperCaseTest {

	private ToUpperCase toUpperCase;

	@Before
	public void createToUpperCase() {
		this.toUpperCase = new ToUpperCase();
		assertNotNull(this.toUpperCase);
	}

	@Test
	public void testTransform() {
		String input = "to upper";
		assertEquals("TO UPPER", this.toUpperCase.transform(input));
	}

	@Test
	public void testGetLabel() {
		assertEquals("To Upper Case", this.toUpperCase.getLabel());
	}

}
