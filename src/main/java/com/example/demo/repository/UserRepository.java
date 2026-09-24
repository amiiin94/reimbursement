package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
import com.example.demo.model.dto.request.Login;

@Repository 
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query (
        """
            SELECT new com.example.demo.model.dto.request.Login 
            (officeEmail, password) 
            FROM User 
            WHERE officeEmail = ?1 AND password = ?2   
        """
    )
    
    public Login login(String officeEmail, String password); 

    
}
