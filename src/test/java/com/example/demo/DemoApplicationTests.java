package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.dto.response.User;
import com.example.demo.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@SpringBootTest
@RequiredArgsConstructor 
class DemoApplicationTests {
	// AAA

	// - Arrange
	@Autowired 
	private EmployeeService employeeService;

	@Test
	void contextLoads() {
		// - Act
		List<User> users = employeeService.getAllEmployee();
		int actual = users.size();
		
		// - Assert
		assertEquals(12, actual);
	}

}

