package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Employee;
import com.example.demo.helper.ExelHelper;
import com.example.demo.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;

	public void save(MultipartFile file) {
		
		try {
			List<Employee> employee=ExelHelper.convertExcelToListOfEmployee(file.getInputStream());
			this.employeeRepo.saveAll(employee);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public List<Employee> getAllEmployee(){
		
		return this.employeeRepo.findAll();
	}
}
