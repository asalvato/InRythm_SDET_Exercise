package com.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Assumptions: Case Insensitive, remove punctuation from beginning and end of a word but not from middle, ignore whitespace
 */

public class FindLongestWord {

	public static void main(String[] args) {
		
		System.out.println(getLongest("The cow jumped over abcdef the moon.!"));

	}
	
	static String getLongest(String sentence) {
		
		// Create patterns to assist removing punctuation at the beginning or end of a word
		Pattern endPattern = Pattern.compile("(^(\\p{Punct}+)|(\\p{Punct}+)$)");
		Pattern noCharacterPattern = Pattern.compile("^((?=[\\W_]).)*$");
		Matcher matcher;
		
		//If sentence is null, empty, or only white-space return error statement
		if (sentence == null || sentence.isBlank()) 
			return "Please enter a non-empty sentence.";

		String[] words = sentence.split(" ");
		
		//If Sentence is one word long and does not contain any alpha characters return error statement
		if (words.length == 1) {
			matcher = noCharacterPattern.matcher(words[0]);
			if (matcher.find())
				return "Please enter a sentence with at least one word";
		}

		Integer wordLength;
		HashMap<Integer, ArrayList<String>> wordMap = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			if (!words[i].isBlank()) {
				String word = words[i].toLowerCase();
				matcher = endPattern.matcher(word);
				if (matcher.find()) {
					//System.out.println(matcher.group(1) + " : " + matcher.start(1) + " : " + matcher.end(1));
					word = matcher.replaceAll("");
				}
				
				//If the array list is empty, create a new one else add to the existing array list
				wordLength = Integer.valueOf(word.length());
				if (wordMap.get(word.length()) == null) {
					ArrayList<String> tmp = new ArrayList<String>();
					tmp.add(word);
					wordMap.put(wordLength, tmp);
				} else {
					ArrayList<String> tmp = wordMap.get(wordLength);
					if (!tmp.contains(word))
						tmp.add(word);
					wordMap.put(wordLength, tmp);
				}
			}
		}
		int maxLength = Collections.max(wordMap.keySet());
		
		return "Length: " + maxLength + " - Words: " + wordMap.get(maxLength);
	}

}