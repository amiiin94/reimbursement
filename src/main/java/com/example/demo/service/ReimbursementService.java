package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dto.request.InsertReimbursement;
import com.example.demo.model.dto.request.ReimbursementItem;
import com.example.demo.model.dto.request.UpdateReimbursement;
import com.example.demo.repository.ReimbursementRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service 
public class ReimbursementService {

    @Autowired 
    private ReimbursementRepository reimbursementRequestRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Transactional 
    public Integer insert(InsertReimbursement insertReimbursement) {
        List<ReimbursementItem> items = new ArrayList<>();
        if (insertReimbursement.getItems() != null && !insertReimbursement.getItems().isEmpty()) {
            items.addAll(insertReimbursement.getItems());
        } else if (insertReimbursement.getReimbursementRequestItem() != null) {
            items.add(insertReimbursement.getReimbursementRequestItem());
        }

        String itemsJson = serializeItems(items);

        return reimbursementRequestRepository.insert(
            insertReimbursement.getEmployeeId(),
            insertReimbursement.getDescription(),
            insertReimbursement.getStatus(),
            itemsJson
        );
    }

    @Transactional 
    public String update(UpdateReimbursement updateReimbursement) {
        List<ReimbursementItem> items = new ArrayList<>();
        if (updateReimbursement.getItems() != null && !updateReimbursement.getItems().isEmpty()) {
            items.addAll(updateReimbursement.getItems());
        } else if (updateReimbursement.getReimbursementRequestItem() != null) {
            items.add(updateReimbursement.getReimbursementRequestItem());
        }

        String itemJson = serializeItems(items);

        reimbursementRequestRepository.update(
            updateReimbursement.getReimbursementId(),
            updateReimbursement.getDescription(),
            updateReimbursement.getStatus(),
            itemJson
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
            throw new RuntimeException("Failed to serialize items to JSON: " + e.getMessage(), e);
        }
    }
}
