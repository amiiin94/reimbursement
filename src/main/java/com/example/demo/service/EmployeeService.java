package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.dto.response.User;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.UserRepository;

@Service 
public class EmployeeService {
    @Autowired 
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllEmployee() {
        return employeeRepository.getEmployee();
    }

    public User getEmployee(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID employee tidak valid: " + id);
        }

        User employee = employeeRepository.getEmployee(id);
        if (employee == null) {
            throw new IllegalArgumentException("Employee tidak ditemukan dengan id: " + id);
        }
        return employee;
    }

    public Employee getById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee tidak ditemukan dengan id: " + id));
    }

    public String insert(Employee employee) {
        if (employee.getCreatedAt() == null) {
            employee.setCreatedAt(LocalDate.now());
        }
        if (employee.getCreatedBy() == null) {
            employee.setCreatedBy(getCurrentUserId());
        }
        employeeRepository.save(employee);
        return "Employee berhasil ditambahkan";
    }

    public String update(Integer id, Employee employee) {
        Employee oldEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee tidak ditemukan dengan id: " + id));

        if (employee.getName() != null) {
            oldEmployee.setName(employee.getName());
        }
        if (employee.getEmail() != null) {
            oldEmployee.setEmail(employee.getEmail());
        }
        if (employee.getAccountNum() != null) {
            oldEmployee.setAccountNum(employee.getAccountNum());
        }
        if (employee.getAccountName() != null) {
            oldEmployee.setAccountName(employee.getAccountName());
        }
        if (employee.getDepartment() != null) {
            oldEmployee.setDepartment(employee.getDepartment());
        }
        if (employee.getBank() != null) {
            oldEmployee.setBank(employee.getBank());
        }
        if (employee.getEmployee() != null) {
            oldEmployee.setEmployee(employee.getEmployee());
        }

        employeeRepository.save(oldEmployee);
        return "Employee berhasil diupdate";
    }

    private Integer getCurrentUserId() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getPrincipal())) {
                String email = auth.getName();
                return userRepository.findByOfficeEmail(email).map(com.example.demo.model.User::getId).orElse(1);
            }
        } catch (Exception ignored) {
        }
        return 1;
    }
}

