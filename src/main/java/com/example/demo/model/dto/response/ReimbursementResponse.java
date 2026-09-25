package com.example.demo.model.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReimbursementResponse {
    private String requestNumber;
    private LocalDate submitDate;
    private String Description;
    private String status;
}
