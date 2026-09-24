package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Role;

@Repository 
public interface RoleRepository extends JpaRepository<Role, Integer> {
    
    @Modifying 
    @Query (value = "CALL sp_insert_role(:p_name, :p_created_by)", nativeQuery = true)
    public void insert(
        @Param("p_name") String name,
        @Param("p_created_by") Integer createdBy
    );

    
}
