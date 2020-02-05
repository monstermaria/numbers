package numbersPackage;

import java.util.ArrayList;
import java.util.List;

public class CalculationResult {
	
	List<String> numbers;
	ArrayList<String> notNumbers = new ArrayList<String>();
	String info = "";
	String calculation = "";
	String operand = "";
	Double result = 0.0;
	boolean resultValid = true;
	String reasonForFailure = "";
	
	public CalculationResult(List<String> numbers, String operand) {
		
		this.numbers = numbers;
		this.operand = operand;
		calculate();
	}
	
	void calculate() {
		
		Double number;
		int i = 0;
		
		info = "Input: " + numbers;
		
		while (i < numbers.size()) {
			
			number = parseNumber(i);
			
			if (number != null) {
				handleNumber(number, i);
				i++;
			}
			
		}

		info += " Actual numbers: " + numbers + " Non numbers: " + notNumbers;
		
		if (resultValid) {
			calculation = String.join(" " + operand + " ", numbers);
			calculation += " = " + result;
		} else {
			calculation = "Unable to get a result: " + reasonForFailure;
		}
	}
	
	Double parseNumber(int i) {
		
		try {
			return Double.parseDouble(numbers.get(i));
		} catch (Exception e) {
			// remove the non number from "numbers", and put it in the "notNumbers" list
			notNumbers.add(numbers.remove(i));
			return null;
		}
	}
	
	void handleNumber(Double number, int i) {
		
		if (i == 0) {
			result = number;
		} else {
			switch (operand) {
			case "+":
				result += number;
				break;
			case "*":
				result *= number;
				break;
			case "/":
				if (number != 0) {
					result /= number;
				} else {
					System.out.println("Division by zero");
					resultValid = false;
					reasonForFailure = "Division by zero";
				}
				break;
			default:
				System.out.println("Operand not handled: " + operand);
				resultValid = false;
				reasonForFailure = "Operand not handled: " + operand;
			}
		}
		
	}
}
