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
import com.example.demo.model.Role;
import com.example.demo.service.RoleService;


@RestController 
@RequestMapping ("api")
public class RoleController {
    @Autowired 
    RoleService roleService;

    @GetMapping ("roles")
    public ResponseEntity<Object> getAll() {
        return Response.generate(roleService.getRole(), "Role berhasil ditampilkan");
    }

    @GetMapping ("role/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id) {
        return Response.generate(roleService.getRoleById(id), "Role berhasil ditampilkan");
    }

    @PostMapping ("role/insert")
    public String insert(@RequestBody Role role) {
        return roleService.insert(role);
    }

    @PutMapping("role/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Role role) {
        roleService.update(id, role);
        return Response.generate(roleService.update(id, role), "Role berhasil di update");
    }

    @DeleteMapping ("role/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        roleService.delete(id);
        return Response.generate("Role berhasil di delete");
    }

}
