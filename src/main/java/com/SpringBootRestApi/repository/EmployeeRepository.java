package com.SpringBootRestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBootRestApi.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
