package com.pramod.excel;

public class TestReadXLReport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadXLReport obj = new ReadXLReport();
		//int count = obj.getMoodCount("10","N");
		int count = obj.getCentimentCount("neutral");
		System.out.println("count is ::"+count);

	}

}
