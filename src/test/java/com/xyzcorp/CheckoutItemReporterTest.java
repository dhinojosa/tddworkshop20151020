package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CheckoutItemReporterTest {
	
	@Test
	@Category(value=UnitTest.class)
	public void testReturnResultsWith4Items() {
		
		List<CheckoutItem> checkoutItems = 
				new ArrayList<CheckoutItem>();
		checkoutItems.add(
				new CheckoutItem("Ted", "Book A", 10));
		checkoutItems.add(
				new CheckoutItem("Ann", "Book B", 40));
		checkoutItems.add(				
				new CheckoutItem("Bob", "Book C", 50));
		checkoutItems.add(				
				new CheckoutItem("Lisa", "Book D", 100));
		
		
		CheckoutItemReporter checkoutItemReporter = 
				new CheckoutItemReporter();
		
		List<CheckoutItem> result = 
				checkoutItemReporter
				.getWorstOffenders(checkoutItems);
	    assertThat(result).hasSize(3);
		assertThat(result.get(0).getName()).isEqualTo("Lisa");
		assertThat(result.get(1).getName()).isEqualTo("Bob");
		assertThat(result.get(2).getName()).isEqualTo("Ann");
	}
	
	@Test
	@Category(value=UnitTest.class)
	public void testReturnResultsWith1Item() {
		
		List<CheckoutItem> checkoutItems = 
				new ArrayList<CheckoutItem>();
		checkoutItems.add(
				new CheckoutItem("Ted", "Book A", 10));
		
		
		CheckoutItemReporter checkoutItemReporter = 
				new CheckoutItemReporter();
		
		List<CheckoutItem> result = 
				checkoutItemReporter
				.getWorstOffenders(checkoutItems);
	    assertThat(result).hasSize(1);
		assertThat(result.get(0).getName()).isEqualTo("Ted");
	}
	
	@Test
	@Category(value=UnitTest.class)
	public void testReturnResultsWith0Item() {
		
		List<CheckoutItem> checkoutItems = 
				new ArrayList<CheckoutItem>();
		
		CheckoutItemReporter checkoutItemReporter = 
				new CheckoutItemReporter();
		
		List<CheckoutItem> result = 
				checkoutItemReporter
				.getWorstOffenders(checkoutItems);
	    assertThat(result).hasSize(0);
	}
}
