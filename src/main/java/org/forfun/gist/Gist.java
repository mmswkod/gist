package org.forfun.gist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.forfun.gist.similarity.StringSimilarityFactory;
import org.forfun.gist.similarity.util.StringUtil;


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
			wst.add(word.toLowerCase());
		}

	}

	/**
	 * Create a gist using a dict provided by inputstream
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static Gist create(InputStream is) throws IOException {
		return new Gist(is);
	}

	/**
	 * Return the number of string that match the similarity in s 
	 * @param s 
	 * @param top number of strings returned
	 * @return
	 */
	public List<String> matchSimilarity(String s, int top) {

		String key = wst.get(s);
		if(key != null) return Arrays.asList(key);
				
		s = StringUtil.removeDuplicated(s.toLowerCase());
		Iterable<String> words = wst.keysWithPrefix(s);
		
		int count = 0;
		String prefix = new String(s.substring(0, ++count));
		while(words == null && s.length() > 0 && count < s.length()){			
			words = wst.keysWithPrefix(prefix);
			prefix = new String(s.substring(0, ++count));
			
		}
		
		if(words == null) return Arrays.asList("NO SUGGESTION");
				
		return StringSimilarityFactory.create().similarities(s, words, top);
	}

	
	
}
