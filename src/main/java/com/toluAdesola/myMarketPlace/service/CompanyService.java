package com.toluAdesola.myMarketPlace.service;

import com.toluAdesola.myMarketPlace.model.Company;
import com.toluAdesola.myMarketPlace.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    void saveCompany(Company company);
    List<Company> isPopular();
    List<Company> getAllCompanies();
    Company getCompanyById(Long id);
    List<Company> findCompanyByUser(User user);
    List<Company> getDistinctIndustryType(List<Company> company);
    List<Company> searchCompany(String city, String industryType, String companyName);
}
