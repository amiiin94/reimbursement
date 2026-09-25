package com.example.demo.model.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReimbursementItem {

    private Integer categoryId;
    private String description;
    private BigDecimal amount;
    private LocalDate expenseDate;
    private String attachmentUrl;
}

