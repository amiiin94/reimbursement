package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.helper.Response;
import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;

@RestController 
@RequestMapping ("api")
public class DepartmentController {
    @Autowired 
    private DepartmentService departmentService;

    @GetMapping ("department")
    public ResponseEntity<Object> getAll() {
        return Response.generate(departmentService.getAll(), "Departemen berhasil ditampilkan");
    }

    @GetMapping ("department/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id) {
        return Response.generate(departmentService.getById(id), "Departemen berhasil ditampilkan");
    }

    @PostMapping ("department/insert")
    public ResponseEntity<Object> insert(@RequestBody Department department) {
        return Response.generate(departmentService.insert(department));
    }

    @PutMapping ("department/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Department department) {
        return Response.generate(departmentService.update(id, department));
    }

    @DeleteMapping ("department/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return Response.generate(departmentService.delete(id));
    }

}
