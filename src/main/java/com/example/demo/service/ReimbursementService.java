package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.User;
import com.example.demo.model.dto.request.InsertReimbursement;
import com.example.demo.model.dto.request.ReimbursementItem;
import com.example.demo.model.dto.request.UpdateReimbursement;
import com.example.demo.model.dto.response.ReimbursementBySupervisor;
import com.example.demo.model.dto.response.ReimbursementResponse;
import com.example.demo.repository.ReimbursementRepository;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service 
public class ReimbursementService {

    @Autowired 
    private ReimbursementRepository reimbursementRequestRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public List<ReimbursementResponse> getByUserId(Integer userId) {
        return reimbursementRequestRepository.findByEmployee_Id(userId);
    }

    public List<ReimbursementItem> getItem(Integer reimbursementId) {
        return reimbursementRequestRepository.findItemByReimbursementId(reimbursementId);
    }

    public List<ReimbursementBySupervisor> getBySupervisorId(Integer supervisorId) {
        return reimbursementRequestRepository.findBySupervisorId(supervisorId);
    }

    public List<ReimbursementBySupervisor> getByFinance() {
        return reimbursementRequestRepository.findByFinance();
    }

    @Transactional 
    public void insert(InsertReimbursement insertReimbursement) {
        Integer employeeId = insertReimbursement.getEmployeeId();
        List<ReimbursementItem> items = insertReimbursement.getItems();
        String itemsJson = serializeItems(items);
        String status = insertReimbursement.getStatus();

        reimbursementRequestRepository.insert(
            employeeId,
            insertReimbursement.getDescription(),
            status,
            itemsJson
        );
    }

    @Transactional 
    public String update(UpdateReimbursement updateReimbursement) {
        List<ReimbursementItem> items = updateReimbursement.getItems();
        String itemsJson = serializeItems(items);

        reimbursementRequestRepository.update(
            updateReimbursement.getReimbursementId(),
            updateReimbursement.getDescription(),
            updateReimbursement.getStatus(),
            itemsJson
        );

        return "Reimbursement Berhasil di update";
    }

    private String serializeItems(List<ReimbursementItem> items) {
        try {
            if (items != null && !items.isEmpty()) {
                return objectMapper.writeValueAsString(items);
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize items to JSON");
        }
    }
}

