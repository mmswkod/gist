package org.forfun.gist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.forfun.gist.similarity.StringSimilarity;
import org.forfun.gist.similarity.StringSimilarityFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordSearchTreeTest {

	WordSearchTree st;;
	
	@Before
    public void setUp() {
		st = new WordSearchTree();
		st.add("peon");
		st.add("ad");
		st.add("pacemaker");
		st.add("peonage");
		st.add("people");
		st.add("matter");
		st.add("pelican");
		st.add("pelike");

    }
		

	@Test
	public void testIsThere() {
		Assert.assertTrue(st.isThere("matter"));
	}

	@Test(expected=RuntimeException.class)
	public void testAddNull(){
		st.add(null);
	}
	
	@Test
	public void testGet() {
		String peon = st.get("peon");
		Assert.assertEquals("peon", peon);
		
		String pelican = st.get("pelican");
		Assert.assertEquals("pelican", pelican);
	}

	@Test
	public void testKeysWithPrefixThatIsNotPresent() {
		Iterable<String> words = st.keysWithPrefix("t");
		Assert.assertNull(words);
	}

	@Test
	public void testKeysWithPrefix() {
		Iterable<String> words = st.keysWithPrefix("peo");
		Assert.assertNotNull(words);
		Assert.assertEquals("[peon, peonage, people]", words.toString());
		
	}
	
	@Test
	public void testTrieSize() throws IOException{
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("words.txt");

		BufferedReader bf = new BufferedReader(new InputStreamReader(is));

		WordSearchTree wst = new WordSearchTree();
		String word;

		while ((word = bf.readLine()) != null) {
			wst.add(word);
		}
		
		Assert.assertEquals(235886, wst.size());

	}

	@Test
	public void testPrefix() throws IOException{
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("words.txt");

		BufferedReader bf = new BufferedReader(new InputStreamReader(is));

		WordSearchTree wst = new WordSearchTree();
		String word;

		while ((word = bf.readLine()) != null) {
			wst.add(word);
		}
		
		Iterable<String> words = wst.keysWithPrefix("foa");
		System.out.println(words);
		StringSimilarity similarity = StringSimilarityFactory.create();
		List<String> ww = similarity.similarities("ffoaoaoaoaoaoaaoaoaoaoaoadd", words, 1);
		System.out.println(ww);

	}

}
