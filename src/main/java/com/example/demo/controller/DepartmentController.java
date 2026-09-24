package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.helper.Response;
import com.example.demo.service.DepartmentService;

@RestController 
@RequestMapping ("api")
public class DepartmentController {
    @Autowired 
    private DepartmentService departmentService;

    @GetMapping ("departments")
    public ResponseEntity<Object> getAll() {
        return Response.generate(departmentService.getAll(), "Departemen berhasil ditampilkan");
    }
}
