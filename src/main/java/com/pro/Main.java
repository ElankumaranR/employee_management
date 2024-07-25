package com.pro;

import jakarta.persistence.*;

@Entity
@Table(name ="logins")
public class Main {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(nullable = false, unique = true, length = 225,name = "e-mail")
    private String e;
    @Column(length = 20)
    private String pass;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
