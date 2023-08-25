package com.example.demo.hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Employee;

@Service
public class HelloService {
	
	@Autowired
	private HelloRepository helloRepository;
	
	public Employee getEmployee(String id) {
		Map<String,Object> map = helloRepository.findById(id);
		
		String employeeId = (String)map.get("Id");
		String employeeName = (String)map.get("Name");
		Integer employeeAge = (Integer)map.get("Age");
		Employee employee = new Employee();
		employee.setEmployeeAge(employeeAge);
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(employeeName);
		
		return employee;
		
		
	}

}
