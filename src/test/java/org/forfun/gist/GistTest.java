package org.forfun.gist;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class GistTest {

	Gist gist;
	@Before
	public void setup() throws IOException{
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("words.txt");
		gist = Gist.create(is);
	}
	
	@Test
	public void testMathSimilarity() {
		Assert.assertNotNull(gist);
		List<String> words = gist.matchSimilarity("sandwich", 1);
		Assert.assertEquals("sandwich", words.get(0));
		
		words = gist.matchSimilarity("sheeeeep", 1);
		Assert.assertEquals("sheppey", words.get(0));
				
		words = gist.matchSimilarity("shej", 1);
		Assert.assertEquals("she", words.get(0));
		
		words = gist.matchSimilarity("CUNsperrICY", 1);
		Assert.assertEquals("conspiracy", words.get(0));

	}

	@Test
	public void testMathSimilarityNoSuggestion() {
		Assert.assertNotNull(gist);
		List<String> words = gist.matchSimilarity("12shej", 1);
		Assert.assertEquals("NO SUGGESTION", words.get(0));

	}

}
