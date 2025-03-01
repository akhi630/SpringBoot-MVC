package com.employee.springbootmvc.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.springbootmvc.Model.EmployeeModel;
import com.employee.springbootmvc.Service.EmployeeService;
import com.employee.springbootmvc.employeeEntity.EmployeeEntity;
import com.sathya.springbootmvc.model.Productmodel;


	@Controller
	public class Employeecontroller
	{
		@Autowired
		EmployeeService employeeService;
		
		@GetMapping("/searchform")
		public  String searchid()
		{
		 return "search";	
		}
		@PostMapping("/searchemployeebyid")
		public String searchEmployeebyid(@RequestParam Long id, Model model)
		{
			EmployeeEntity employee= employeeService.searchEmployeebyid(id);
			model.addAttribute("employee", employee);
			return "search";
		}
		
		
		@GetMapping("/delete/{id}")
		public String deletemployeeById(@PathVariable Long id)	
		{
			employeeService.deleteemployeebyid(id);
			return "redirect:/getallemployees";
		}
		
		
		
		
		
		@GetMapping("/getallemployees")
		public String getAllemployees(Model model)
		{
			List <EmployeeEntity> employees = employeeService.getAllEmployee();
			model.addAttribute("employees", employees);
			return "employeelist";
		}
		
		
		
		
		@GetMapping("/employeeform")
		public String employee()
		{
			return "employee";
		}
		
		
		@PostMapping("/saveemployee")
		public String postMethodName(EmployeeModel employeeModel)
		{
			employeeService.saveEmployeeDetails(employeeModel);
			return "success";
		}
		
		
		
		@GetMapping("/edit/{id}")
	     public String editEmployeeById(@PathVariable Long id,Model model)
	     {
	    	 EmployeeModel employee=employeeService.editEmployeeById(id);
	    	 model.addAttribute("employee", employee);
	    	 return "edit-employee-form";
	     }
		
		
		@PostMapping("/editemployeesave/{id")
		public String updateData(@PathVariable Long id, EmployeeModel employeeModel)
		{
			employeeService.updateData(id, employeeModel);
			return "redirect:/getallemployee";
		}
	}
		

