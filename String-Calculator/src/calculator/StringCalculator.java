package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringCalculator {

	public int add(String input) throws Exception {

		String[] numbers = input.split(",|\n");
		if(input.isEmpty()) {
			return 0;
		}

		else if(input.length() == 1){
			if(Integer.parseInt(input) < 0)
			{
				throw new Exception("negatve not allowed");
			}
			else
			{
				return Integer.parseInt(input);
			}

		}
		else if(input.startsWith("//"))
		{
			String[] del =  getDelimiter(input);
			return getSum(del);
		}

		else {
			return getSum(numbers);
		}

	}

	//Method to handle an unknown amount of numbers
	private int getSum(String[] numbers) throws Exception
	{
		int sum = 0;
		for(int i = 0; i < numbers.length; i++)
		{
			sum += Integer.parseInt(numbers[i]);
		}
		return sum;

	}

	//Method to support different delimiters
	private static String[] getDelimiter(String input) throws Exception
	{
		Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
		if(matcher.matches())
		{
			String delimiter = matcher.group(1);
			String toSplit = matcher.group(2);
			return toSplit.split(delimiter);
		}
		throw new RuntimeException("Wrong custom delimiter format");
	}

}
