package com.example.demo.model.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReimbursementBySupervisor {
    private Integer id;
    private String requestNumber;
    private LocalDate submitDate;
    private String name;
    private String description;
    private String status;
}
