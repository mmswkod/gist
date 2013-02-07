package org.forfun.gist.similarity;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


class EditDistance implements StringSimilarity {

	private static class CostSimilarity{
		public CostSimilarity(String word, int cost) {
			this.word = word;
			this.cost = cost;
		}
		String word;
		int cost;

		@Override
		public String toString() {
			return "CostSimilarity [word=" + word + ", cost=" + cost + "]";
		}
		
		
	}
	

	/**
	 * Find the similarities using Levenshtein algorithm. Compare s against each word in words
	 * and returns the amount defined in top. It uses a min heap(priority queue) behind the scenes
	 * to store the words with min cost for Levenshtein transformation.
	 */
	public List<String> similarities(String s, Iterable<String> words, int top) {
		if (s == null || words == null) {
			throw new IllegalArgumentException("Can not deal with null strings");
		}
		
		if (top < 1) {
			throw new IllegalArgumentException("At least one suggestion should desired");
		}

		PriorityQueue<CostSimilarity> queue = new PriorityQueue<CostSimilarity>(top, new Comparator<CostSimilarity>() {
			
			public int compare(CostSimilarity o1, CostSimilarity o2) {				
				if(o1.cost == o2.cost) return 0;
				
				if(o1.cost > o2.cost) return 1;
				
				return -1;
			}
		});
		
		
		for(String word: words){
			int cost = getLevenshteinDistance(s, word);
			CostSimilarity sc = new CostSimilarity(word, cost);
			
			if(queue.size() == top && queue.peek().cost > sc.cost){
				queue.poll();
			}			
			queue.add(sc);						
		}
		
		String similarities[] = new String[top];
		for(int i = 0; i < top; i++){
			similarities[i] = queue.poll().word;
		}
		return Arrays.asList(similarities);
	}

	private int getLevenshteinDistance(String s, String t) {
		if (s == null || t == null) {
			throw new IllegalArgumentException("Can not deal with null strings");
		}

		if (s.length() == 0) return t.length();		
		if (t.length() == 0) return s.length();

		int n = s.length();
		int m = t.length();
		int d[][] = new int[n + 1][m + 1];
		
		int cost;

		// matrix initialization
		for (int i = 0; i <= n; i++) d[i][0] = i;

		for (int j = 0; j <= m; j++) d[0][j] = j;


		for (int i = 1; i <= n; i++) {
			char v = s.charAt(i - 1);

			for (int j = 1; j <= m; j++) {
				char w = t.charAt(j - 1);
				
				if (v == w) {
					cost = 0;
				} else {
					cost = 1;
				}

				d[i][j] = Math.min(Math.min(d[i - 1][j] + 1, d[i][j - 1] + 1), d[i - 1][j - 1]	+ cost);
			}
		}
		return d[n][m];
	}

}
