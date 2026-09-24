package com.example.demo.model.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertReimbursement {
    @JsonProperty("employee_id")
    @JsonAlias({"employeeId", "employee_id"})
    private Integer employeeId;

    private String description;
    private String status;
    private ReimbursementItem reimbursementRequestItem;
    private List<ReimbursementItem> items;
}
