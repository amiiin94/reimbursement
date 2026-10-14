package com.example.demo.model.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApprovalRequest {
    private Integer requestId;
    private Integer approverId;
    private Integer approvalLevel;  
    private String action;       
    private String note;        
}
