package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.dto.response.ApprovalResponse;
import java.util.List;

import com.example.demo.model.Approval;

@Repository
public interface ApprovalRepository extends JpaRepository<Approval, Integer> {

    @Modifying
    @Query(value = "CALL sp_process_approval(:requestId, :approverId, :approvalLevel, :action, :note)", nativeQuery = true)
    void processApproval(
            @Param("requestId") Integer requestId,
            @Param("approverId") Integer approverId,
            @Param("approvalLevel") Integer approvalLevel,
            @Param("action") String action,
            @Param("note") String note);

    @Query("""
                SELECT new com.example.demo.model.dto.response.ApprovalResponse(
                    a.id,
                    r.description,
                    e.name,
                    a.approvalLevel,
                    a.status,
                    a.note,
                    a.createdAt,
                    a.createdBy
                )
                FROM Approval a
                JOIN a.employee e
                JOIN a.reimbursementRequest r
            """)
    List<ApprovalResponse> getApproval();

    @Query("""
                SELECT new com.example.demo.model.dto.response.ApprovalResponse(
                    a.id,
                    r.description,
                    e.name,
                    a.approvalLevel,
                    a.status,
                    a.note,
                    a.createdAt,
                    a.createdBy
                )
                FROM Approval a
                LEFT JOIN a.employee e
                JOIN a.reimbursementRequest r
                WHERE r.id = ?1
                ORDER BY a.createdAt ASC, a.id ASC
            """)
    List<ApprovalResponse> findByReimbursementRequestId(Integer requestId);
}
