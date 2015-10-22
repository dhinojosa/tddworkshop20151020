package com.xyzcorp;

import java.time.LocalDate;

public class CheckoutItem {

	private String name;
	private String title;
	private LocalDate checkoutDate;
	private int penalty;

	public CheckoutItem(String name, 
			            String title, 
			            LocalDate checkoutDate) {
		this.name = name;
		this.title = title;
		this.checkoutDate = checkoutDate;
	}

	public CheckoutItem(String name, String title, int penalty) {
		this.name = name;
		this.title = title;
		this.penalty = penalty;
	}

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public int getPenalty() {
		// TODO Auto-generated method stub
		return penalty;
	}

	public void setPenalty(int penalty) {
        this.penalty = penalty;		
	}
}
