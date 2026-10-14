package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.helper.Response;
import com.example.demo.model.dto.request.AuthUser;
import com.example.demo.model.dto.request.InsertUser;
import com.example.demo.service.UserService;

@RestController 
@RequestMapping("api")
public class UserController {
    @Autowired 
    private UserService userService;

    @PostMapping ("user/login")
    public ResponseEntity<Object> authLogin(@RequestBody AuthUser authUser) {
        return Response.generate(userService.loginWithJwt(authUser.getEmail(), authUser.getPassword()), "Login Berhasil");
    }

    @PostMapping ("user/register")
    public ResponseEntity<Object> insert(@RequestBody InsertUser insertUser) {
        return Response.generate(userService.insert(insertUser));
    }
}
