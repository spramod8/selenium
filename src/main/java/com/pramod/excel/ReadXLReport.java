package com.pramod.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXLReport {

	public  int getMoodCount(String pillarID,String mood) {
		// TODO Auto-generated method stub
		int countMood = 0;
		try {
			
			InputStream is = new FileInputStream("C:\\Users\\Pramod Sahoo\\Desktop\\readXL\\MyXperiencePillarIdea.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(is);
	        XSSFSheet sheet = workbook.getSheetAt(0);
	     
	       
	        Iterator rows = sheet.rowIterator();
	        XSSFRow row;
	        while(rows.hasNext()) {
	        	
	        	//XSSFCell cell = workbook.getSheetAt(0).getRow(1).getCell(4);
	        	row=(XSSFRow) rows.next();
	        	XSSFCell cell1 =row.getCell(1);
	        	
	        	XSSFCell cell11 =row.getCell(11);
	        	String pillarIDXL = null;
	        	if(cell1 != null) {
	        		pillarIDXL = cell1.getRawValue();
		        	//System.out.println("pillarIDXL::"+pillarIDXL);
	        	}
	        	
	        	
	        	String moodXL = null;
	        	if(cell11 != null) {
	        		moodXL = cell11.getStringCellValue();
	        		//System.out.println("mood output xl::"+moodXL);
	        	}
	        	if(moodXL!= null) {
	        		if(pillarIDXL.equals(pillarID) && moodXL.equals(mood)) {
		        		
		        		countMood = countMood+1;
		        	}
	        	}
	        	
	        	
	        }
	        //System.out.println("Happy count:"+happyCount+"Neutral count:::"+neutralCount+"sad count ::"+sadCount);
	      	        
	  
		} 
		catch (FileNotFoundException e) 
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		catch (IOException e) 
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return countMood;

	}
	
	
	
	public  int getCentimentCount(String centiMent) {
		// TODO Auto-generated method stub
		int countCentiment = 0;
		try {
			
			InputStream is = new FileInputStream("C:\\Users\\Pramod Sahoo\\Desktop\\readXL\\MyXperiencePillarIdea.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(is);
	        XSSFSheet sheet = workbook.getSheetAt(0);
	     
	       
	        Iterator rows = sheet.rowIterator();
	        XSSFRow row;
	        while(rows.hasNext()) {
	        	
	        	//XSSFCell cell = workbook.getSheetAt(0).getRow(1).getCell(4);
	        	row=(XSSFRow) rows.next();
	        	//XSSFCell cell1 =row.getCell(1);
	        	
	        	XSSFCell cell12 =row.getCell(12);
	        	String pillarIDXL = null;
	        	/*if(cell1 != null) {
	        		pillarIDXL = cell1.getRawValue();
		        	//System.out.println("pillarIDXL::"+pillarIDXL);
	        	}*/
	        	
	        	
	        	String centimentXL = null;
	        	if(cell12 != null) {
	        		centimentXL = cell12.getStringCellValue();
	        		//System.out.println("mood output xl::"+moodXL);
	        	}
	        	if(centimentXL!= null) {
	        		
	        		if(centimentXL.equals(centiMent)) {
		        		
	        			countCentiment = countCentiment+1;
		        	}
	        	}
	        	
	        	
	        }
	        //System.out.println("Happy count:"+happyCount+"Neutral count:::"+neutralCount+"sad count ::"+sadCount);
	      	        
	  
		} 
		catch (FileNotFoundException e) 
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		catch (IOException e) 
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return countCentiment;

	}

}
