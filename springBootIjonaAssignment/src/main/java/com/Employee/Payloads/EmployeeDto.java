package com.Employee.Payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {

	private int id;
	
	@NotEmpty
	@Size(min=4, message="Employee must be min of 4 characters")
	private String name;
	
	@Email
	private String email;
	
    @NotEmpty
	private String department;
}
