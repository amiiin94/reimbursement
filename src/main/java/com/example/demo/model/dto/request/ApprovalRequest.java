package com.example.demo.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApprovalRequest {
    private Integer requestId;
    private Integer approverId;
    private Integer approvalLevel;  
    private String action;       
    private String note;        
}
