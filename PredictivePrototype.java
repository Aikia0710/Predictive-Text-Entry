package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * this class contains two methods, one is change the input word into the number
 * and the other method is change the input signatures into words, to prove if
 * the input words are valid words, could write another helper method to judge
 * the situation
 * 
 * @author zibo wang
 * @version 10.02.2019
 * 
 */
public class PredictivePrototype {

	/*
	 * the number length range of the lower case alphabet a to z is from 97 - 122
	 * each of the alphabet occupies 1 number a - c. 97 - 99 d - f. 100 - 102 g - i.
	 * 103 - 105
	 */
	public static String wordToSignature(String word) {

		/*
		 * using the char array to store each character(alphabet) of the word into an
		 * array
		 */
		char[] words = word.toLowerCase().toCharArray();
		/*
		 * using the StringBuffer to add the new content to the end of the existed
		 * object
		 */
		StringBuffer s = new StringBuffer();

		/*
		 * traversal the character of the word to judge if each of them is alphabet if
		 * yes, the char of each code is between a fixed range, then append the specific
		 * String of each character together
		 */
		for (int i = 0; i < word.length(); i++) {
			if (words[i] >= 97 && words[i] <= 99) {
				s.append("2");
			} else if (words[i] >= 100 && words[i] <= 102) {
				s.append("3");
			} else if (words[i] >= 103 && words[i] <= 105) {
				s.append("4");
			} else if (words[i] >= 106 && words[i] <= 108) {
				s.append("5");
			} else if (words[i] >= 109 && words[i] <= 111) {
				s.append("6");
			} else if (words[i] >= 112 && words[i] <= 115) {
				s.append("7");
			} else if (words[i] >= 116 && words[i] <= 118) {
				s.append("8");
			} else if (words[i] >= 119 && words[i] <= 122) {
				s.append("9");
			} else {
				s.append(" ");
			}
		}
		/*
		 * return the s into a String
		 */
		return s.toString();

	}

	/*
	 * this is a helper method to judge if the input String type object is a valid
	 * word
	 */
	public static boolean isValidWord(String word) {

		char[] words = word.toLowerCase().toCharArray();
		for (int i = 0; i < words.length; i++) {
			if (words[i] < 97 || words[i] > 122) {
				return false;
			}
		}
		return true;
	}

	public static Set<String> signatureToWords(String signature) {
		Set<String> all = new HashSet<String>();

		try {
			Scanner s = new Scanner(new File("words"));
			/*
			 * using a while loop at there, the ending condition is there are no more word
			 * left at the dictionary
			 */
			while (s.hasNext()) {
				String Dwords = s.next();
				/*
				 * if the input word is a valid word and it's signature equals to the results of
				 * recalling the wordToSignature method
				 */
				if (isValidWord(Dwords) && signature.equals(wordToSignature(Dwords))) {
					all.add(Dwords.toLowerCase()); // adding the input into the HashSet
				}
			}
			/*
			 * close the scanner and return the new HashSet containing all dictionary words
			 */
			s.close();
			return all;
		}
		// if the file not found, throw the exception
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return new HashSet<>();
		}
	}

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		System.out.println(wordToSignature("Hello"));
		System.out.println(signatureToWords("3456"));
		long end = System.currentTimeMillis();
		System.out.println("cost time: " + (end - start));
	}

}
