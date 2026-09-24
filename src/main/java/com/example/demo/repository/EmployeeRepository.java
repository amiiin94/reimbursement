package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import com.example.demo.model.dto.response.User;

@Repository 
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    @Query (
        """
                SELECT new com.example.demo.model.dto.response.User (
                e.id,
                e.name,
                e.email,
                u.officeEmail,
                r.name) 
                FROM User u JOIN u.employee e join u.role r
        """
    )

    public List<User> getEmployee();

     @Query (
        """
                SELECT new com.example.demo.model.dto.response.User (
                e.id,
                e.name,
                e.email,
                u.officeEmail,
                r.name) 
                FROM User u JOIN u.employee e join u.role r where e.id = ?1
        """
    )

    public User getEmployee(int id);

    
    
}
