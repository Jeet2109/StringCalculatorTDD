package stringCalculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {
	private StringCalculator calculator;

	@Before
	public void setup() {
		calculator = new StringCalculator();
	}

	@Test
	public void emptyStringInput() {
		assertEquals(0, calculator.add(""));
	}
	
	@Test
	public void singleNumberInput() {
		assertEquals(1, calculator.add("1"));
	}
	
	@Test
	public void twoNumbersInput() {
		assertEquals(3, calculator.add("1,2"));
	}
	
	@Test
	public void multipleInput() {
		assertEquals(9,calculator.add("1,3,5"));
	}
	
	@Test
	public void newLineDelimiter() {
		assertEquals(9,calculator.add("1\n3,5"));
	}
	
	@Test
	public void newCustomDelimiter() {
		assertEquals(6,calculator.add("//;\n1;2;3"));
	}
	
	@Test
	public void negativeInput() {
		assertEquals(0,calculator.add("-1,-2,3"));
	}
	
	@Test
	public void numberGreaterThan1000() {
		assertEquals(6,calculator.add("1,2,3,1001"));
	}
	
	@Test
	public void delimiterOfAnyLength() {
		assertEquals(6,calculator.add("//[***]\n1***2***3"));
	}
	
	@Test
	public void multipleDelimiter() {
		assertEquals(6,calculator.add("//[*][%]\n1*2%3"));
	}
	
	@Test
	public void multipleDelimitermultipleLength() {
		assertEquals(6,calculator.add("//[%][***]\n1***2%3"));
	}
}
