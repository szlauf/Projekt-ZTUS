package com.projekt.projekt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Klasa reprezentująca encję "dane_user" w bazie danych.
 */
@Entity
@Table(name = "dane_user")
public class DaneUser {

    // Identyfikator encji w bazie danych
    @Id
    @Column(name = "dane_user_id")
    private Integer daneUserId;
    // Imię użytkownika
    @Column(name = "imie")
    private String imie;
    // Nazwisko użytkownika
    @Column(name = "nazwisko")
    private String nazwisko;
    // Numer telefonu użytkownika
    @Column(name = "nr_telefonu")
    private Integer nrTelefonu;
    // Miasto zamieszkania użytkownika
    @Column(name = "miasto")
    private String miasto;
    // Kod pocztowy użytkownika
    @Column(name = "kod_pocztowy")
    private String kodPocztowy;
    // Ulica zamieszkania użytkownika
    @Column(name = "ulica")
    private String ulica;
    // Numer mieszkania użytkownika
    @Column(name = "nr_mieszkania")
    private String nrMieszkania;
    // Adres email użytkownika
    @Column(name = "email")
    private String email;
    public Integer getDaneUserId() {
        return daneUserId;
    }

    // Konstruktor domyślny
    public DaneUser() {
    
    }

    // Konstruktor parametrowy
    public DaneUser(Integer daneUserId, String imie, String nazwisko, Integer nrTelefonu, String miasto,
            String kodPocztowy, String ulica, String nrMieszkania, String email) {
        this.daneUserId = daneUserId;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrTelefonu = nrTelefonu;
        this.miasto = miasto;
        this.kodPocztowy = kodPocztowy;
        this.ulica = ulica;
        this.nrMieszkania = nrMieszkania;
        this.email = email;
    }

    // Metody dostępowe do pól obiektu

    public void setDaneUserId(Integer daneUserId) {
        this.daneUserId = daneUserId;
    }
    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    public Integer getNrTelefonu() {
        return nrTelefonu;
    }
    public void setNrTelefonu(Integer nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }
    public String getMiasto() {
        return miasto;
    }
    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }
    public String getKodPocztowy() {
        return kodPocztowy;
    }
    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }
    public String getUlica() {
        return ulica;
    }
    public void setUlica(String ulica) {
        this.ulica = ulica;
    }
    public String getNrMieszkania() {
        return nrMieszkania;
    }
    public void setNrMieszkania(String nrMieszkania) {
        this.nrMieszkania = nrMieszkania;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
