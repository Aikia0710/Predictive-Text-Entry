package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * his class implements interface Dictionary. It makes use of Tree structure to
 * store the data When this class is used to run on signature "4663", the result
 * is as follows:
 * 
 * 4663: [inoe, inod, hood, inme, ioof, ione, imme, good, inne, hond, inof,
 * hooe, hone, gond, hoof, gooe, gnof, home, gone, goof, honf, gome, gonf]
 * 
 * @author zibo wang
 * @version 17.02.2019
 */
public class TreeDictionary implements Dictionary {

	private TreeDictionary[] subtrees;
	private Set<String> set;

	/**
	 * This constructor of the class takes in String path as an argument
	 * 
	 * @param path type String, the path to the file
	 */
	public TreeDictionary(String path) {
		this.subtrees = new TreeDictionary[8];
		this.set = new HashSet<>();
		try {
			Scanner sc = new Scanner(new File(path));
			while (sc.hasNextLine()) {
				String dwords = sc.nextLine().toLowerCase();
				if (PredictivePrototype.isValidWord(dwords))
					add(dwords);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This constructor takes no arguments and creates a new tree dictionary with
	 * all the field variables initiated. The subtrees would have 8 null elements
	 * and the set would have no elements in it.
	 */
	public TreeDictionary() {
		this.subtrees = new TreeDictionary[8];
		this.set = new HashSet<>();
	}

	/**
	 * This method takes a word of type String and stores it in all the subtrees
	 * that fit its prefix. If the subtree it visits is null, then it creates a new
	 * tree and stores the word there. If it is not null then it stores the word
	 * directly in the set.
	 * 
	 * @param word type String, the word that needs to be added to the tree
	 */
	public void add(String word) {
		TreeDictionary td = this;
		String signature = PredictivePrototype.wordToSignature(word);
		int sl = signature.length();
		for (int i = 0; i < sl; i++) {
			// to sort out which node the character should be stored in
			int node = signature.charAt(i) - '2';
			if (td.subtrees[node] == null) {
				td.subtrees[node] = new TreeDictionary();
				td.subtrees[node].set.add(word);
				td = td.subtrees[node];
			} else {
				td.subtrees[node].set.add(word);
				td = td.subtrees[node];
			}
		}

	}

	/**
	 * This method is used to trim words to a specific length of prefix.
	 * 
	 * @param set type Set<String></String>, the set that needs to be trimmed
	 * @param m   type Integer, the length of the trimmed words
	 * @return a set to be output
	 */
	public Set<String> trim(Set<String> set, int sl) {
		Set<String> newSet = new HashSet<>();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			newSet.add(it.next().substring(0, sl));
		}
		return newSet;
	}

	/**
	 * This method overrides itself in the dictionary interface, using the tree to
	 * look up the signature
	 * 
	 * @param signature type String, the signature that needs to be checked
	 * @return a set containing all the prefixes of required words
	 */
	@Override
	public Set<String> signatureToWords(String signature) {
		for (int i = 0; i < signature.length(); i++) {
			if (signature.charAt(i) < '2' || signature.charAt(i) > '9')
				throw new IllegalArgumentException();
		}

		try {
			TreeDictionary td = this;
			int sl = signature.length();
			for (int i = 0; i < sl; i++) {
				int node = signature.charAt(i) - '2';
				td = td.subtrees[node];
			}
			return trim(td.set, sl);
		} catch (NullPointerException e) {
			System.out.println("There's no such a word in the dictionary.");
			return new HashSet<>();
		} catch (ArrayIndexOutOfBoundsException f) {
			System.out.println("Invalid signature passed.");
			return new HashSet<>();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		TreeDictionary a = new TreeDictionary("words");
		System.out.println(a.signatureToWords("4663"));
	}

}
