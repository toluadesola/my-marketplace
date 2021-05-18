package com.example.week8tasktoluadesola.controller;

import com.example.week8tasktoluadesola.SendMailService;
import com.example.week8tasktoluadesola.model.Company;
import com.example.week8tasktoluadesola.model.SendMail;
import com.example.week8tasktoluadesola.repository.CompanyRepository;
import com.example.week8tasktoluadesola.repository.SendMailRepository;
import com.example.week8tasktoluadesola.serviceImplementation.CompanyServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
        System.err.println(companies);
        return "home";
    }

    @GetMapping("/company_detail")
    public String companyDetail(Model model, Long id){
        System.err.println(id);
        Company company = companyServiceImplementation.getCompanyById(id);
        model.addAttribute("company", company);
        model.addAttribute("mail", new SendMail());
        return "company_details";
    }

    @GetMapping("/company_all")
    public String companyAll(Model model){
        List<Company> companies = companyServiceImplementation.getAllCompanies();
        model.addAttribute("companies", companies);
        return "company_all";
    }

    @GetMapping("/send_mail")
    public String sendMail(SendMail sendMail, HttpServletRequest request){
        try {
            Company company = companyServiceImplementation.getCompanyById(sendMail.getCompanyId());
            sendMailService.sendEmail(sendMail.getEmail().trim(), sendMail.getText(), sendMail.getSubject(), company.getCompanyEmail().trim());
            sendMailRepository.save(sendMail);
            company.getSendMail().add(sendMail);
            companyServiceImplementation.saveCompany(company);
        }catch (Exception e){}
        return "redirect:"+request.getHeader("Referer");
    }
}
