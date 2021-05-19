package stringCalculator;

import java.util.HashSet;
import java.util.Set;

public class StringCalculator {

	Set<Character> characters;
	
	StringCalculator(){
		this.characters = new HashSet<>();
		this.characters.add('(');
        this.characters.add(')');
        this.characters.add('[');
        this.characters.add(']');
        this.characters.add('{');
        this.characters.add('}');
		this.characters.add('+');
		this.characters.add('.');
        this.characters.add('*');
        this.characters.add('?');
        this.characters.add('^');
        this.characters.add('$');
        this.characters.add('\\');
	}
	
	
	/**
	 * This method adds the given numbers and returns the result. 
	 * If no number is passed, then it returns 0 
	 * If 1 number is passed, then it returns that number
	 * If more than 1 numbers are passed, their sum is returned
	 * 
	 * @param numbers - numbers in string format "," separated
	 * @return sum
	 */
	public int add(String numbers) {

		int sum = 0;

		// check for blank string i.e. no numbers passed
		if (numbers.isEmpty()) {
		}

		// check for custom delimiter
		else if (numbers.startsWith("//")) {

			String delimiter = "";
			if(numbers.contains("[")) {
				delimiter = getDelimiters(numbers);
				numbers = numbers.substring(numbers.lastIndexOf("]")+2);
			} else {
				delimiter = numbers.substring(2,3);
				numbers = numbers.substring(4);
			}
			
			try {
				sum = getSum(numbers,delimiter);
			} catch (NegativesNotAllowed e) {
				e.printStackTrace();
			}
		}

		// check for , and new line delimiter
		else if (numbers.contains(",")) {
			String delimiter = ",|\n";
			try {
				sum = getSum(numbers,delimiter);
			} catch (NegativesNotAllowed e) {
				e.printStackTrace();
			}
		}

		else {

			sum = convertToInteger(numbers);
		}

		return sum;

	}

	/**
	 * This function converts string to integer
	 * 
	 * @param number
	 * @return - integer
	 */
	private int convertToInteger(String number) {
		return Integer.parseInt(number);
	}
	
	private String getDelimiters(String numbers) {
		StringBuilder sb = new StringBuilder();
		String[] delimiters = numbers.substring(3,numbers.lastIndexOf("]")).split("\\]\\[");
		if(delimiters.length>0) {
			for(String s : delimiters) {
				sb.append(s+"|");
			}
			sb.delete(sb.length()-1,sb.length());
		}
		
		String tempDelimiter = sb.toString();
		StringBuilder finalDelimiters = new StringBuilder();
		for(char c : tempDelimiter.toCharArray()) {
			if(this.characters.contains(c)) {
				finalDelimiters.append("\\"+c);
			} else {
				finalDelimiters.append(""+c);
			}
		}
		
		return finalDelimiters.toString();
	}
	
	
	/**
	 * This function calculates the sum of given numbers
	 * @param numbers - String array of numbers
	 * @return - sum of numbers
	 * @throws NegativesNotAllowed
	 */
	private int getSum(String input, String delimiter) throws NegativesNotAllowed {
		int sum = 0;
		String[] numbers = input.split(delimiter);
		StringBuilder exceptionMsg = new StringBuilder();
		
		for(String str : numbers) {
			int number = convertToInteger(str);
			if(number<0) {
				exceptionMsg.append(String.valueOf(number)+" ");
			}
			
			if(number>1000) {
				continue;
			}
			sum+=number;
		}
		
		if(exceptionMsg.length()>0) {
			throw new NegativesNotAllowed(exceptionMsg.toString());
		}
		return sum;
	}

}
