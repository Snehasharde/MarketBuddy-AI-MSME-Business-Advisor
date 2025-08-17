package com.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping("/")
    public String home() {
        return "index"; // public home page
    }
	
	@GetMapping("/index")
    public String Index(Model model) {
		
        return "index"; // public Index page
    }

    @GetMapping("/about")
    public String about() {
        return "about"; // public about page
    }
    
    @GetMapping("/blog")
    public String blogs() {
        return "blog"; // public blogs page
    }
    
    @GetMapping("/features")
    public String features() {
        return "features"; // public features page
    }
    
    @GetMapping("/resourceC")
    public String resourceC() {
        return "resourceC"; // public resourceC page
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // login.html
    }

//    @GetMapping("/profile")
//    public String profile() {
//        return "profile"; // login.html
//    }
    
    @GetMapping("/logout")
    public String logout() {
        return "index"; // login.html
    }

   
}
