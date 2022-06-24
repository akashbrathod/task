package com.example.demo.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Employee;

public class ExelHelper {

	
	public static boolean checkExcelformat(MultipartFile file) {
		
		String contentType=file.getContentType();
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		}
		else
		return false;	
	}
	
	public static List<Employee> convertExcelToListOfEmployee(InputStream is){
		List<Employee> list =new ArrayList<>();
		
		try {
			
			XSSFWorkbook workbook =new XSSFWorkbook(is);
			XSSFSheet sheet =workbook.getSheet("data");
			int rowNumber=0;
			Iterator<Row> iterator=sheet.iterator();
			while(iterator.hasNext()) {
				Row row=iterator.next();
				
				if(rowNumber==0) {
					rowNumber++;
					continue;
				}
				Iterator<Cell> cells=row.iterator();
				int cid=0;
				
				Employee employee=new Employee();
				
				while(cells.hasNext()) {
					Cell cell=cells.next();
					switch (cid) {
					case 0:
						employee.setEmpId((int)cell.getNumericCellValue());
						break;
						
					case 1:
						employee.setEmpName(cell.getStringCellValue());
						break;
						
					case 2:
						employee.setEmpSalary(cell.getNumericCellValue());
						break;
						
					default:
						break;
					}
					cid++;
				}
				
				list.add(employee);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
}
