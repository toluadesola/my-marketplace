package com.toluAdesola.myMarketPlace.serviceImplementation;

import com.toluAdesola.myMarketPlace.model.User;
import com.toluAdesola.myMarketPlace.repository.CompanyRepository;
import com.toluAdesola.myMarketPlace.service.CompanyService;
import com.toluAdesola.myMarketPlace.model.Company;
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

    @Override
    public List<Company> getDistinctIndustryType(List<Company> company) {
        return companyRepository.getDistinctByIndustryTypeIn(company);
    }

    @Override
    public List<Company> searchCompany(String city, String industryType, String companyName) {
        return companyRepository.findCompanyByCityAndIndustryTypeOrCompanyName(city, industryType, companyName);
    }
}
