package com.Employee.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employee.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
