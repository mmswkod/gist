package org.forfun.gist;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("words.txt");
		Gist gist = Gist.create(is);
		
		Scanner sc = new Scanner(System.in);
		String cmd = "";
		while (sc.hasNext() && !"exit".equals(cmd)) {
			cmd = checkExit(sc.next());
		}
		
		String s = null;
		List<String> words = gist.mathSimilarity(s, 1);

	}

	private static String checkExit(String cmd) {
		if ("exit".equals(cmd)) {
			System.out.println("Goodbye!!!");
			System.exit(0);
		}
		
		return cmd;
	}
}
