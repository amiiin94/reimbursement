package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_m_department")
@AllArgsConstructor
@NoArgsConstructor
@Builder 
@Data
public class Department {
    public Department (Integer id) {
        this.id = id;
    }
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "created_by")
    private Integer createdBy;
}
