package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.helper.Response;
import com.example.demo.model.dto.request.InsertReimbursement;
import com.example.demo.model.dto.request.UpdateReimbursement;
import com.example.demo.service.ReimbursementService;

@RestController 
@RequestMapping("api")
public class ReimbursementController {

    @Autowired 
    private ReimbursementService reimbursementService;

    @PostMapping("reimbursement/insert")
    public ResponseEntity<Object> insert(@RequestBody InsertReimbursement insertReimbursement) {
        Integer newRequestId = reimbursementService.insert(insertReimbursement);
        return Response.generate(newRequestId, "Request berhasil dieksekusi");
    }

    @PutMapping ("reimbursement/update")
    public ResponseEntity<Object> update (@RequestBody UpdateReimbursement updateReimbursement) {
        reimbursementService.update(updateReimbursement);

        return Response.generate("Request berhasil di update");
    }
}
