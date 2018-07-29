package com.oocl.demo.repositories;

import com.oocl.demo.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
    List<Company> findAll();
    Company findByName(String name);
    @Transactional
    int deleteCompanyByName(@Param("name") String name);
    boolean existsByName(String name);
}
