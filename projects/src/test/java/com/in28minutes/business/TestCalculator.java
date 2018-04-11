package com.in28minutes.business;
import static org.junit.Assert.assertEquals;

public class TestCalculator {
	Calculator obj = new Calculator();
	public void testAdd() {
		int actual = obj.add(3, 5);
		assertEquals(8,actual);
	}
}
