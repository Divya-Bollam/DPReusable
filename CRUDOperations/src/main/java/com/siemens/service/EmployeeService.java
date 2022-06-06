package com.siemens.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siemens.entity.Employee;
import com.siemens.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee getEmployyeById(int id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		if (optional.isPresent()) {

			Employee employee = optional.get();
			return employee;
		}
		return null;
	}

	public Optional<Employee> updateEmployeedetails(Employee employee) {
		return employeeRepository.findById(employee.getEmpId());
	}

	public String DeleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
		return "deleted";

	}
}
