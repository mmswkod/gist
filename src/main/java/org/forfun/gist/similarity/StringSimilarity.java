package org.forfun.gist.similarity;

import java.util.List;

public interface StringSimilarity {

	
	public List<String> similarities(String s, Iterable<String> words, int top);
}
