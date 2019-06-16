package myspringboot.service;


import org.junit.Assert;
import org.junit.Test;



public class AnagramTest {
/**
 * Tests if two words are anagrams
 */
	@Test
	public void testareAnagrams() {
	
    Assert.assertTrue( Anagram.areAnagrams("yyyzzbbb", "bbbyyyzz"));
    Assert.assertFalse( Anagram.areAnagrams("yyyzzbbby", "bbbyyyzz"));
    Assert.assertFalse( Anagram.areAnagrams(null, "bbbyyyzz"));
    Assert.assertFalse( Anagram.areAnagrams( "bbbyyyzz", null));
    Assert.assertTrue( Anagram.areAnagrams("kyyyzzbbb", "bbbyyyzkz"));
    Assert.assertTrue( Anagram.areAnagrams("kyYYzzbbb", "bbbyyyzkz"));
    
	}

}
