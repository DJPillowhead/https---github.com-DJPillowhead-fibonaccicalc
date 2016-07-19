package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// this is the actual part doing the calculations

@RestController
public class FibonacciCalc {

	@RequestMapping(path = "/fibonacci2", method = RequestMethod.GET) // this sets the calculator page name
	public int fibonacciLoop( @RequestParam("fibonacci_input") int number){ 
		if(number < 1 || number > 56){
			throw new RuntimeException("The number is not between 1 and 55.");
		}
		else {
		if(number == 1 || number == 2){
            return 1;
            // returning 1 as the 1st and 2nd numbers are 1
        }
        int fibo1=1, fibo2=1, fibonacci=1;
        for(int i= 3; i<= number; i++){
            fibonacci = fibo1 + fibo2; //Fibonacci number is sum of previous two Fibonacci numbers
            fibo1 = fibo2;
            fibo2 = fibonacci;
 
        }
        return fibonacci; //Fibonacci number
		}
    }   
    
    
}
