package com.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * Assumptions: Case Insensitive, remove punctuation from beginning and end of a word but not from middle, ignore whitespace
 */

public class FindLongestWord {

	private static final String PUNCTUATION_REGEX = "(^(\\p{Punct}+)|(\\p{Punct}+)$)";
	private static final String WHITESPACE_REGEX = "^((?=[\\W_]).)*$";
	private static final String EMPTY_SENTENCE_ERROR = "Please enter a non-empty sentence.";
	private static final String NO_CHARACTER_ERROR = "Please enter a sentence with at least one word";
	
	static Logger log = LogManager.getLogger(FindLongestWord.class);

	public static void main(String[] args) {
		
		System.out.println(getLongest("The cow jumped over abcdef the moon.!"));

	}
	
	static String getLongest(String sentence) {
		
		//If sentence is null, empty, or only white-space return error statement
		if (sentence == null || sentence.isBlank()) {
			log.debug("Sentence: Null or Empty - Error Msg: {}", EMPTY_SENTENCE_ERROR);
			return EMPTY_SENTENCE_ERROR;
		}
		
		// Create patterns to assist removing punctuation at the beginning or end of a word
		Pattern punctuationPattern = Pattern.compile(PUNCTUATION_REGEX);
		Pattern noCharacterPattern = Pattern.compile(WHITESPACE_REGEX);
		Matcher matcher = noCharacterPattern.matcher(sentence);
		
		//If Sentence does not contain any alphanumeric characters return error statement
		if (matcher.find()) {
			log.debug("Sentence: {} - Error Msg: {}", sentence, NO_CHARACTER_ERROR);
			return NO_CHARACTER_ERROR;
		}
			
		HashMap<Integer, List<String>> wordMap = new HashMap<>();
		
		for (String word : sentence.split("\\s+")) {
			matcher = punctuationPattern.matcher(word);
			if (matcher.find()) {
				log.trace("Word before punctuation removal: {}", word);
				word = matcher.replaceAll("");
				log.trace("Word after  punctuation removal: {}", word);
			}
			
			wordMap.put(word.length(), addWordToList(wordMap.get(word.length()), word.toLowerCase()));
		}
		int maxLength = Collections.max(wordMap.keySet());
		
		return "Length: " + maxLength + " - Words: " + wordMap.get(maxLength);
	}

	private static List<String> addWordToList(List<String> wordList, String wordToAdd) {

		if(wordList == null)
			wordList = new ArrayList<>();
		
		if(!wordList.contains(wordToAdd))
			wordList.add(wordToAdd);
		
		return wordList;
	}
	
}