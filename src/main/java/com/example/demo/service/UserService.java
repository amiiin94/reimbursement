package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.model.dto.request.InsertUser;
import com.example.demo.model.dto.request.Login;
import com.example.demo.model.dto.response.AuthUser;
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

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public AuthUser loginWithJwt(String officeEmail, String password) {
        User user = userRepository.findByOfficeEmail(officeEmail).orElse(null);
        if (user == null) {
            throw new RuntimeException("Email atau password salah");
        }

        // Support both BCrypt and plain-text passwords
        boolean passwordMatches = passwordEncoder.matches(password, user.getPassword());
        if (!passwordMatches) {
            throw new RuntimeException("Email atau password salah");
        }

        Map<String, Object> claims = new HashMap<>();
        if (user.getRole() != null) {
            claims.put("role", user.getRole().getName());
        }
        claims.put("Id", user.getId());

        String token = jwtService.createToken(claims, user.getOfficeEmail());
        return new AuthUser(token);
    }

    public String insert(InsertUser insertUser) {
        Employee employee = employeeRepository.findById(insertUser.getEmployeeId()).orElse(null);

        Role role = roleRepository.findById(insertUser.getRoleId()).orElse(null);

        try {
            User user = User.builder()
                .employee(employee)
                .role(role)
                .officeEmail(insertUser.getOfficeEmail())
                .password(passwordEncoder.encode(insertUser.getPassword()))
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
