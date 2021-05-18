package com.example.week8tasktoluadesola.serviceImplementation;

import com.example.week8tasktoluadesola.model.Company;
import com.example.week8tasktoluadesola.model.User;
import com.example.week8tasktoluadesola.repository.CompanyRepository;
import com.example.week8tasktoluadesola.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyServiceImplementation implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public void saveCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public List<Company> isPopular() {
        return companyRepository.findAllByIsPopularEquals("set");
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findCompanyById(id);
    }

    @Override
    public List<Company> findCompanyByUser(User user) {
        return companyRepository.findAllByUserOrderById(user);
    }
}
