package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Reimbursement;
import com.example.demo.model.dto.request.ReimbursementItem;
import com.example.demo.model.dto.response.ReimbursementResponse;

@Repository 
public interface ReimbursementRepository extends JpaRepository<Reimbursement, Integer> {
    
    @Procedure(procedureName = "sp_create_reimbursement")
    Integer insert(
        @Param("p_employee_id") Integer employeeId,
        @Param("p_description") String description,
        @Param("p_status") String status,
        @Param("p_items_json") String itemsJson
    );

    @Modifying 
    @Query(value = "CALL sp_update_reimbursement(:p_reimbursement_id, :p_description, :p_status, :p_items_json)", nativeQuery = true)
    public void update(
        @Param("p_reimbursement_id") Integer reimbursementId,
        @Param("p_description") String description,
        @Param("p_status") String status,
        @Param("p_items_json") String itemsJson
    );

    @Query(
        """
            SELECT new com.example.demo.model.dto.response.ReimbursementResponse
            (r.requestNumber, r.submitDate, r.Description, r.status)
            FROM Reimbursement r
            WHERE r.employee.id = ?1
        """
    )
    List<ReimbursementResponse> findByEmployee_Id(Integer employeeId);
}
