package predictive;

import java.io.FileNotFoundException;
import java.util.Iterator;
/**
 * this method is used to call the sigsToWord method
 * @author zibo
 * @version 16.02.2018
 */
public class Sigs2WordsMap {

	public static void main(String[] args) throws FileNotFoundException {

		MapDictionary map = new MapDictionary("words");
		for (String a : args) {
			Iterator<String> it = map.signatureToWords(a).iterator();
			System.out.print(a + " ");
			while (it.hasNext()) {
				String dwords = it.next();
				System.out.print(dwords + " ");
			}
			System.out.println("\n");
		}
	}
}
