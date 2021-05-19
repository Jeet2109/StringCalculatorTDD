package stringCalculator;

public class StringCalculator {
	
	/**
	 * This method adds the given numbers and returns the result. 
	 * If no number is passed, then it returns 0
	 * If 1 number is passed, then it returns that number
	 * If more than 1 numbers are passed, their sum is returned
	 * @param numbers - numbers in string format "," separated
	 * @return sum
	 */
	public int add(String numbers) {
		
		// split the input into individual numbers 
		String[] numArray = numbers.split(",");
		int sum = 0;
		
		// check for blank string i.e. no numbers passed
		if(numbers.isEmpty())
			return 0;
		
		// check if only one or multiple numbers are passed
		if(numArray.length==1) {
			return convertToInteger(numbers);
		} else {
			for(String str : numArray) {
				sum += convertToInteger(str);
			}
			return sum;
		}
		
	}
	
	
	/**
	 * This function converts string to integer
	 * @param number
	 * @return
	 */
	private int convertToInteger(String number) {
		return Integer.parseInt(number);
	}

}
