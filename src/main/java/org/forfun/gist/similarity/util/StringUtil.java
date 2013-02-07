package org.forfun.gist.similarity.util;

public class StringUtil {

	public static String removeDuplicated(String s) {
		if(s == null) return null;
		return s.replaceAll("(.)\\1+", "$1");
	
	}

}
