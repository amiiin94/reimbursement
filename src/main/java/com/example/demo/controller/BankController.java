package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.helper.Response;
import com.example.demo.model.Bank;
import com.example.demo.service.BankService;

@RestController 
@RequestMapping ("api")
public class BankController {
    @Autowired 
    BankService bankService;

    @GetMapping ("banks")
    public ResponseEntity<Object> getAll() {
        return Response.generate(bankService.getAll(), "Bank berhasil ditampilkan");
    }

    @GetMapping ("bank/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id) {
        return Response.generate(bankService.getById(id), "Bank berhasil ditampilkan");
    }

    @PostMapping ("bank/insert")
    public ResponseEntity<Object> insert(@RequestBody Bank bank) {
        return Response.generate(bankService.insert(bank), "Bank berhasill ditambahkan");
    }

    @PostMapping ("bank/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Bank bank) {
        return Response.generate(bankService.update(id, bank), "Bank berhasil di update");
    }

    @DeleteMapping ("bank/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return Response.generate(bankService.delete(id), "bank berhasil dihapus");
    }
}
