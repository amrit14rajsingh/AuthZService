package com.teksystem.filereader.core;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class XlsFileReader extends AbstractFileReader{
	public void readFileContent(FileInputStream fis) throws Exception{
		//Create Workbook instance holding reference to .xls file
				HSSFWorkbook workbook = new HSSFWorkbook(fis);
				//Get first/desired sheet from the workbook or we can provide sheet name too.
				HSSFSheet sheet = workbook.getSheetAt(0);
				//Iterate through each rows one by one
				@SuppressWarnings(value = { "unchecked" })
				Iterator<Row> rowIterator = sheet.rowIterator();
				while (rowIterator.hasNext()) {
					Row row = (Row)rowIterator.next();
					//For each row, iterate through all the columns
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()){
						Cell cell = cellIterator.next();
						//Check the cell type and format accordingly
						CellType cellType = cell.getCellTypeEnum();
						switch (cellType) {
						case NUMERIC:
							System.out.print(cell.getNumericCellValue() + "t");
							break;
						case STRING:
							System.out.print(cell.getStringCellValue() + "t");
							break;
						}
					}
					System.out.println("");
				}
				fis.close();
	 }
}
