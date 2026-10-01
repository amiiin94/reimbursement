package com.example.demo.model.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeRequest {
    private Integer id;
    private String name;
    private String email;
    private Long accountNum;
    private String accountName;
    private Integer departmentId;
    private Integer bankId;
    private Integer supervisorId;
    private Integer createdBy;
}
