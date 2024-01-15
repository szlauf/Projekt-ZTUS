package com.projekt.projekt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "marka")
public class Marka {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nazwa_marki")
    private String nazwaMarki;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwaMarki() {
        return nazwaMarki;
    }

    public void setNazwaMarki(String nazwaMarki) {
        this.nazwaMarki = nazwaMarki;
    }

    


    
}
