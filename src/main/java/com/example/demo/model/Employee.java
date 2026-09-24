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
import javax.persistence.Table;

@Entity
@Table(name = "tb_m_employee")
@AllArgsConstructor
@NoArgsConstructor
@Builder 
@Data
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private Long accountNum;
    private String accountName;
    private LocalDate createdAt;
    private Integer createdBy;

    @ManyToOne 
    @JoinColumn (name = "department_id", referencedColumnName = "id")
    private Department department;

    @ManyToOne 
    @JoinColumn (name = "bank_id", referencedColumnName = "id")
    private Bank bank;

    @ManyToOne  
    @JoinColumn (name = "supervisor_id", referencedColumnName = "id")
    private Employee employee;
}
