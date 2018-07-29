package com.oocl.demo.repositories;

import com.oocl.demo.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByGender(String gender);

    @Transactional
    int deleteEmployeeById(@Param("id") Long id);

    Page<Employee> findAll(Pageable pageable);
}
