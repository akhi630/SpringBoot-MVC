package com.employee.springbootmvc.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.springbootmvc.Model.EmployeeModel;
import com.employee.springbootmvc.employeeEntity.EmployeeEntity;
import com.employee.springbootmvc.employeeRepositry.EmployeeRepository;




@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
		
	public EmployeeEntity searchEmployeebyid(Long id)
	{
		Optional <EmployeeEntity> optionalData = employeeRepository.findById(id);
		if(optionalData.isPresent())
		{
			EmployeeEntity employee= optionalData.get();
			return employee;
	     }
		else
		{
			return null;
		}
		
	}
	
	

	
	public void deleteemployeebyid(Long id)
	{
		employeeRepository.deleteById(id);
	}
	public List<EmployeeEntity> getAllEmployee()
	{
		List<EmployeeEntity> employees= employeeRepository.findAll();
		return employees;
	}
	
	
	
	
public void saveEmployeeDetails(EmployeeModel employeeModel)
{
	double allowance;
	double bonus;
	double medicalinsurence;
	double basicsalary;
	double monthlysalary;
	
	if(employeeModel.getSalary()<=350000)
	{
		bonus=20000;
		allowance=1000;
		medicalinsurence=40000;
		basicsalary=employeeModel.getSalary()-bonus-allowance-medicalinsurence;
	}
	else
	{
		bonus=100000;
		allowance=7000;
		medicalinsurence=700000;
		basicsalary=employeeModel.getSalary()-bonus-allowance-medicalinsurence;
	}
	monthlysalary=(int)employeeModel.getSalary()/12;
	EmployeeEntity employeeEntity=new EmployeeEntity();
	employeeEntity.setName(employeeModel.getName());
	employeeEntity.setAge(employeeModel.getAge());
	employeeEntity.setDepartment(employeeModel.getDepartment());
	employeeEntity.setSalary(employeeModel.getSalary());
	employeeEntity.setLocation(employeeModel.getLocation());
	employeeEntity.setGender(employeeModel.getGender());
	employeeEntity.setMonthsalary(monthlysalary);
	employeeEntity.setBasicsalary(basicsalary);
	employeeEntity.setAllowance(allowance);
	employeeEntity.setBonus(bonus);
	employeeEntity.setMedicalinsurance(medicalinsurence);
	employeeRepository.save(employeeEntity);
	
	}


public EmployeeModel editEmployeeById(Long id)
{
	Optional<EmployeeEntity> optionaldata = employeeRepository.findById(id);
	EmployeeModel employee=new EmployeeModel();
	if(optionaldata.isPresent())
	{
		EmployeeEntity eemployee=optionaldata.get();
		employee.setName(eemployee.getName());
		employee.setAge(eemployee.getAge());
		employee.setDepartment(eemployee.getDepartment());
		employee.setSalary(eemployee.getSalary());
		employee.setLocation(eemployee.getLocation());
		employee.setGender(eemployee.getGender());
			
		return employee;
		
	}
	else
	{
		return null;
	}		
}




}
