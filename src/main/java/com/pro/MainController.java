package com.pro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Autowired
    private loginservice service;

    @GetMapping("/")
    public String showHomePage(@Param("email") String email,@Param("pass") String pass){
        return service.getLogin(email,pass);
    }
    @GetMapping("/new")
    public String show(Model model) {
        model.addAttribute("main", new Main());
        return "login";
    }
    @PostMapping("/login")
    public String save(Main main){
        return service.save(main);
    }
}
