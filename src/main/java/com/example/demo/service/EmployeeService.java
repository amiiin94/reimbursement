package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.response.User;
import com.example.demo.repository.EmployeeRepository;

@Service 
public class EmployeeService {
    @Autowired 
    private EmployeeRepository employeeReository;

    public List<User> getAllEmployee() {
        return employeeReository.getEmployee();
    };

    public User getEmployee(int id) {
        if (id <= 0) {
            return null;
        }

        return employeeReository.getEmployee(id);
    };

    
}
