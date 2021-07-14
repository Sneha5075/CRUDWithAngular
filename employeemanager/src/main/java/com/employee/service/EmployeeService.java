package com.employee.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.employee.exception.UserNotFoundException;
import com.employee.model.Employee;
import com.employee.repo.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class EmployeeService {

	private final EmployeeRepository employeerepository;

	//add employee
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeerepository.save(employee);
		}
	
	//find Allemployee
	public List<Employee> findAllEmployee(){
		return employeerepository.findAll();
	}
	
	//update employee
	public Employee updateEmployee(Employee employee) {
		return employeerepository.save(employee);
	}
	
	public Employee findEmployeeById(Long id) {
        return employeerepository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }
	
	//delete employee
	public void deleteEmployee(Long id) {
		employeerepository.deleteEmployeeById(id);
	}
}