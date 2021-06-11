package com.toluAdesola.myMarketPlace.controller;

import com.toluAdesola.myMarketPlace.SendMailService;
import com.toluAdesola.myMarketPlace.model.Company;
import com.toluAdesola.myMarketPlace.repository.SendMailRepository;
import com.toluAdesola.myMarketPlace.serviceImplementation.CompanyServiceImplementation;
import com.toluAdesola.myMarketPlace.model.SendMail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
public class HomeController {
    @Autowired
    CompanyServiceImplementation companyServiceImplementation;
    @Autowired
    SendMailRepository sendMailRepository;
    @Autowired
    SendMailService sendMailService;

    @GetMapping("/")
    public String index(Model model){
        List<Company> companies = companyServiceImplementation.isPopular();
        model.addAttribute("companies", companies);
        model.addAttribute("industries", companyServiceImplementation.getAllCompanies());
        model.addAttribute("searchCompany", new Company());
        return "home";
    }

    @PostMapping("/search_company")
    public String searchCompany(Company company, Model model){
        List<Company> searchResults = companyServiceImplementation.searchCompany(company.getCity(), company.getIndustryType(), company.getCompanyName());
        model.addAttribute("companies", searchResults);
        return "company_all";
    }

    @GetMapping("/company_detail")
    public String companyDetail(Model model, Long id){
        Company company = companyServiceImplementation.getCompanyById(id);
        model.addAttribute("company", company);
        model.addAttribute("mail", new SendMail());
        return "company_details";
    }

    @GetMapping("/company_all")
    public String companyAll(Model model){
        List<Company> companies = companyServiceImplementation.getAllCompanies();
        model.addAttribute("industries", companyServiceImplementation.getAllCompanies());
        model.addAttribute("companies", companies);
        return "company_all";
    }

    @GetMapping("/send_mail")
    public String sendMail(SendMail sendMail, HttpServletRequest request){
        try {
            Company company = companyServiceImplementation.getCompanyById(sendMail.getCompanyId());
            sendMailService.sendEmail(sendMail, company.getCompanyEmail().trim());
            sendMailRepository.save(sendMail);
            company.getSendMail().add(sendMail);
            companyServiceImplementation.saveCompany(company);
        }catch (Exception e){}
        return "redirect:"+request.getHeader("Referer");
    }
}
