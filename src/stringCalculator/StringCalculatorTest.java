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

}
