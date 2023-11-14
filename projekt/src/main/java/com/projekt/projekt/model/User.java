package com.projekt.projekt.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "login")
    private String login;
    @Column(name = "haslo")
    private String haslo;
    @Column(name = "dane_user_id")
    private Integer daneUserId;

    public User() {
    }
    public User(String login, String haslo) {
        this.login = login;
        this.haslo = haslo;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getHaslo() {
        return haslo;
    }
    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
    public Integer getDaneUserId() {
        return daneUserId;
    }
    public void setDaneUserId(Integer daneUserId) {
        this.daneUserId = daneUserId;
    }
    
}

