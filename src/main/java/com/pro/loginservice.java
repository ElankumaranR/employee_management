package com.pro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class loginservice {
    @Autowired private Mainrepo rep;

    public String  save(Main user) {
        List<Main> log = (List<Main>) rep.findAll();
        int c = 1;
        for (int i = 0; i < log.size(); i++) {
            Main m = log.get(i);
            if (m.getE().compareTo(user.getE())==0) {
                c = 0;
                break;
            }
        }
        if (c==1){
            rep.save(user);
            return "redirect:/";
        } else {
            System.out.println("Email already exist");
            return "Error";
        }
    }
    public String getLogin(String email,String pass){
        if(email==null||pass==null){
            return "index";
        }
        else if (rep != null){
                List<Main> log = (List<Main>) rep.findAll();
            int c = 1;
            for (int i = 0; i < log.size(); i++) {
                Main m = log.get(i);
                if (m.getE().compareTo(email) == 0 && m.getPass().compareTo(pass) == 0) {
                    c = 0;
                    break;
                }
            }
            if (c==0){
                return "redirect:/users";
            } else {
                return "redirect:/";
            }
        }
        else{
            return "index";
        }
    }
}
