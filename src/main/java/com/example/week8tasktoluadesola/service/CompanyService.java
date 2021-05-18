package com.example.week8tasktoluadesola.service;

import com.example.week8tasktoluadesola.model.Company;
import com.example.week8tasktoluadesola.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    void saveCompany(Company company);
    List<Company> isPopular();
    List<Company> getAllCompanies();
    Company getCompanyById(Long id);
    List<Company> findCompanyByUser(User user);
}
