package com.xyzcorp;

import java.time.LocalDate;

public class PenaltyProcessor {

	private PenaltyCalculator calculator;

	public PenaltyProcessor(PenaltyCalculator calculator) {
		this.calculator = calculator;
	}

	public CheckoutItem updateCheckoutItem(LocalDate todaysDate, CheckoutItem item) {
		int penalty = calculator.calculate
				(item.getCheckoutDate(), todaysDate);
		item.setPenalty(penalty);
		return item;
	}

}
