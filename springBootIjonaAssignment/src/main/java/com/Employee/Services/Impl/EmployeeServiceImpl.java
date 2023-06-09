package com.Employee.Services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.Entity.Employee;
import com.Employee.Exception.ResourceNotFoundException;
import com.Employee.Payloads.EmployeeDto;
import com.Employee.Repositories.EmployeeRepository;
import com.Employee.Services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	 
	
	// we use ModelMapper here because , without ModelMapper we need to to manually write code to copy each field from EmployeeDto to Employee or vice versa.
	//ModelMapper simplifies the process of mapping data between objects with different structures.
	
	@Override
	public EmployeeDto AddEmployee(EmployeeDto employeeDto) {
		
		Employee emp = modelMapper.map(employeeDto, Employee.class);
		Employee savedEmp = this.employeeRepository.save(emp);
		return modelMapper.map(savedEmp, EmployeeDto.class);
	}

	@Override
	public EmployeeDto UpdateEmployee(EmployeeDto employeeDto, Integer empId) {
		
		Employee emp = this.employeeRepository.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",empId));
		emp.setName(employeeDto.getName());
		emp.setEmail(employeeDto.getEmail());
		emp.setDepartment(employeeDto.getDepartment());
		
		Employee updatedEmp = this.employeeRepository.save(emp);
		EmployeeDto empDto = this.employeeToDto(updatedEmp);
		
		return empDto;
	}

	@Override
	public EmployeeDto getEmployeeById(Integer empId) {
		
		Employee emp = this.employeeRepository.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", empId));
		
		return this.employeeToDto(emp);
		
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		
		List<Employee> emps = this.employeeRepository.findAll();
		List<EmployeeDto> empDtos = emps.stream().map(emp -> this.employeeToDto(emp)).collect(Collectors.toList());
		
		return empDtos;
	}

	@Override
	public void deleteEmployee(Integer empId) {
		
		Employee emp = this.employeeRepository.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", empId));
		
		this.employeeRepository.delete(emp);
		
	}
	
	//to convert EmployeeDto to employee because here type of method is employee
	
	public Employee dtoToEmployee(EmployeeDto employeeDto) {
		
		Employee employee = new Employee();
		
		employee.setId(employeeDto.getId());
		employee.setName(employeeDto.getName());
		employee.setEmail(employeeDto.getEmail());
		return employee;
	}
	
	//to convert Employee to employeeDto because here type of method is employeeDto
	
	public EmployeeDto employeeToDto(Employee employee) {
		
		EmployeeDto empdto = new EmployeeDto();
		
		empdto.setId(employee.getId());
		empdto.setName(employee.getName());
		empdto.setEmail(employee.getEmail());
		empdto.setDepartment(employee.getDepartment());
		return empdto;
	}

}
