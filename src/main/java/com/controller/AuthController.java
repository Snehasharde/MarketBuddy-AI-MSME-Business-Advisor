package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Email.EmailService;
import com.Entity.User;
import com.service.UserService;

import jakarta.mail.MessagingException;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String fullName,
                                @RequestParam String email,
                                @RequestParam String password,
                                @RequestParam String confirmPassword,
                                Model model) {

        if (!password.equals(confirmPassword)) {
            model.addAttribute("errorMessage", "Passwords do not match");
            return "register";
        }

        if (userService.existsByEmail(email)) {
            model.addAttribute("errorMessage", "Email already registered");
            return "register";
        }

        User newUser = new User();
        newUser.setFullName(fullName);
        newUser.setEmail(email);
        newUser.setPassword(password);

        userService.saveUser(newUser);

        model.addAttribute("successMessage", "Registration successful! Please login.");
        return "register";
    }
}
