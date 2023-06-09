package com.Employee.Payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// I created EmployeeDto to avoid direct connected to employee Entity class


@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {

	private int id;
	
	@NotEmpty
	@Size(min=4, message="Employee must be min of 4 characters")
	private String name;
	
	
	@Email(message="Invalid Email!!")
	private String email;
	
    @NotEmpty
	private String department;
}
