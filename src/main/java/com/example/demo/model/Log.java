package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tr_log")
@AllArgsConstructor
@NoArgsConstructor
@Builder 
@Data
public class Log {
    public Log(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String tableName;
    private String action;
    private HashMap oldString;
    private HashMap newValues;
    private LocalDate created_at;
    private int created_by;

}
