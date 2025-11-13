// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    //System.out.println(plus(2,-3));   // 2 + 3
	    //System.out.println(minus(7,-2));  // 7 - 2
   		//System.out.println(minus(2,7));  // 2 - 7
 		//System.out.println(times(-3,-3));  // 3 * 4
   		//System.out.println(plus(2,times(4,-2)));  // 2 + 4 * 2
   		//System.out.println(pow(5,0));      // 5^3
   		//System.out.println(pow(3,0));      // 3^5
   		//System.out.println(div(12,-3));   // 12 / 3    
   		//System.out.println(div(5,5));    // 5 / 5  
   		//System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,-7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int amount = x1;
		for (int i = 0; i < Math.abs(x2); i++) {
			if (x2 >= 0)
			amount++;
			else
			amount--;
		}
		return amount;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int difference = x1;
		for (int i = Math.abs(x2); i > 0; i--){
			if (x2 >= 0)
			difference--;
			else
			difference++;
		}
		return difference;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int amount = 0;
		boolean negativeResult = x1 > 0 && x2 < 0 || x1 < 0 && x2 > 0;

		if (x1 < 0)	x1 = minus(0, x1);
		if (x2 < 0 ) x2 = minus(0, x2);

		for (int i = 0; i < x2; i++){
			amount = plus(amount, x1);
		}

		if (negativeResult)
			amount = minus(0, amount);
			
		return amount;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int amount = x;
		if (n == 0){
			amount = 1;
		} else {
		for (int i = 0; i < n - 1; i++){
			//amount = x;
			amount = times(amount,x);
			}
		}
		return amount;
	}

	// Returns the integer part of x1 / x2    12 / 3 = 4
	public static int div(int x1, int x2) {
		int portion = 0; 
		boolean negativeResult = (x1 >= 0 && x2 <= 0) || (x1 <= 0 && x2 >= 0);

		if (x1 < 0) x1 = minus(0, x1);
		if (x2 < 0) x2 = minus(0, x2);

		while (times(portion + 1, x2) <= x1) {
			portion++;
		}

		if (negativeResult){
			portion = minus(0, portion);
		} 		

		return portion;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		boolean negativeResult = x1 < 0 && x2 >=0 || x1 < 0 && x2 <0;

		if (x1 < 0) x1 = minus(0, x1);
		if (x2 < 0) x2 = minus(0, x2);

		int rest = x1;
		while (rest >= x2) {
			rest = minus(rest, x2);
		}
		if (negativeResult) {
			rest = minus(0, rest);
		}
		return rest;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int incremet = 1;
		int guess = 1;
		while (times(guess, guess) < x) {
			guess = plus(guess, incremet);
		}
		if (times(guess,guess) > x){
			guess = minus(guess, 1);
		}
		return guess;
	}	  	  
}