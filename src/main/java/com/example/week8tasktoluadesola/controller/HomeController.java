package com.example.week8tasktoluadesola.controller;

import com.example.week8tasktoluadesola.model.Company;
import com.example.week8tasktoluadesola.repository.CompanyRepository;
import com.example.week8tasktoluadesola.serviceImplementation.CompanyServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CompanyServiceImplementation companyServiceImplementation;

    @GetMapping("/")
    public String index(Model model){
        List<Company> companies = companyServiceImplementation.isPopular();
        model.addAttribute("companies", companies);
        System.err.println(companies);
        return "home";
    }

    @GetMapping("/company_detail")
    public String companyDetail(){
        return "company_details";
    }
}
