package predictive;

import java.io.FileNotFoundException;
import java.util.Iterator;
/**
 * this method is used to call the wordToSignature method
 * @author zibo wang
 * @version 17.02.2019
 */
public class Sigs2WordsTree {

	public static void main(String[] args) throws FileNotFoundException {

		TreeDictionary td = new TreeDictionary("words");
		long time = System.nanoTime();
		for(String a : args) {
			Iterator<String> it = td.signatureToWords(a).iterator();
			System.out.print(a + " ");
			while (it.hasNext()) {
				String dwords = it.next();
				System.out.print(dwords + " ");
			}
			System.out.println("\n");
		}
		System.out.println("System: " + (System.nanoTime() - time)+ " ns");
	}

}
   