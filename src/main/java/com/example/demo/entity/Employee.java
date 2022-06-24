package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
		@Id
		private int empId;
		private String empName;
		private double empSalary;
		public int getEmpId() {
			return empId;
		}
		public void setEmpId(int empId) {
			this.empId = empId;
		}
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}
		public double getEmpSalary() {
			return empSalary;
		}
		public void setEmpSalary(double empSalary) {
			this.empSalary = empSalary;
		}
		public Employee(int empId, String empName, double empSalary) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.empSalary = empSalary;
		}
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}
		

}
