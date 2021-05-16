package com.example.week8tasktoluadesola.service;

import com.example.week8tasktoluadesola.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    void saveCompany(Company company);
    List<Company> isPopular();
}
