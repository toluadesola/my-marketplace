package com.toluAdesola.myMarketPlace.repository;

import com.toluAdesola.myMarketPlace.model.Company;
import com.toluAdesola.myMarketPlace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findAllByIsPopularEquals(String value);
    Company findCompanyById(Long id);
    List<Company> findAllByUserOrderById(User user);
    List<Company> getDistinctByIndustryTypeIn(List<Company> company);
//    List<Company> findByIndustryType(List<Company> company);
    List<Company> findCompanyByCityAndIndustryTypeOrCompanyName(String city, String industryType, String companyName);
}
