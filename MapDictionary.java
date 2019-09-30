package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * this class using the map to store the contents from the dictionary, which is
 * a data structure that maps each signature to set of words. The class still
 * implements the dictionary class which is more efficient than the prototype.
 * it remains the signature to words method, it can find the possible words that
 * could correspond to a given signature and returns them a a set.
 * 
 * @author zibo wang
 * @version 16.02.2019
 *  
 */
public class MapDictionary implements Dictionary {

	// HashSet<String> set = new HashSet<String>();
	/*
	 * using the HashMap at here to store the signature, and the couple corresponded
	 * words in String types, which were stored in a HashSet
	 */
	Map<String, HashSet<String>> map = new HashMap<>();

	public MapDictionary(String path) throws FileNotFoundException {

		Scanner s = new Scanner(new File("words"));

		/*
		 * using a while loop at here, the finish condition is when there are no more
		 * word has been scanned from the dictionary
		 */
		while (s.hasNext()) {
			/*
			 * get the scanned word from dictionary, than recall the isValidWord method to
			 * see if the scanned word is a valid word
			 */
			String Dwords = s.next();
			if (PredictivePrototype.isValidWord(Dwords)) {
				/*
				 * to judge if the map already contained the word's signature, if not,go to the
				 * else condition
				 */
				if (map.containsKey(PredictivePrototype.wordToSignature(Dwords))) {
					/*
					 * if the map contains the word's signature, get it, and add the word into the
					 * HashSet
					 */
					map.get(PredictivePrototype.wordToSignature(Dwords)).add(Dwords.toLowerCase());
				} else {
					/*
					 * new a HashSet to contains the words with same signature in a same set
					 */
					HashSet<String> set = new HashSet<String>();
					/*
					 * if the map doesn't contain the key signature, just add the words into the
					 * HashSet with lower case and add the set and the signature together into the
					 * HashMap.
					 */
					set.add(Dwords.toLowerCase());
					map.put(PredictivePrototype.wordToSignature(Dwords), set);
				}
			}
		}
		s.close();
	}

	@Override
	public Set<String> signatureToWords(String signature) {
		return map.get(signature);
	}

	public static void main(String[] args) throws FileNotFoundException {
		MapDictionary map = new MapDictionary("words");
		String a = "4663";
		System.out.println(map.signatureToWords(a));
	}

}
