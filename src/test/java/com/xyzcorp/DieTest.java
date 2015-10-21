package com.xyzcorp;

import static org.junit.Assert.*;
import org.mockito.Mockito;

import java.util.Random;

import org.junit.Assert;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DieTest {

	@Test
	@Category(value = UnitTest.class)
	public void testDefaultIs1() {
		Random mock = Mockito.mock(Random.class);
		Die die = new Die(mock);
		Assert.assertEquals(1, die.getPips());
	}

	@Test
	@Category(value = UnitTest.class)
	public void testBasicRollWith4() {
		// Stub
		Random random = new Random() {
			@Override
			public int nextInt() {
				return 4;
			}
		};
		Die die = new Die(random);
		Die rolledDie = die.roll();
		assertEquals(4, rolledDie.getPips());
	}

	@Test
	@Category(value = UnitTest.class)
	public void testBasicRollWith4MultipleTimes() {
		// Stub
		Random random = new Random() {
			@Override
			public int nextInt() {
				return 4;
			}
		};
		Die die = new Die(random);
		Die roll2 = die.roll();
		Die roll3 = roll2.roll();
		Die roll4 = roll3.roll();
		assertEquals(4, roll4.getPips());
	}

	@Test
	@Category(value = UnitTest.class)
	public void testRandomCannotBeNull() {
		Random random = null;
		try {
			new Die(random);
			fail("Should not be here");
		} catch (IllegalArgumentException iae) {
			assertEquals(Die.RANDOM_CANNOT_BE_NULL, iae.getMessage());
		}
	}

	@Test
	@Category(value = IntegrationTest.class)
	public void testWithRealRandom() {
		Die die = new Die(new Random());
		for (int i = 0; i < 100000; i++) {
			int result = die.roll().getPips();
			assertTrue(result > 0);
			assertTrue(result < 7);
		}
	}
}
