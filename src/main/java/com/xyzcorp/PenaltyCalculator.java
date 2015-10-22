package com.xyzcorp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class PenaltyCalculator {

	private int ratePerMonth;

	public PenaltyCalculator(int ratePerMonth) {
        this.ratePerMonth = ratePerMonth;
	}

	public int calculate(LocalDate checkoutDate, 
			             LocalDate todaysDate) {
        if (todaysDate == null) 
        	throw new IllegalArgumentException
        	      ("Today's date is null");
		
        if (checkoutDate == null) 
        	throw new IllegalArgumentException
        	      ("Checkout date is null");
        
		if (todaysDate.isBefore(checkoutDate)) throw new 
			IllegalStateException("Cannot go back in time");
		
		return (int)ChronoUnit.MONTHS.between
				(checkoutDate, todaysDate.minusDays(1)) 
				    * ratePerMonth;
	}
}
