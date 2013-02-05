package org.forfun.gist;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class WordSearchTree {

	protected Node root;

	private class Node {
		private String word;
		private char c;
		private Node left, mid, right;
		
	}

	public void add(String word) {
		root = add(root, word, 0);
	}

	private Node add(Node x, String word, int d) {
		char c = word.charAt(d);

		if (x == null) {
			x = new Node();
			x.c = c;
		}

		if (c < x.c)
			x.left = add(x.left, word, d);
		else if (c > x.c)
			x.right = add(x.right, word, d);
		else if (d < word.length() - 1)
			x.mid = add(x.mid, word, d + 1);
		else
			x.word = word;
		return x;
	}

	public boolean isThere(String key) {
		return get(key) != null;
	}

	public String get(String key) {
		Node x = get(root, key, 0);
		if (x == null)
			return null;

		return x.word;
	}

	private Node get(Node x, String key, int d) {
		if (x == null)
			return null;
		char c = key.charAt(d);
		if (c < x.c)
			return get(x.left, key, d);
		else if (c > x.c)
			return get(x.right, key, d);
		else if (d < key.length() - 1)
			return get(x.mid, key, d + 1);
		else
			return x;
	}

	public void delete(String key) {
		throw new RuntimeException("Opss not implemented..");
	}

	private void collect(Node x,  Queue<String> q) {
		if (x == null)
			return;
		if (x.word != null)
			q.add(x.word);

		collect(x.left,  q);
		collect(x.mid, q);		
		collect(x.right,  q);

	}

	public Iterable<String> keysWithPrefix(String prefix) {
		Queue<String> queue = new PriorityQueue<String>();
		Node x = get(root, prefix, 0);
		if(x == null) return Collections.emptyList();
		collect(x.mid, queue);
		return queue;

	}
}
