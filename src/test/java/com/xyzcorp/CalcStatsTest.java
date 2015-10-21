package com.xyzcorp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CalcStatsTest {

	@Test
	public void testFindMinWithEmptyList() {
		List<Integer> numbers = new ArrayList<>();
		ICalcStats calcStats = new CalcStats(numbers);
		assertEquals(null, calcStats.getMin()); 
	}
	
	@Test
	public void testFindMinWithListOfOne() {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(5);
		ICalcStats calcStats = new CalcStats(numbers);
		assertEquals(new Integer(5), calcStats.getMin()); 
	}
	
	@Test
	public void testFindMinWithListOfTwo() {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(20);
		numbers.add(2);
		ICalcStats calcStats = new CalcStats(numbers);
		assertEquals(new Integer(2), calcStats.getMin()); 
	}
	
	@Test
	public void testFindMinWithListOfThreeWithOneNull() {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(20);
		numbers.add(null);
		numbers.add(2);
		ICalcStats calcStats = new CalcStats(numbers);
		try {
		   calcStats.getMin();
		} catch (IllegalStateException iae) {
		   assertEquals(ICalcStats.NO_ELEMENTS_CAN_BE_NULL, 
				   iae.getMessage());	
		}
	}
	
	@Test
	public void testFindMinWithListOfTwoWithOneNegative() {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(20);
		numbers.add(-50);
		ICalcStats calcStats = new CalcStats(numbers);
		assertEquals(new Integer(-50), calcStats.getMin()); 
	}

	@Test
	public void testFindMinWithListOfTen() {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(20);
		numbers.add(2);
		numbers.add(30);
		numbers.add(100);
		numbers.add(120);
		numbers.add(53);
		numbers.add(39);
		numbers.add(111);
		numbers.add(1);
		numbers.add(47);
		ICalcStats calcStats = new CalcStats(numbers);
		assertEquals(new Integer(1), calcStats.getMin());
	}
	
	@Test
	public void testItDoesNotAcceptNull() {
		try {
		   new CalcStats(null);
		   fail("Exception Expected");
		} catch (IllegalArgumentException iae) {
	       assertEquals(ICalcStats.NUMBERS_ARE_NULL, 
	    		        iae.getMessage());			
		}
	}
	
	@Test
	public void testFindMinWithListOfTwoThatAreTheSame() {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(20);
		numbers.add(20);
		ICalcStats calcStats = new CalcStats(numbers);
		assertEquals(new Integer(20), calcStats.getMin()); 
	}
}
