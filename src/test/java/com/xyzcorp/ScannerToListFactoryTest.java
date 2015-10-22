package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ScannerToListFactoryTest {

	@Test
	@Category(value=UnitTest.class)
	public void SimpleFactoryExample() {
		String data = "Foo\n" +
	                  "Bar\n" + 
				      "Baz\n";
	    Scanner scanner = new Scanner(data);             
        List<String> list = 
            ScannerToListFactory.getArrayList(scanner);
        assertThat(list).hasSize(3);
	}
	
	@Test
	@Category(value=IntegrationTest.class)
	public void SimpleFactoryExampleWithRealIntegrationTest() {
	    Scanner scanner = new Scanner
	       (getClass().getResourceAsStream("/library.txt"));             
        List<String> list = 
            ScannerToListFactory.getArrayList(scanner);
        assertThat(list).hasSize(10);
	}
	
}
