package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_tr_approval")
@AllArgsConstructor
@NoArgsConstructor
@Builder 
@Data
public class Approval {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer approvalLevel;
    private String status;
    private String note;
    private LocalDate createdAt;
    private Integer createdBy;

    @ManyToOne 
    @JoinColumn (name = "reimbursement_request_id", referencedColumnName = "id")
    private Reimbursement reimbursementRequest;

    @ManyToOne 
    @JoinColumn (name = "approver_id", referencedColumnName = "id")
    private Employee employee;

}
