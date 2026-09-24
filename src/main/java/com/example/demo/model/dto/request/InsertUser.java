package com.example.demo.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertUser {
    private Integer employeeId;
    private Integer roleId;
    private String officeEmail;
    private String password;
}