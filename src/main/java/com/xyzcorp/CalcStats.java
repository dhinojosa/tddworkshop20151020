package com.xyzcorp;

import java.util.Collections;
import java.util.List;

public class CalcStats implements ICalcStats {

	private List<Integer> numbers;
	
	public CalcStats(List<Integer> numbers) {
		if (numbers == null) 
			throw new IllegalArgumentException
			(NUMBERS_ARE_NULL);
	    this.numbers = numbers;
	}

	@Override
	public Integer getMin() {
		if (numbers.isEmpty()) return null;
		try {
	       return Collections.min(numbers);
		} catch (NullPointerException npe) {
		   throw new IllegalStateException
		      (ICalcStats.NO_ELEMENTS_CAN_BE_NULL);
		}
	}
}
