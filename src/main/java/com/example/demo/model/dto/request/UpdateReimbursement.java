package com.example.demo.model.dto.request;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateReimbursement {
    private Integer reimbursementId;
    private String description;
    private String status;
    private List<ReimbursementItem> items;
}
