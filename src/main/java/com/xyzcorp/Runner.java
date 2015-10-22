package com.xyzcorp;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
        InputStream is = 
          Runner.class.getResourceAsStream("/library.txt");
	    Scanner scanner = new Scanner(is);
	    List<String> strings = 
	    		ScannerToListFactory.getArrayList(scanner);
	    LibraryParser parser = new LibraryParser("~");
	    List<CheckoutItem> checkoutItems = 
	    		parser.parse(strings);
	    System.out.println(checkoutItems.get(0).getName());
	    
	    PenaltyCalculator calc = new PenaltyCalculator(10);
	    PenaltyProcessor processor = new PenaltyProcessor(calc);
	    
	    List<CheckoutItem> result = new ArrayList<CheckoutItem>();
	    for (CheckoutItem item: checkoutItems) {
	        result.add(processor.updateCheckoutItem(LocalDate.now(), item));	
	    }
	    
	    CheckoutItemReporter reporter = new CheckoutItemReporter();
	    
	    for (CheckoutItem item : reporter.getWorstOffenders(result)) {
	    	System.out.println(item.getName() + ", " + item.getPenalty()); 
	    }	
	}
}
