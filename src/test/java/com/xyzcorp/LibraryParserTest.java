package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LibraryParserTest {

	@Test
	@Category(value = UnitTest.class)
	public void testParseLineToObject() {
		LibraryParser parser = new LibraryParser("~");
		String testData = "James Lillyhammer~Cujo~2010-12-19";
		CheckoutItem checkoutItem = parser.parse(testData);
		assertThat(checkoutItem.getName()).isEqualTo("James Lillyhammer");
		assertThat(checkoutItem.getTitle()).isEqualTo("Cujo");
		assertThat(checkoutItem.getCheckoutDate()).isEqualTo(LocalDate.of(2010, 12, 19));
	}

	@Test
	@Category(value = UnitTest.class)
	public void testParseLineToObjectWithAsteriskDelimiter() {
		LibraryParser parser = new LibraryParser("\\*");
		String testData = "Carl Gonzalez*Pet Semetary*2014-12-19";
		CheckoutItem checkoutItem = parser.parse(testData);
		assertThat(checkoutItem.getName()).isEqualTo("Carl Gonzalez");
		assertThat(checkoutItem.getTitle()).isEqualTo("Pet Semetary");
		assertThat(checkoutItem.getCheckoutDate()).isEqualTo(LocalDate.of(2014, 12, 19));
	}

	@Test
	@Category(value = UnitTest.class)
	public void testParseLineToObjectWithBadDate() {
		LibraryParser parser = new LibraryParser("\\*");
		String testData = "Carl Gonzalez*Pet Semetary*2014-124-19";
		try {
			parser.parse(testData);
			fail("Should not be here");
		} catch (DateTimeParseException dtpe) {
			assertTrue(true);
		}
	}

	@Test
	@Category(value = UnitTest.class)
	public void testParseLineToObjectWithBlankLine() {
		LibraryParser parser = new LibraryParser("\\*");
		String testData = "";
		try {
			parser.parse(testData);
			fail("Should not be here");
		} catch (IllegalArgumentException iae) {
			assertThat(iae).hasMessage("Malformed Line");
		}
	}

	@Test
	@Category(value = UnitTest.class)
	public void testParseLineToObjectWithParseItemsLessThan3() {
		LibraryParser parser = new LibraryParser("!");
		String testData = "Carl Gonzalez!Pet Semetary";
		try {
			parser.parse(testData);
			fail("Should not be here");
		} catch (IllegalArgumentException iae) {
			assertThat(iae).hasMessage("Too few items parsed");
		}
	}

	@Test
	@Category(value = UnitTest.class)
	public void testParseLineWithNullLine() {
		LibraryParser parser = new LibraryParser("!");
		String testData = null;
		try {
			parser.parse(testData);
			fail("Should not be here");
		} catch (IllegalArgumentException iae) {
			assertThat(iae).hasMessage("Malformed Line");
		}
	}

	@Test
	@Category(value = UnitTest.class)
	public void testConstructionWithNullDelimeter() {
		try {
			new LibraryParser(null);
			fail("Should not be here");
		} catch (IllegalArgumentException iae) {
			assertThat(iae).hasMessage("Delimeter is null");
		}
	}

	@Test
	@Category(value = UnitTest.class)
	public void testParseThreeItems() {
		List<String> items = new ArrayList<String>();
        items.add("Dave~Book A~2015-10-01");
        items.add("John~Book B~2015-09-13");
        items.add("Ann~Book C~2015-08-05");
        LibraryParser libraryParser = new LibraryParser("~");
		List<CheckoutItem> checkoutItems = 
				libraryParser.parse(items);
		assertThat(checkoutItems).hasSize(3);
		assertThat(checkoutItems.get(0)
				.getName()).isEqualTo("Dave");
		assertThat(checkoutItems.get(1)
				.getTitle()).isEqualTo("Book B");
		assertThat(checkoutItems.get(2)
				.getCheckoutDate())
		        .isEqualTo(LocalDate.of(2015, 8, 5));
	}
	
	@Test
	@Category(value = UnitTest.class)
	public void testParseThreeItemsWithOneItemBlank() {
		List<String> items = new ArrayList<String>();
        items.add("Dave~Book A~2015-10-01");
        items.add("");
        items.add("Ann~Book C~2015-08-05");
        LibraryParser libraryParser = new LibraryParser("~");
		List<CheckoutItem> checkoutItems = 
				libraryParser.parse(items);
		assertThat(checkoutItems).hasSize(2);
		assertThat(checkoutItems.get(0)
				.getName()).isEqualTo("Dave");
		assertThat(checkoutItems.get(1)
				.getTitle()).isEqualTo("Book C");
		assertThat(checkoutItems.get(1)
				.getCheckoutDate())
		        .isEqualTo(LocalDate.of(2015, 8, 5));
	}
}
