package org.forfun.gist;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.forfun.gist.similarity.StringSimilarity;
import org.forfun.gist.similarity.StringSimilarityFactory;
import org.junit.Test;

public class EditDistanceTest {

	@Test
	public void testSimilarities() {
		StringSimilarity similarity = StringSimilarityFactory.create();
		
		List<String> words = similarity.similarities("hello", Arrays.asList("Updater", "hallo", "sheep", "habitant", "heelllloooo", "hilo"), 1);
		
		Assert.assertEquals("hallo", words.get(0));
		
		words = similarity.similarities("hello", Arrays.asList("Updater", "hallo", "sheep", "habitant", "heelllloooo", "hilo"), 2);
		Assert.assertEquals("hallo", words.get(0));
		Assert.assertEquals("hilo", words.get(1));
		
		words = similarity.similarities("hello", Arrays.asList("Updater", "hallo", "sheep", "habitant", "heellloooo", "hilo"), 3);
		Assert.assertEquals("hallo", words.get(0));
		Assert.assertEquals("hilo", words.get(1));
		Assert.assertEquals("sheep", words.get(2));
	}

}
