package com.main;

import static org.junit.Assert.assertEquals;
import static com.main.FindLongestWord.getLongest;

import org.junit.Test;

public class TestLongestWord {

	@Test
	public void providedTest() {
		assertEquals(getLongest("The cow jumped over the moon."), "Length: 6 - Words: [jumped]");
	}
	
	@Test
	public void emptyTest() {
		assertEquals(getLongest(""), "Please enter a non-empty sentence.");
	}
	
	@Test
	public void nullTest() {
		assertEquals(getLongest(null), "Please enter a non-empty sentence.");
	}
	
	@Test
	public void tabTest() {
		assertEquals(getLongest("	 	"), "Please enter a non-empty sentence.");
	}
	
	@Test
	public void tabAndLetterTest() {
		assertEquals(getLongest("	 a"), "Length: 1 - Words: [a]");
	}
	
	@Test
	public void lineBreakTest() {
		assertEquals(getLongest("\r\n"), "Please enter a non-empty sentence.");
	}
	
	@Test
	public void lineBreakWithWordsTest() {
		assertEquals(getLongest("This is \r\n a test"), "Length: 4 - Words: [this, test]");
	}
	
	@Test
	public void lineBreakWithWordsAndTabTest() {
		assertEquals(getLongest("This 	 is \r\n	a test"), "Length: 4 - Words: [this, test]");
	}
	
	@Test
	public void multipleLineBreakTypesTest() {
		assertEquals(getLongest("This\ris\na\r\ntest"), "Length: 4 - Words: [this, test]");
	}
	
	@Test
	public void caseInsensitiveTest() {
		assertEquals(getLongest("Jumped JUMPED jumped"), "Length: 6 - Words: [jumped]");
	}
	
	@Test
	public void oneWordTest() {
		assertEquals(getLongest("This"), "Length: 4 - Words: [this]");
	}
	
	@Test
	public void oneLetterTest() {
		assertEquals(getLongest("T"), "Length: 1 - Words: [t]");
	}
	
	@Test
	public void oneWordPunctuationTest() {
		assertEquals(getLongest("It's"), "Length: 4 - Words: [it's]");
	}
	
	@Test
	public void beginningWordPunctuationTest() {
		assertEquals(getLongest("!This"), "Length: 4 - Words: [this]");
	}
	
	@Test
	public void punctuationInMiddleTest() { 
		assertEquals(getLongest("Th!s"), "Length: 4 - Words: [th!s]");
	}
	
	@Test
	public void emailAddressTest() {
		assertEquals(getLongest("This.Address@gmail.com"), "Length: 22 - Words: [this.address@gmail.com]");
	}
	
	@Test
	public void sentenceWithMultiplePunctuationEndTest() {
		assertEquals(getLongest("The quick brown fox jumped over the lazy dog!!!..!"), "Length: 6 - Words: [jumped]");
	}
	
	@Test
	public void noSpacesTest() {
		assertEquals(getLongest("This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:test:This:is:a:tests:"), "Length: 1200 - Words: [this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:test:this:is:a:tests]");
	}
	
	@Test
	public void specialCharTest() {
	assertEquals(getLongest("!)$*&#%)*(&!$"), "Please enter a sentence with at least one word");
	}
	
	@Test
	public void singleNumberTest() {
		assertEquals(getLongest("1"), "Length: 1 - Words: [1]");
	}
	
	@Test
	public void numberTest() {
		assertEquals(getLongest("1 2 3 4 5"), "Length: 1 - Words: [1, 2, 3, 4, 5]");
	}
	
	@Test
	public void singleUnderscoreTest() {
		assertEquals(getLongest("_"), "Please enter a sentence with at least one word");
	}
	
	@Test
	public void numbersAndWordsTest() {
		assertEquals(getLongest("One two 5 100"), "Length: 3 - Words: [one, two, 100]");
	}
	
	@Test
	public void multipleUnderscoreTest() {
		assertEquals(getLongest("This_is a te_st."), "Length: 7 - Words: [this_is]");
	}
}
