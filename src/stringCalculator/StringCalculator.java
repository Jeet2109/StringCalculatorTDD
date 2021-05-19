package stringCalculator;

public class StringCalculator {

	/**
	 * This method adds the given numbers and returns the result. If no number is
	 * passed, then it returns 0 If 1 number is passed, then it returns that number
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
			for (String str : nums) {
				sum += convertToInteger(str);
			}
		}

		// check for , and new line delimiter
		else if (numbers.contains(",")) {

			// split the input into individual numbers
			String[] numArray = numbers.split(",|\n");

			for (String str : numArray) {
				sum += convertToInteger(str);
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
	 * @return
	 */
	private int convertToInteger(String number) {
		return Integer.parseInt(number);
	}

}
