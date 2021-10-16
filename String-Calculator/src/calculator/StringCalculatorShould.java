package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {
	StringCalculator stringCalculator = new StringCalculator();

	@Test
	void empty_string_should_return_0() {
		assertEquals(0, stringCalculator.add(""));
	}

	@Test
	void string_with_single_number_should_return_number_as_int() {
		assertEquals(1, stringCalculator.add("1"));
	}

	@Test
	void string_return_sum_of_two_numbers() {
		assertEquals(3, stringCalculator.add("1,2"));
	}

	@Test
	void string_return_sum_of_unknown_amount_of_numbers() {
		assertEquals(10, stringCalculator.add("1,2,3,4"));
	}
	
	@Test
	void string_return_sum_of_numbers_separated_by_spaceline() {
		assertEquals(6, stringCalculator.add("1,2\n3"));
	}
	
	@Test
	void string_support_different_delimiter() {
		assertEquals(6, stringCalculator.add("//;\n1;2;3"));
	}
	
	

}