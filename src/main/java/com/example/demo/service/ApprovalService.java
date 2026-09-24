package com.example.demo.service;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.request.ApprovalRequest;
import com.example.demo.repository.ApprovalRepository;

@Service 
public class ApprovalService {
    @Autowired 
    ApprovalRepository approvalRepository;

    @Transactional 
    public void processApproval(ApprovalRequest approvalRequest) {
    approvalRepository.processApproval(
                approvalRequest.getRequestId(),
                approvalRequest.getApproverId(),
                approvalRequest.getApprovalLevel(),
                approvalRequest.getAction(),
                approvalRequest.getNote()
            );
    }
}
