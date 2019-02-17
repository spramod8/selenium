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

public class ReadXLCRP {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Startrd");
		XSSFRow row = null;
		XSSFCell cell = null;
		String upatedTable = null;
		String referenceTable = null;
		String newupatedTable = null;
		String previousCellVal = null;
		InputStream is = new FileInputStream("C:\\Users\\Pramod Sahoo\\Desktop\\readXL\\CRPdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(is);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator rows = sheet.rowIterator();
        String cellValue = null;
        //int rowcount = sheet.getPhysicalNumberOfRows();
        
        while(rows.hasNext()) {
        	//System.out.println("while loop count ");
        	row=(XSSFRow) rows.next();
        	cell = row.getCell(0);
        	cellValue = cell.getStringCellValue();
        	System.out.println(cellValue);
        	
        	if(upatedTable == null) {
        		upatedTable = cellValue;
        		//System.out.println("updated:::::::::"+upatedTable);
        	}
        	//if(upatedTable != null) {
        		if(cellValue.contains(upatedTable)) {
            		
            		previousCellVal = cellValue;
            		//System.out.println("in previous val if:::"+previousCellVal);
            		//referenceTable = 
            	}else {
            		
            		referenceTable = previousCellVal;
            		newupatedTable = cellValue;
            		//System.out.println("in previous val else::"+previousCellVal);
            	}
        	//}
        	
        	if(upatedTable != null && referenceTable != null) {
        		System.out.println("upatedTable is ::"+upatedTable);
            	System.out.println("referenceTable is ::"+referenceTable);
            	upatedTable = newupatedTable;
            	referenceTable = null;
            	previousCellVal = null;
        	}
        	
        	
        	
        }
	}

}
