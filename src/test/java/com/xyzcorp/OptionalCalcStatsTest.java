package com.xyzcorp;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.mockito.Mockito;

public class OptionalCalcStatsTest {
   
	@Test
	public void testFindMinWithEmptyListUsingMock() {
		
		ICalcStats original = 
				 Mockito.mock(ICalcStats.class);
		
		Mockito.when(original.getMin()).thenReturn(null);
		
		OptionalCalcStats calcStats = 
				new OptionalCalcStats(original);
		assertEquals(Optional.empty(), calcStats.getMin()); 
	}
	

	@Test
	public void testFindMinWithNonEmptyListUsingMock() {
		
		ICalcStats original = 
				 Mockito.mock(ICalcStats.class);
		
		Mockito.when(original.getMin()).thenReturn(50);
		
		OptionalCalcStats calcStats = 
				new OptionalCalcStats(original);
		assertEquals(Optional.of(50), calcStats.getMin()); 
	}

	@Test
	public void testFindMinWithEmptyList() {
		//stub
		ICalcStats original = new ICalcStats() {
			@Override
			public Integer getMin() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		OptionalCalcStats calcStats = 
				new OptionalCalcStats(original);
		assertEquals(Optional.empty(), calcStats.getMin()); 
	}
	
	@Test
	public void testFindMinWithListOf4ElementsAndMinIs10() {
		//stub
		ICalcStats original = new ICalcStats() {
			@Override
			public Integer getMin() {
				// TODO Auto-generated method stub
				return 10;
			}
		};
		
		OptionalCalcStats calcStats = 
				new OptionalCalcStats(original);
		assertEquals(Optional.of(10), calcStats.getMin()); 
	}
	
	@Test
	public void testIntegrationTestWithNumbers() {
		List<Integer> list = new ArrayList<>();
		list.add(30);
		list.add(12);
		list.add(19);
		CalcStats original = new CalcStats(list);
		OptionalCalcStats ocs = new OptionalCalcStats(original);
		assertEquals(Optional.of(12), ocs.getMin());
	}
	
	
	
}
