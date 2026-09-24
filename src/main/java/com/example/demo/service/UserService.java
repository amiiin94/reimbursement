package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.model.dto.request.InsertUser;
import com.example.demo.model.dto.request.Login;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@Service 
public class UserService {
    @Autowired 
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;

    public String login(String officeEmail, String password) {
        Login user = userRepository.login(officeEmail, password);

        if (user != null) {
            return "Login Berhasil";
        }

        return "Email atau password salah";
    }

    public String insert(InsertUser insertUser) {
        Employee employee = employeeRepository.findById(insertUser.getEmployeeId()).orElse(null);

        Role role = roleRepository.findById(insertUser.getRoleId()).orElse(null);


        try {
            User user = User.builder()
                .employee(employee)
                .role(role)
                .officeEmail(insertUser.getOfficeEmail())
                .password(insertUser.getPassword())
                .createdAt(LocalDateTime.now())
                .createdBy(1)
                .build();

            userRepository.save(user);

            return "User berhasil ditambahkan";
        } catch (Exception e) {
            return "Gagal menambahkan user: " + e.getMessage();
        }
    }
}
