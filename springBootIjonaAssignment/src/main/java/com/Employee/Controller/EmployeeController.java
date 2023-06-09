package com.Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Payloads.ApiResponse;
import com.Employee.Payloads.EmployeeDto;
import com.Employee.Services.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	//Add new Employee
	
	@PostMapping("/")
	public ResponseEntity<EmployeeDto> AddEmployee(@Valid @RequestBody EmployeeDto employeedto){
		
		EmployeeDto newEmp = this.employeeService.AddEmployee(employeedto);
		return new ResponseEntity<>(newEmp, HttpStatus.CREATED);
		
	}
	
	//update details of employee
	
	@PutMapping("/{empId}")
		public ResponseEntity<EmployeeDto> UpdateEmployee(@Valid @RequestBody EmployeeDto employeeDto, @PathVariable Integer empId ){

		EmployeeDto updateEmp = this.employeeService.UpdateEmployee(employeeDto, empId);
		return ResponseEntity.ok(updateEmp);
	}
    
    
        //get employee by id
    
        @GetMapping("/{empId}")
                 public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Integer empId){
    	
    	         return ResponseEntity.ok(this.employeeService.getEmployeeById(empId));
        }
    
        // get all employee

	@GetMapping("/")
	    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){

		return ResponseEntity.ok(this.employeeService.getAllEmployee());

	}

	// to delete employee by id

	 @DeleteMapping("/{empId}")
	    public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable Integer empId){

		this.employeeService.deleteEmployee(empId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Employee deleted successfully",true),HttpStatus.OK);
	 }
}
