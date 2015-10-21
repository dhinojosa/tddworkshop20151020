package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;

import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DieTest {

	private Random mock;

	@Before
	public void startUp() {
		mock = Mockito.mock(Random.class);
	}

	@Test
	@Category(value = UnitTest.class)
	public void testDefaultIs1() {
		Die die = new Die(mock);
		Assert.assertEquals(1, die.getPips());
	}

	@Test
	@Category(value = UnitTest.class)
	public void testBasicRollWith4() {
		// Stub
		@SuppressWarnings("serial")
		Random random = new Random() {
			@Override
			public int nextInt(int bound) {
				return 3;
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
		@SuppressWarnings("serial")
		Random random = new Random() {
			@Override
			public int nextInt(int bound) {
				return 3;
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
			assertThat(result).isLessThan(7).isGreaterThan(0);
		}
	}

	@Test
	@Category(value = UnitTest.class)
	public void testBUG3010() {
		when(mock.nextInt(6)).thenReturn(4);
		Die die = new Die(mock);
		assertThat(die.roll().getPips()).isGreaterThan(0).isLessThan(7);
	}

	@Test
	@Category(value = UnitTest.class)
	public void testBUG3010WithZero() {
		when(mock.nextInt(6)).thenReturn(0);
		Die die = new Die(mock);
		assertThat(die.roll().getPips()).isEqualTo(1);
	}

	@After
	public void cleanUp() {
		mock = null;
	}
}