package com.xyzcorp;

import java.util.Optional;

public class OptionalCalcStats {

	private ICalcStats original;

	public OptionalCalcStats(ICalcStats original) {
	   this.original = original;
	}

	public Optional<Integer> getMin() {
		return Optional.ofNullable(original.getMin());
	}

}
