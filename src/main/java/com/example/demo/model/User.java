package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_m_user")
@AllArgsConstructor
@NoArgsConstructor
@Builder 
@Data
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String officeEmail;
    private String password;
    private LocalDateTime createdAt;
    private Integer createdBy;

    @OneToOne 
    @JoinColumn (name = "id", referencedColumnName = "id")
    @MapsId 
    private Employee employee;

    @ManyToOne 
    @JoinColumn (name = "role_id", referencedColumnName = "id")
    private Role role;
}
