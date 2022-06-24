package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Employee;
import com.example.demo.helper.ExelHelper;
import com.example.demo.service.EmployeeService;

@RestController
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	private EmployeeService eService;
	
	@PostMapping("/employee/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
		if(ExelHelper.checkExcelformat(file)) {
			this.eService.save(file);
			
			return ResponseEntity.ok(Map.of("massage", "file is uploaded and data is save to db"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload excel data");
	}
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getAll(){
		return this.eService.getAllEmployee();
	}
}
