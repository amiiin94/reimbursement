package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.helper.Response;
import com.example.demo.model.dto.response.User;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping ("api") 
public class EmployeeController {
    @Autowired 
    private EmployeeService employeeService;
    
    @GetMapping ("employees") // localhost:8080/api/employees
    public ResponseEntity<Object> getAll() {
        return Response.generate(employeeService.getAllEmployee(), "Request berhasil dieksekusi");
    }

    @GetMapping ("employees/{id}") // localhost:8080/api/employees/1
    public ResponseEntity<Object> getAll(@PathVariable (name = "id") Integer id) {
        return Response.generate(employeeService.getEmployee(id), "Request berhasil dieksekusi");
    }


}
