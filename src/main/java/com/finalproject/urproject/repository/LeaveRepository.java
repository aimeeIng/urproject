package com.finalproject.urproject.repository;

import com.finalproject.urproject.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {
    @Query("SELECT leave FROM Leave leave WHERE CONCAT(leave.id, leave.country, leave.institution) LIKE %?1%")
    public List<Leave> search(String keyword);

}
