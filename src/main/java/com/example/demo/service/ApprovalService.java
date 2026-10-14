package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.User;
import com.example.demo.model.dto.request.ApprovalRequest;
import com.example.demo.model.dto.response.ApprovalResponse;
import com.example.demo.repository.ApprovalRepository;
import com.example.demo.repository.UserRepository;

@Service 
public class ApprovalService {
    @Autowired 
    private ApprovalRepository approvalRepository;

    @Transactional 
    public void processApproval(ApprovalRequest approvalRequest) {
        Integer approverId = approvalRequest.getApproverId();
        approvalRepository.processApproval(
                approvalRequest.getRequestId(),
                approverId,
                approvalRequest.getApprovalLevel(),
                approvalRequest.getAction(),
                approvalRequest.getNote()
        );
    }

    public List<ApprovalResponse> getApproval() {
       return approvalRepository.getApproval();
    }

    
}

