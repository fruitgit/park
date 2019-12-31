package com.biyeseng.util;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFFooter;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.biyeseng.db.DBManager;

public class ExportExcelUtil {
	
	private static Connection conn ;  
	   
	
	
	
	public static final String[] tableHeader = 
		{"搴忓彿","杞︾墝鍙�","鍋滆溅鏃堕棿","绂诲紑鏃堕棿","閲戦","鏃堕暱","鏀惰垂鏍囧噯"};
	
	public static HSSFWorkbook demoWorkBook = new HSSFWorkbook();
	
	public static HSSFSheet demoSheet = demoWorkBook.createSheet("Sheet1");
	
	public static final short cellNumber = (short)tableHeader.length;

	public static final int columNumber = tableHeader.length;
	
	public static Connection getConn(){  
		 
			 
			DBManager dbm=new DBManager();
			conn = dbm.getConnection();
		 
		return conn;
	 }
	
	
	 public ResultSet selectAllDataFromDB(String sql) throws SQLException{
		conn = getConn();
		Statement stmt = conn.createStatement();  
		ResultSet rs = stmt.executeQuery(sql); 
		return rs;
	 }
	
	public void createTableHeader(){
	//	HSSFHeader header = demoSheet.getHeader();
	//	header.setCenter("澶у尯淇℃伅琛�");
		HSSFRow headerRow = demoSheet.createRow((short) 0);
		for(int i = 0;i < cellNumber;i++){
			HSSFCell headerCell = headerRow.createCell((short) i);
			headerCell.setEncoding(HSSFCell.ENCODING_UTF_16);
			headerCell.setCellValue(tableHeader[i]);
			headerCell.setCellStyle(getTitleStyle());
		}
	}
	

	public void createTableRow(List<String> cells,short rowIndex){
		
		HSSFRow row = demoSheet.createRow((short) rowIndex);
		row.setHeight((short) (15.625*20));
		HSSFCellStyle style = getCellStyle();
		for(short i = 0;i < cells.size();i++)
		{
			
			HSSFCell cell = row.createCell((short) i);
			cell.setCellStyle(style);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	        cell.setCellValue(cells.get(i));
		}
	}
	
	
	public void createExcelSheeet(String sql) throws SQLException{
		createTableHeader();
		
		ResultSet rs = selectAllDataFromDB(sql);
		int rowIndex = 1;
		while(rs.next()){
			List<String> list = new ArrayList<String>();
			for(int i = 1;i <= columNumber;i++)
			{
				list.add(rs.getString(i));
			}
			createTableRow(list,(short)rowIndex);
			rowIndex++;
		}
	}
	

	public void expord(OutputStream os) throws IOException{
		demoSheet.setGridsPrinted(true);
        HSSFFooter footer = demoSheet.getFooter();
        footer.setRight("Page " + HSSFFooter.page() + " of " +
        HSSFFooter.numPages());
        demoWorkBook.write(os);
	}
	
	
	public HSSFCellStyle getTitleStyle(){
		HSSFCellStyle style = demoWorkBook.createCellStyle();  
	    HSSFFont font = demoWorkBook.createFont();
	    
	    demoSheet.setColumnWidth((short)7, (short) 7000);
		demoSheet.setColumnWidth((short)8, (short) 7000);
		demoSheet.setColumnWidth((short)11, (short) 5000);
		demoSheet.setColumnWidth((short)12, (short) 5000);
	    
	    font.setFontName("Arial");  
	    font.setFontHeightInPoints((short) 10);  
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        style.setFillForegroundColor(HSSFColor.LAVENDER.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
        style.setWrapText(true);  
        style.setFont(font);  
        return style;  
	}
	
	public HSSFCellStyle getCellStyle(){
		HSSFCellStyle style = demoWorkBook.createCellStyle();  
        HSSFFont font = demoWorkBook.createFont();  
        font.setFontHeightInPoints((short) 10);
        style.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN); 
        style.setFont(font);  
        return style;  
	}
	
	

	
	
}

