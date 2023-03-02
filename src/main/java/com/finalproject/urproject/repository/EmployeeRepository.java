package com.finalproject.urproject.repository;

import com.finalproject.urproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
   // @Query("SELECT emp FROM Employee emp WHERE emp.email = ?1")
    //Employee findByEmail(String email);
    @Query("SELECT p FROM Employee p WHERE CONCAT(p.id, p.firstName, p.lastName, p.email) LIKE %?1%")
    public List<Employee> search(String keyword);
    Optional<Employee> findByEmail(String email);

}
