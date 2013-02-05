package org.forfun.gist;

import static org.junit.Assert.*;

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

	@Test
	public void testGet() {
		String peon = st.get("peon");
		Assert.assertEquals("peon", peon);
		
		String s = st.get("peonpp");
		Assert.assertEquals("peonpp", s);
	}

	@Test
	public void testKeysWithPrefix() {
		Iterable<String> words = st.keysWithPrefix("t");
		for (String word : words) {
			System.out.println(word);
		}
	}

}
