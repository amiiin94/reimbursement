package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.helper.Response;
import com.example.demo.model.Employee;
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

    @PostMapping ("employee/insert")
    public ResponseEntity<Object> insert(@RequestBody Employee employee) {
        return Response.generate(employeeService.insert(employee));
    }

    @PutMapping ("employee/update/{id}")
    public ResponseEntity<Object> update(@PathVariable (name = "id") Integer id, @RequestBody Employee employee) {
        return Response.generate(employeeService.update(id, employee));
    }
}
