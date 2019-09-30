package predictive;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class Worksheet3Test {
	Set<String> expected1 = new HashSet<>();
	Set<String> expected2 = new HashSet<>();
	Set<String> expected3 = new HashSet<>();
	Set<String> expected4 = new HashSet<>();
	// Preparing expected output results.
	@Before
	public void setUp() throws Exception {
		expected1.add("hood");
		expected1.add("ione");
		expected1.add("ioof");
		expected1.add("good");
		expected1.add("hond");
		expected1.add("inne");
		expected1.add("gond");
		expected1.add("hone");
		expected1.add("hoof");
		expected1.add("gone");
		expected1.add("goof");
		expected1.add("home");
		expected1.add("gome");
		expected2.add("hello");
		expected2.add("gekko");
		expected3.add("inoe");
		expected3.add("inod");
		expected3.add("hood");
		expected3.add("inme");
		expected3.add("ione");
		expected3.add("ioof");
		expected3.add("good");
		expected3.add("hond");
		expected3.add("hooe");
		expected3.add("imme");
		expected3.add("inne");
		expected3.add("inof");
		expected3.add("gnof");
		expected3.add("gond");
		expected3.add("gooe");
		expected3.add("hone");
		expected3.add("hoof");
		expected3.add("gone");
		expected3.add("goof");
		expected3.add("home");
		expected3.add("honf");
		expected3.add("gome");
		expected3.add("gonf");
		expected4.add("gellm");
		expected4.add("helln");
		expected4.add("hellm");
		expected4.add("gekko");
		expected4.add("hello");
	}
	// Test class PredictiveProtype's methods
	@Test 
	public void Test1() throws Exception {
		assertEquals(PredictivePrototype.wordToSignature("hello"), "43556");
		assertEquals(PredictivePrototype.wordToSignature("hello World HELLO java"), "43556 96753 43556 5282");
		assertEquals(PredictivePrototype.wordToSignature("a"), "2");
		assertEquals(PredictivePrototype.wordToSignature("?(*#"), "    ");
		assertEquals(PredictivePrototype.signatureToWords("4663"), expected1);
		assertEquals(PredictivePrototype.signatureToWords("43556"), expected2);
	}
	
	// Test class ListDictionary's methods.
	@Test
	public void Test2() throws Exception {
		ListDictionary ld = new ListDictionary("words");
		assertEquals(ld.signatureToWords("4663"), expected1);
		assertEquals(ld.signatureToWords("43556"), expected2);
	}
	// Test class MapDictionary's methods
	@Test
	public void Test3() throws Exception {
		MapDictionary map = new MapDictionary("words");
		assertEquals(map.signatureToWords("4663"), expected1);
		assertEquals(map.signatureToWords("43556"), expected2);
	}
	// Test class TreeDictionary's methods
	@Test
	public void Test4() throws Exception {
		TreeDictionary tree = new TreeDictionary("words");
		assertEquals(tree.signatureToWords("4663"), expected3);
		assertEquals(tree.signatureToWords("43556"), expected4);
	}
}
