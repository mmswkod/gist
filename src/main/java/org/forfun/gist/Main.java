package org.forfun.gist;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static final String EXIT = "exit";

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("words.txt");
		Gist gist = Gist.create(is);
		
		Scanner sc = new Scanner(System.in);
		String cmd = "";
		List<String> words;
		System.out.println("Type a word (exit to leave the app)");
		System.out.println("> ");
		while (sc.hasNext() && !EXIT.equals(cmd)) {
			cmd = checkExit(sc.next());
			words = gist.matchSimilarity(cmd, 1);
			System.out.println("> "+words.get(0));
			System.out.println("> ");
		}		
		

	}

	private static String checkExit(String cmd) {
		if (EXIT.equals(cmd)) {
			System.out.println("Goodbye!!!");
			System.exit(0);
		}
		
		return cmd;
	}
}
