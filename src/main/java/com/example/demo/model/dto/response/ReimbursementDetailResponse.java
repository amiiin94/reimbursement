package com.example.demo.model.dto.response;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.model.dto.request.ReimbursementItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReimbursementDetailResponse {
    private Integer id;
    private String requestNumber;
    private LocalDate submitDate;
    private String description;
    private String status;
    private Integer employeeId;
    private String employeeName;
    private List<ReimbursementItem> items;
    private List<ApprovalResponse> approvalHistory;
}
