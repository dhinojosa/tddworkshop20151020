package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Test;

public class PenaltyProcessorTest {

   @Test
   public void testProcessPenaltyForOne() {
	   CheckoutItem item = 
			   new CheckoutItem("Steve", 
					   "Book A", LocalDate.of(2010, 12, 1));
	   
	   PenaltyCalculator calculator = mock(PenaltyCalculator.class);
       
	   LocalDate todayDate = LocalDate.of(2010, 12, 31);
	   
	   when(calculator
    		   .calculate(LocalDate.of(2010, 12, 1), 
    				      LocalDate.of(2010, 12, 31)))
    		   .thenReturn(100);
       
	   PenaltyProcessor processor = 
			   new PenaltyProcessor(calculator);
	   
	   CheckoutItem newItem = 
			   processor.updateCheckoutItem(todayDate, item);
	   
       assertThat(newItem.getPenalty()).isEqualTo(100);
   }
}
