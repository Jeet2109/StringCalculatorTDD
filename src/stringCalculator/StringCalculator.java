package stringCalculator;

public class StringCalculator {

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

			String newDlmtr = numbers.substring(2, 3);
			String[] nums = numbers.substring(4).split(newDlmtr);
			try {
				sum = getSum(nums);
			} catch (NegativesNotAllowed e) {
				e.printStackTrace();
			}
		}

		// check for , and new line delimiter
		else if (numbers.contains(",")) {

			// split the input into individual numbers
			String[] numArray = numbers.split(",|\n");
			
			try {
				sum = getSum(numArray);
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
	
	
	/**
	 * This function calculates the sum of given numbers
	 * @param numbers - String array of numbers
	 * @return - sum of numbers
	 * @throws NegativesNotAllowed
	 */
	private int getSum(String[] numbers) throws NegativesNotAllowed {
		int sum = 0;
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
