package com.example.demo.model.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalResponse {
    private Integer id;
    private String description;
    private String approverName;
    private Integer approverLevel;
    private String status;
    private String note;
    private LocalDate createdAt;
    private Integer createdBy;
}
