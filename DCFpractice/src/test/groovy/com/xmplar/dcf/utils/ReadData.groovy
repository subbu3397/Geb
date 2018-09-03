package com.xmplar.dcf.utils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.DataFormatter
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.apache.poi.ss.usermodel.DateUtil;
public class Read {
	
	
	public static JSONArray readXLSXFile() throws IOException
	{
		JSONArray main=new JSONArray();
		InputStream ExcelFileToRead = new FileInputStream("C:/Users/Arun/Documents/DCFTestcases.xlsx");
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		//XSSFCell cell;

		List<XSSFRow> list=sheet.getRows(2, sheet.size(), false);
		DataFormatter fmt = new DataFormatter();
		Iterator rows = list.iterator();
		
		while (rows.hasNext())
			{
				row=(XSSFRow) rows.next();
				
				JSONArray array=new JSONArray();
				JSONObject users=new JSONObject();
				JSONObject search=new JSONObject();
				users.put("UserName",fmt.formatCellValue(row.getCell(0)));
				users.put("Password",fmt.formatCellValue(row.getCell(1)));
				array.add(users)
				
				search.put("Category",fmt.formatCellValue(row.getCell(2)));
				search.put("Type",fmt.formatCellValue(row.getCell(3)));
				search.put("Status",fmt.formatCellValue(row.getCell(4)));
				search.put("Legalregion",fmt.formatCellValue(row.getCell(5)));
				search.put("Attorney",fmt.formatCellValue(row.getCell(6)));
				search.put("Assignmenttype",fmt.formatCellValue(row.getCell(7)));
				
			
				array.add(search)
				main.add(array);
			}
			return main;
}
		public static void main(String[] args) throws IOException {
			readXLSXFile();
		}
	
}
