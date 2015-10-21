package com.xyzcorp;

import java.util.Random;

public class Die {

	public static final String RANDOM_CANNOT_BE_NULL = 
			"Random cannot be null";
	private Random random;
    private int pips;
    
	public Die(Random random) {
	   this(random, 1);
	}

	private Die(Random random, int pips) {
	    if (random == null) 
	    	throw new IllegalArgumentException
	    	(RANDOM_CANNOT_BE_NULL);
		this.random = random;
		this.pips = pips;
	}

	public int getPips() {
		return pips;
	}

	public Die roll() {
		return new Die(random, random.nextInt(6) + 1);
	}
}
