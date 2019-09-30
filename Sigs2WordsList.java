package predictive;

import java.io.FileNotFoundException;
import java.util.Iterator;
/**
 * this method is used to call the sigsToWord method
 * @author zibo wang
 * @version 12.02.2019
 */
public class Sigs2WordsList {
	
	public static void main (String[] args) throws FileNotFoundException {
		
		ListDictionary ld = new ListDictionary("words");
		for(String a : args) {
			Iterator<String> it = ld.signatureToWords(a).iterator();
			System.out.print(a + " ");
			while (it.hasNext()) {
				String dwords = it.next();
				System.out.print(dwords + " ");
			}
			System.out.println("\n");
		}
	}

}
 