package com.xyzcorp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryParser {

	private String regexDelimeter;

	public LibraryParser(String regexDelimeter) {
		if (regexDelimeter == null) 
			throw new 
			IllegalArgumentException("Delimeter is null");
		
		this.regexDelimeter = regexDelimeter;
	}

	public CheckoutItem parse(String line) {
		if (line == null || "".equals(line)) 
			throw new 
			IllegalArgumentException("Malformed Line");
		String[] items = line.split(regexDelimeter);
		if (items.length < 3)
			throw new
			IllegalArgumentException("Too few items parsed");
		return new CheckoutItem(items[0], items[1], 
				LocalDate.parse(items[2]));
	}

	public List<CheckoutItem> parse(List<String> items) {
		List<CheckoutItem> result = 
				new ArrayList<CheckoutItem>();
		for (String item: items) {
			try {
			result.add(parse(item));
			} catch (IllegalArgumentException iae) {
				//log it
			}
		}
	    return result;
	}
}
