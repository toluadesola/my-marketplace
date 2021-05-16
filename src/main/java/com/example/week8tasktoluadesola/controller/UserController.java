package com.example.week8tasktoluadesola.controller;

import com.example.week8tasktoluadesola.model.Company;
import com.example.week8tasktoluadesola.model.User;
import com.example.week8tasktoluadesola.service.UserService;
import com.example.week8tasktoluadesola.serviceImplementation.UserServiceImplementation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserServiceImplementation userServiceImplementation;

    @GetMapping("/login")
    public String showLogin(Model model){
        model.addAttribute("users", new User());
        model.addAttribute("company", new Company());
        return "login";
    }

    @GetMapping("failedLogin")
    public String failedLogin(Model model){
        model.addAttribute("message", "login detail e wrong dear, try again pele...");
        model.addAttribute("users", new User());
        model.addAttribute("company", new Company());
        return "login";
    }

    @PostMapping("logUserIn")
    public String logUserIn(HttpServletRequest request, @ModelAttribute User user) {
        User authUser = userServiceImplementation.logUserIn(user.getEmail(), user.getPassword());
        if (authUser == null) {
            return "redirect:/failedLogin";
        } else {
            userServiceImplementation.setUserSession(authUser, request);
            return "redirect:/admin";
        }
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, HttpServletRequest request){
        User checkUser = userServiceImplementation.findByEmail(user.getEmail());

        if(checkUser != null) return "redirect:"+request.getHeader("Referer");

        userServiceImplementation.saveUser(user);
        userServiceImplementation.setUserSession(user, request);
        return "redirect:/admin";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user_session");
        session.invalidate();
        return "redirect:/login";
    }
}
