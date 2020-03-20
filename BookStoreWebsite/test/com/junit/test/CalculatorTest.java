package com.junit.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator calc = new Calculator();
		int a  =500;
		int b = 1000;
		int result = calc.add(a, b);
		int expectedval = 1500;
		
		assertEquals(expectedval,result);
		
	}

}
