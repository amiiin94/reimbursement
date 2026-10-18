package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.helper.Response;
import com.example.demo.model.dto.request.ApprovalRequest;
import com.example.demo.service.ApprovalService;

@RestController 
@RequestMapping("api")
public class ApprovalController {
    
    @Autowired
    private ApprovalService approvalService;

    @PostMapping("approval/process")
    public ResponseEntity<Object> processApproval(@RequestBody ApprovalRequest request) {
        approvalService.processApproval(request);
        return Response.generate("Approval processed successfully");
    }

    @GetMapping ("approval")
    public ResponseEntity<Object> getApproval() {
        return Response.generate(approvalService.getApproval(), "Approval berhasil diambil");
    }

    @GetMapping ("approval/request/{requestId}")
    public ResponseEntity<Object> getByRequestId(@org.springframework.web.bind.annotation.PathVariable Integer requestId) {
        return Response.generate(approvalService.getByRequestId(requestId), "Approval history berhasil diambil");
    }
}