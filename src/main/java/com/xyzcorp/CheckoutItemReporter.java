package com.xyzcorp;

import java.util.List;
import java.util.stream.Collectors;

public class CheckoutItemReporter {

	public List<CheckoutItem> getWorstOffenders(List<CheckoutItem> checkoutItems) {
		return checkoutItems
		.stream()
		.sorted((b,a) -> new Integer(a.getPenalty())
				         .compareTo(
				          new Integer(b.getPenalty())))
		.limit(3)
		.collect(Collectors.toList());
	}

}
