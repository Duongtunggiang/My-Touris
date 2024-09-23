package com.dulich.tourism.controller;

import com.dulich.tourism.models.account.Account;
import com.dulich.tourism.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping({"/",""})
    public String home(Model model){
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model){

        return "account/login";
    }
    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model){
        Account account = accountRepository.findByEmail(email);

        if (account != null && passwordEncoder.matches(password,account.getPassword())){
            if (account.getRole().getName().equals("Customer")){
                return "redirect/home";
            }
            else if (account.getRole().getName().equals("Admin")){
                return "redirect/dashboard";
            } else if (account.getRole().getName().equals("Hotel-Owner")) {
                return "redirect/hotel-owner";
            }
            else if (account.getRole().getName().equals("Tour-Owner")){
                return "redirect/tour-owner";
            }
        }
        model.addAttribute("error","Invalid 'Email' or your 'Password'!");
        model.addAttribute("email",email);
        return "account/login";
    }
}
