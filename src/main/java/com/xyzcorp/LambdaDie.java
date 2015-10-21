package com.xyzcorp;

import java.util.OptionalDouble;
import java.util.function.Supplier;

public class LambdaDie {

	private Supplier<Integer> supplier;
	private Integer pip;

	public LambdaDie(Supplier<Integer> supplier) {
		this.supplier = supplier;
	}

	public LambdaDie(Supplier<Integer> supplier, 
			Integer pip) {
        this.supplier = supplier;
        this.pip = pip;
	}

	public LambdaDie roll() {
		// TODO Auto-generated method stub
		return new LambdaDie(supplier, supplier.get());
	}

	public int getPips() {
		// TODO Auto-generated method stub
		return pip;
	}
}
