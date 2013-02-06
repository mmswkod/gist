package org.forfun.gist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.forfun.gist.similarity.StringSimilarity;
import org.forfun.gist.similarity.StringSimilarityFactory;

public class Gist {

	WordSearchTree wst = new WordSearchTree();
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	private Gist(InputStream is) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(is));

		String word;

		while ((word = bf.readLine()) != null) {
			wst.add(word);
		}

	}

	public static Gist create(InputStream is) throws IOException {
		return new Gist(is);
	}

	public List<String> mathSimilarity(String s, int top) {

		String key = wst.get(s);
		if(key != null) return Arrays.asList("key");		
		
		StringSimilarity similarity = StringSimilarityFactory.create();
		s = correctSpellingMistakes(s);		
		return similarity.similarities(s, wst.keysWithPrefix(s), top);
	}

	private String correctSpellingMistakes(String s) {
		// TODO Auto-generated method stub
		return null;
	}

}
