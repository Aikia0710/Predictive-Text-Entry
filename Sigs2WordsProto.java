package predictive;

import java.io.FileNotFoundException;
/**
 * this method is used to call the wordToSignature method
 * @author zibo wang
 * @version 10.02.2019
 */
public class Sigs2WordsProto {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i] + ":" + PredictivePrototype.signatureToWords(args[i]));
			System.out.println("System: " + System.nanoTime() + " ns");
		}
	}

}  