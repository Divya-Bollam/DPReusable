package com.siemens.resource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siemens.dto.EmployeeDto;
import com.siemens.entity.Employee;
import com.siemens.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmploeeResource {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ModelMapper mapper;

	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") int id) {
		
		Employee employee = employeeService.getEmployyeById(id);
		if (employee != null) {
			EmployeeDto employeeDto=mapper.map(employee, EmployeeDto.class);
			return new ResponseEntity<>(employeeDto, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
