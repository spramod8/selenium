package com.pramod.testNGSample;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;



public class TestNGExample {
	@AfterMethod
	public void tearDown(ITestResult result) {
	System.out.println("@AfterMethod: The annotated method will be run after each test method.");
	if(result.getStatus() == ITestResult.SUCCESS) {
		System.out.println("SUCCESS");
	}
	if(result.getStatus() == ITestResult.FAILURE) {
		System.out.println("FAIL");
	}
	
	}
	@Test(priority = 1)
	public void validateSum() {
	System.out.println("@Test : validateSum()");
	int a = 5;
	int b = 10;
	Assert.assertEquals(a + b, 16);
	}
	@Test(priority = 2)
	public void validateDifference() {
	System.out.println("@Test : validateDifference()");
	int a = 5;
	int b = 10;
	Assert.assertEquals(b - a, 5);
	}
}
