package com.xyzcorp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FizzBuzzTest {
  
	@Test
	public void testFor1() {
		FizzBuzz fb = new FizzBuzz();
	    assertEquals("1", fb.process(1));	
	}
	
	@Test
	public void testFor3() {
		FizzBuzz fb = new FizzBuzz();
	    assertEquals("Fizz", fb.process(3));	
	}
	
	@Test
	public void testFor5() {
		FizzBuzz fb = new FizzBuzz();
	    assertEquals("Buzz", fb.process(5));	
	}
	
	@Test
	public void testFor15() {
		FizzBuzz fb = new FizzBuzz();
	    assertEquals("FizzBuzz", fb.process(15));	
	}
}
