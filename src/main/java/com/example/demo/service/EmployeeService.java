package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.dto.response.User;
import com.example.demo.repository.EmployeeRepository;

@Service 
public class EmployeeService {
    @Autowired 
    private EmployeeRepository employeeRepository;

    public List<User> getAllEmployee() {
        return employeeRepository.getEmployee();
    }

    public User getEmployee(int id) {
        if (id <= 0) {
            return null;
        }

        return employeeRepository.getEmployee(id);
    }

    public Employee getById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public String insert(Employee employee) {
        try {
            if (employee.getCreatedAt() == null) {
                employee.setCreatedAt(LocalDate.now());
            }
            if (employee.getCreatedBy() == null) {
                employee.setCreatedBy(1);
            }
            employeeRepository.save(employee);
            return "Employee berhasil ditambahkan";
        } catch (Exception e) {
            return "Employee gagal ditambahkan: " + e.getMessage();
        }
    }

    public String update(Integer id, Employee employee) {
        Employee oldEmployee = employeeRepository.findById(id).orElse(null);
        if (oldEmployee == null) {
            return "Employee tidak ditemukan";
        }

        try {
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
        } catch (Exception e) {
            return "Employee gagal diupdate: " + e.getMessage();
        }
    }
}
