package test.plugins;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import plugins.DeleteVowels;

public class DeleteVowelsTest {

	private DeleteVowels deleteVowels;

	@Before
	public void createDeleteVowels() {
		this.deleteVowels = new DeleteVowels();
		assertNotNull(this.deleteVowels);
	}

	@Test
	public void testInitializeVowels() {
		String vowels = "aàâäeéèêêiîïoôöuûüyŷÿAÀÂÄEÉÈÊËIÎÏOÔÖUÛÜYŶŸ";
		for (int i = 0; i < vowels.length(); i++)
			assertTrue(this.deleteVowels.getVowels().contains(vowels.charAt(i)));
	}

	@Test
	public void testTransform() {
		String input = "abcdefghijklmnopqrstuvwxyz";
		assertEquals("bcdfghjklmnpqrstvwxz", this.deleteVowels.transform(input));
	}

	@Test
	public void testGetLabel() {
		assertEquals("Delete Vowels", this.deleteVowels.getLabel());
	}

}
