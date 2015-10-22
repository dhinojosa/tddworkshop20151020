package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PenaltyCalculatorTest {

	@Test
	@Category(value = UnitTest.class)
	public void calculatePenaltyForLessOneMonth() {
		PenaltyCalculator penaltyCalculator = 
				new PenaltyCalculator(10);
		assertThat(penaltyCalculator.calculate(
		   LocalDate.of(2015, 10, 4), 
		   LocalDate.of(2015, 10, 10))).isZero();
	}
	
	@Test
	@Category(value = UnitTest.class)
	public void calculatePenaltyForOneDayOverTheMonth() {
		PenaltyCalculator penaltyCalculator = 
				new PenaltyCalculator(10);
		assertThat(penaltyCalculator.calculate(
		   LocalDate.of(2015, 10, 4), 
		   LocalDate.of(2015, 11, 5))).isEqualTo(10);
	}
	
	@Test
	@Category(value = UnitTest.class)
	public void calculatePenaltyForThreeMonthsOver() {
		PenaltyCalculator penaltyCalculator = 
				new PenaltyCalculator(10);
		assertThat(penaltyCalculator.calculate(
		   LocalDate.of(2015, 10, 4), 
		   LocalDate.of(2016, 1, 20))).isEqualTo(30);
    }
	
	
	@Test
	@Category(value = UnitTest.class)
	public void calculatePenaltyForExactlyTwoMonthsOver() {
		PenaltyCalculator penaltyCalculator = 
				new PenaltyCalculator(10);
		assertThat(penaltyCalculator.calculate(
		   LocalDate.of(2015, 10, 4), 
		   LocalDate.of(2015, 12, 4))).isEqualTo(10);
    }

	@Test
	@Category(value = UnitTest.class)
	public void testFebruaryMadness(){
		PenaltyCalculator penaltyCalculator = 
				new PenaltyCalculator(10);
		assertThat(penaltyCalculator.calculate(
		   LocalDate.of(2015, 1, 31), 
		   LocalDate.of(2015, 3, 2))).isEqualTo(10);
	}
	
	@Test
	@Category(value = UnitTest.class)
	public void testCheckoutAndTodaysAreNotSwapped(){
		PenaltyCalculator penaltyCalculator = 
				new PenaltyCalculator(10);
		try {
		penaltyCalculator.calculate(
		   LocalDate.of(2015, 3, 2), 
		   LocalDate.of(2015, 1, 13));
		   fail("Should not be here");
		} catch (IllegalStateException ise) {
			assertThat(ise).
			hasMessage("Cannot go back in time");
		}
	}
	
	@Test
	@Category(value = UnitTest.class)
	public void testCheckoutWithBackInVoidOneDay(){
		PenaltyCalculator penaltyCalculator = 
				new PenaltyCalculator(10);
		try {
		penaltyCalculator.calculate(
		   LocalDate.of(2015, 3, 2), 
		   LocalDate.of(2015, 3, 1));
		   fail("Should not be here");
		} catch (IllegalStateException ise) {
			assertThat(ise).
			hasMessage("Cannot go back in time");
		}
	}
	
	@Test
	@Category(value = UnitTest.class)
	public void testCheckoutWithTodaysDateAsNull(){
		PenaltyCalculator penaltyCalculator = 
				new PenaltyCalculator(10);
		try {
		penaltyCalculator.calculate(
		   LocalDate.of(2015, 3, 2),
		   null);
		   fail("Should not be here");
		} catch (IllegalArgumentException ise) {
			assertThat(ise).
			hasMessage("Today's date is null");
		}
	}
	
	@Test
	@Category(value = UnitTest.class)
	public void testCheckoutWithCheckoutDateAsNull(){
		PenaltyCalculator penaltyCalculator = 
				new PenaltyCalculator(10);
		try {
		penaltyCalculator.calculate(
		   null, 
		   LocalDate.of(2015, 3, 1));
		   fail("Should not be here");
		} catch (IllegalArgumentException ise) {
			assertThat(ise).
			hasMessage("Checkout date is null");
		}
	}
}
