package com.example.week8tasktoluadesola.controller;

import com.example.week8tasktoluadesola.model.Company;
import com.example.week8tasktoluadesola.model.User;
import com.example.week8tasktoluadesola.serviceImplementation.CompanyServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@MultipartConfig
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    CompanyServiceImplementation companyServiceImplementation;

    @GetMapping("")
    public String admin(){
        return "admin/index";
    }

    @GetMapping("/create")
    public String create_company(Model model){
        model.addAttribute("company", new Company());
        return "admin/create/company";
    }

    @PostMapping("/save/company")
    public String save_company(@ModelAttribute  Company company, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user_session");
        company.setUser(user);
        System.err.println(company);

        try {
            Part image = request.getPart("image");
            //set imageName
            String imageName = image.getSubmittedFileName();
            company.setImages(imageName);
            //path to store image
            String path = "src/main/resources/static/images"+ File.separator+imageName;
            InputStream img = image.getInputStream();
            boolean imgSuccess = uploadFile(img, path);
            System.err.println(company);
            if(imgSuccess){
                companyServiceImplementation.saveCompany(company);
                session.setAttribute("message", "Successfully created account.");
            }else{
                session.setAttribute("message", "Unable to create account, error uploading file");
                return "redirect:"+request.getHeader("Referer");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return "redirect:/admin";
    }


    public boolean uploadFile(InputStream in, String path){
        boolean test = false;
        try{
            byte[] byt = new byte[in.available()];
            in.read(byt);
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            fileOutputStream.write(byt);
            fileOutputStream.flush();
            fileOutputStream.close();
            test = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return test;
    }



}
