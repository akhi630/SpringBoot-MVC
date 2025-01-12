package com.employee.springbootmvc.employeeEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private int age;
	private String department;
	private String location;
	private double salary;
	private String gender;
	
	private double monthsalary;
	private double basicsalary;
	private double allowance;
	private double bonus;
	private double medicalinsurance;
}
