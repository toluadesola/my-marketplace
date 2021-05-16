package com.example.week8tasktoluadesola.repository;

import com.example.week8tasktoluadesola.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findAllByIsPopularEquals(String value);
}
