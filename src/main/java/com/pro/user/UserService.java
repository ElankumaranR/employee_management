package com.pro.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.Optional;

@Service
public class UserService {
    @Autowired private UserRepository repo;


    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }

    public void save(User user1) {
        List<User> all = (List<User>)repo.findAll();
        User user = new User();
        int c=1;
        for(int i=0;i<all.size();i++){
            user = all.get(i);
            if(user.getEmail().compareTo(user1.getEmail())==0&&user.getId()!=user1.getId()){
                c=0;
            }
        }
        if(c==1){
            repo.save(user1);
        }
        else{
            System.out.println("email already exist");
        }

    }

    public User get(Integer id) {
        Optional<User> result = repo.findById(id);
        return result.orElse(null);
    }
    public List<User> get(String name){
        List<User> find = new ArrayList<User>();
        List<User> all = (List<User>)repo.findAll();
        User user = new User();
        for(int i=0;i<all.size();i++){
            user = all.get(i);
            if(user.getName().contains(name)){
                find.add(user);
            }
        }

        return find;
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }

}