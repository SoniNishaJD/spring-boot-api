package com.SpringBootRestApi.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.SpringBootRestApi.model.Employee;
import com.SpringBootRestApi.repository.EmployeeRepository;

import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	
      EmployeeRepository repository;
   

	@Override
	public List<Employee> getAllEmployee() {
		return repository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		Optional<Employee> optional=repository.findById(id);
		Employee employee = null;
		if(optional.isPresent()) {
			employee=optional.get();
		}else {
			throw new RuntimeException("Employee not Found for id:: "+id);
		}
		return employee;
	
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		repository.findById(id);
		repository.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee, Integer id) {
		Employee existingEmployee = repository.findById(id).get();

		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());

		repository.save(existingEmployee);
		return existingEmployee;
	}

	
	}
