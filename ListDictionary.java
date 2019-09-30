package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * this class using the list to store the contents from the dictionary, it
 * implements the dictionary class which is more efficient than the prototype.
 * it remains the signature to words method, it can find the possible words that
 * could correspond to a given signature and returns them a a set.
 * 
 * @author zibo wang
 * @version 12.02.2019
 */
public class ListDictionary implements Dictionary {

	/*
	 * create a new list to store the contents from the dictionary same as the
	 * previous, using the scanner to scan all of the words line by line, and
	 * recalling the isValidWords method to judge if the input thing is a proper
	 * word
	 */
	ArrayList<WordSig> all = new ArrayList<WordSig>();

	public ListDictionary(String path) throws FileNotFoundException {
		Scanner s = new Scanner(new File(path));
		while (s.hasNext()) {
			String Dwords = s.next();
			if (PredictivePrototype.isValidWord(Dwords)) {
				WordSig ws = new WordSig(Dwords.toLowerCase(), PredictivePrototype.wordToSignature(Dwords));
				all.add(ws);
			}
		}
		// sort the words into order and close the scanner
		s.close();
		Collections.sort(all);
	}

	/*
	 * create a new set to store the collected words
	 * @see predictive.Dictionary#signatureToWords(java.lang.String) 
	 */
	public Set<String> signatureToWords(String signature) {

		Set<String> set = new HashSet<String>();
		/*
		 * at here using the binary search method from the middle of the array list
		 * setting the word as null, and using the signature to match the words from the
		 * centre to the both sides. If the index less than the zero, return the set.
		 * Else, adding the words from the array into the set, than comparing the given
		 * signature with the word's signature, if they are same add the word into the
		 * new set and go for the next, if not, break the for loop, and go for the next
		 * index.
		 */
		int index = Collections.binarySearch(all, new WordSig(null, signature));
		
		if (index < 0) {
			return set;
		} else {
			set.add(all.get(index).getWords());
			for (int x = index + 1; x < all.size(); x++) {
				if (all.get(x).getSignature().equals(signature)) {
					set.add(all.get(x).getWords());
				} else {
					break;
				}
			}
			for (int y = index - 1; y < all.size(); y--) {
				if (all.get(y).getSignature().equals(signature)) {
					set.add(all.get(y).getWords());
				} else {
					break;
				}
			}
		}
		return set;
	}

	public static void main(String[] arg) throws FileNotFoundException {
		ListDictionary list = new ListDictionary("words");
		String a = "4663";
		System.out.println(list.signatureToWords(a));
	}
}
