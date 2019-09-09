Included junit tests can be ran by running 'mvn test' command.

There is an included main method that provides a way to input additional test scenarios if needed.

I've made the following assumptions:

words are case-insensitive: Jumped and jumped are the same word and will not be displayed twice when outputting the list of words that are the longest

Remove punctuation from beginning and end of sentence: Periods, Exclamation Marks, Question Marks etc. should not be included in a words length. i.e. 'moon.' is length four without the period.

Leave punctuation if it is found in the middle of the sentence: Assuming someone did not make a mistake, there are a few reasons punctuation would be in the middle of a sentence - email address' being one of them.

Ignore White-space: any kind of white-space, spaces/tabs/etc., are being ignored.
