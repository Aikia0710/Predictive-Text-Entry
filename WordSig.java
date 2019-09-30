package predictive;

/**
 * this class is used to pair the word and signature, it has two variables which
 * are the words and signatures, both with the String type
 * 
 * @author zibo wang
 * @version 12.02.2019
 */
public class WordSig implements Comparable<WordSig> {

	private String words;
	private String signature;

	/**
	 * @param words
	 * @param signature
	 */
	public WordSig(String words, String signature) {
		super();
		this.words = words;
		this.signature = signature;
	}

	/**
	 * @return the new value of the word
	 */
	public String getWords() {
		return words;
	}

	/**
	 * set a new value for the variable
	 * @param words
	 */
	public void setWords(String words) {
		this.words = words;
	}

	/**
	 * @return the new value of the signature
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * set the new value for the object
	 * @param signature
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Override
	public int compareTo(WordSig ws) {
		// TODO Auto-generated method stub
		return this.getSignature().compareTo(ws.getSignature());
	}

}
