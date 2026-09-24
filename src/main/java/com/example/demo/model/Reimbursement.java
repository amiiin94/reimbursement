package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tr_reimbursement_request")
@AllArgsConstructor
@NoArgsConstructor
@Builder 
@Data
public class Reimbursement {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String requestNumber;
    private LocalDate submitDate;
    private String Description;
    private String status;
    private LocalDate createdAt;
    private Integer createdBy;

    @ManyToOne 
    @JoinColumn (name = "employee_id", referencedColumnName = "id")
    private Employee employee;
}
