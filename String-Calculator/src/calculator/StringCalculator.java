package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringCalculator {

	static
	{
		count = 0;
	}
	static int count = 0;
	
	public int add(String input) throws Exception {
		++count;
		
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
			if(Integer.parseInt(numbers[i]) > 1000)
			{
				continue;
			}
			sum += Integer.parseInt(numbers[i]);
		}
		return sum;

	}

	//Method to support different delimiters
	private String[] getDelimiter(String input) throws Exception
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
	
	//Method to count how many times 
	public int getCalledCount()
	{
		return count;
	}

}
