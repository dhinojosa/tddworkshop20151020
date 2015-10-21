package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LambdaDieTest {
	@Test
	@Category(value = UnitTest.class)
	public void testRollWithAFive() {
		LambdaDie die = new LambdaDie(() -> 5);
		assertThat(die.roll().getPips()).isEqualTo(5);
	}
	
	@Test
	@Category(value = IntegrationTest.class)
	public void testRollWithAnActualRandom() {
		Random random = new Random();
		LambdaDie die = new LambdaDie(() -> random.nextInt(6) + 1);
		assertThat(die.roll().getPips()).
		   isGreaterThan(0).isLessThan(7);
	}
}
