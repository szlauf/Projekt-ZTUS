package com.projekt.projekt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dane_user")
public class DaneUser {
    @Id
    @Column(name = "dane_user_id")
    private Integer daneUserId;
    @Column(name = "imie")
    private String imie;
    @Column(name = "nazwisko")
    private String nazwisko;
    @Column(name = "nr_telefonu")
    private Integer nrTelefonu;
    @Column(name = "miasto")
    private String miasto;
    @Column(name = "kod_pocztowy")
    private String kodPocztowy;
    @Column(name = "ulica")
    private String ulica;
    @Column(name = "nr_mieszkania")
    private String nrMieszkania;
    @Column(name = "email")
    private String email;
    public Integer getDaneUserId() {
        return daneUserId;
    }

    

    public DaneUser() {
        
    }



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
