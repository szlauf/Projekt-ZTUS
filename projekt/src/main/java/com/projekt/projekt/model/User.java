package com.projekt.projekt.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class User {
    // Identyfikator encji użytkownika, generowany automatycznie
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    // Nazwa użytkownika, przechowywana w kolumnie "login"
    @Column(name = "login")
    private String login;
    // Hasło użytkownika, przechowywane w kolumnie "haslo"
    @Column(name = "haslo")
    private String haslo;
    // Konstruktor domyślny, wymagany przez JPA
    @Column(name = "dane_user_id")
    private Integer daneUserId;

    @Transient
    private Double averageRating;

    // Konstruktor domyślny, wymagany przez JPA
    public User() {
    }
    // Konstruktor z parametrami login i haslo, ułatwiający tworzenie obiektów User
    public User(String login, String haslo) {
        this.login = login;
        this.haslo = haslo;
    }
    // Metoda pobierająca id użytkownika
    public Integer getId() {
        return id;
    }
    // Metoda ustawiająca id użytkownika
    public void setId(Integer id) {
        this.id = id;
    }
    // Metoda pobierająca login użytkownika
    public String getLogin() {
        return login;
    }
    // Metoda ustawiająca login użytkownika
    public void setLogin(String login) {
        this.login = login;
    }
    // Metoda pobierająca hasło użytkownika
    public String getHaslo() {
        return haslo;
    }
    // Metoda ustawiająca hasło użytkownika
    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
    // Metoda pobierająca id danych użytkownika
    public Integer getDaneUserId() {
        return daneUserId;
    }
    // Metoda ustawiająca id danych użytkownika
    public void setDaneUserId(Integer daneUserId) {
        this.daneUserId = daneUserId;
    }
    public Double getAverageRating() {
        return averageRating;
    }
    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }
    
}

