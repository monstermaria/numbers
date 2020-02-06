package numbersPackage;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculations {
	
	@GetMapping("/addition")
	public String addition(@RequestParam(required = false) List<String> numbers) {
		
		if (numbers != null) {
			
			CalculationResult result = new CalculationResult(numbers, "+");
			return result.info + " " + result.calculation;
		} else {
			return "No numbers given";
		}
	}

	@GetMapping("/multiplication")
	public String multiplication(@RequestParam List<String> numbers) {
		
		CalculationResult result = new CalculationResult(numbers, "*");
		return result.info + " " + result.calculation;
	}

	@GetMapping("/division")
	public String division(@RequestParam List<String> numbers) {
		
		CalculationResult result = new CalculationResult(numbers, "/");
		return result.info + " " + result.calculation;
	}
}
