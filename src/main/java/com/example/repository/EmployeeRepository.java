package com.example.repository;

import com.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE e.name = :name")
    List<Employee> findByName(@Param("name") String name);

    @Query(value = "SELECT * FROM Employee e WHERE e.department = ?1", nativeQuery = true)
    List<Employee> findByDepartment(String department);
}

