package com.xyzcorp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerToListFactory {
	public static List<String> getArrayList(Scanner scanner) {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<String>();
		while(scanner.hasNextLine()) {
			result.add(scanner.nextLine());
		}
		return result;
	}
}
