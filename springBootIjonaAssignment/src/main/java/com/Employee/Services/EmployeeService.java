package com.Employee.Services;

import java.util.List;

import com.Employee.Payloads.EmployeeDto;

public interface EmployeeService {

	EmployeeDto AddEmployee(EmployeeDto employeeDto);
	
	EmployeeDto UpdateEmployee(EmployeeDto employee, Integer empId);
	
	EmployeeDto getEmployeeById(Integer empId);
	
	List<EmployeeDto> getAllEmployee();
	
	void deleteEmployee(Integer empId);
}
