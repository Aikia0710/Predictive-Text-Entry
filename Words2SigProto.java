package predictive;
/**
 * this method is used to call the signatureToWord method
 * @author zibo wang
 * @version 10.02.2019
 */
public class Words2SigProto {
	
	public static void main (String[] args) {
		
		for (int i = 0; i < args.length; i++) {
			System.out.println(PredictivePrototype.wordToSignature(args[i]));
		
		}
	}

}
 