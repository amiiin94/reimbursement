package com.example.demo.model.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReimbursementItem {

    @JsonProperty("category_id")
    @JsonAlias({"categoryId", "category_id"})
    private Integer categoryId;

    @JsonProperty("description")
    private String description;

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("expense_date")
    @JsonAlias({"expenseDate", "expense_date"})
    private LocalDate expenseDate;

    @JsonProperty("attachment_url")
    @JsonAlias({"attachmentUrl", "attachment_url"})
    private String attachmentUrl;
}

