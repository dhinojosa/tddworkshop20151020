package com.xyzcorp;

public class FizzBuzz {
	public String process(int i) {
	    if (i % 3 == 0 && i % 5 == 0) {
	    	return "FizzBuzz";
	    } else if (i % 3 == 0) {
			return "Fizz";
		} else if (i % 5 == 0) {
		    return "Buzz";
		} else {
			return Integer.toString(i);
		}
	}
	
	public static void main(String[] args) {
		FizzBuzz fizzBuzz = new FizzBuzz();
		for (int i = 1; i < 101; i++) {
		   System.out.println(fizzBuzz.process(i));	
		}
	}
}
