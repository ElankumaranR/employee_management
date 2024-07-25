package com.pro.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/users")
    public String showUserList(Model model,@Param("name") String name){
        List<User> ListUsers;
        if(name==null) {
            ListUsers = service.listAll();
        }
        else{
            ListUsers = service.get(name);
        }
        model.addAttribute("ListUsers", ListUsers);
        model.addAttribute("name",name);

        return "users";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle","Add Employee");
        return "add_form";
    }
    @PostMapping("/save")
    public String saveUser(User user){
            service.save(user);
            return "redirect:/users";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model){
        try{
            User user = service.get(id);
            if(user==null){
                throw new Exception("Could not find a user");
            }
            model.addAttribute("user",user);
            model.addAttribute("pageTitle","Edit Employee");
            return "add_form";
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Error";
        }
    }
    @GetMapping("/delete/{id}")
    public String Delete(@PathVariable("id") Integer id){
        try{
            service.delete(id);
            return "redirect:/users";
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Error";
        }
    }

}

