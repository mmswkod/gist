package org.forfun.gist.similarity;

public class StringSimilarityFactory {

	public static StringSimilarity create() {		
		return new EditDistance();
	}
	
}
