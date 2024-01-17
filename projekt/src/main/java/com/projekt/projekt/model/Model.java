package com.projekt.projekt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
// Klasa reprezentująca encję "model" w bazie danych
@Entity
@Table(name = "model")
public class Model {
    // Identyfikator modelu, generowany automatycznie
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    // Nazwa modelu
    @Column(name = "nazwa_modelu")
    private String nazwaModelu;
    // Generacja modelu
    @Column(name = "generacja")
    private String generacja;

    // Relacja wiele do jednego z encją "marka" - jeden model należy do jednej marki
    @ManyToOne
    @JoinColumn(name = "id_marki", referencedColumnName = "id")
    private Marka marka;
 
    // Metoda zwracająca identyfikator modelu
    public Integer getId() {
        return id;
    }
    // Metoda ustawiająca identyfikator modelu
    public void setId(Integer id) {
        this.id = id;
    }
    // Metoda zwracająca nazwę modelu
    public String getNazwaModelu() {
        return nazwaModelu;
    }
    // Metoda ustawiająca nazwę modelu
    public void setNazwaModelu(String nazwaModelu) {
        this.nazwaModelu = nazwaModelu;
    }
    // Metoda zwracająca generację modelu
    public String getGeneracja() {
        return generacja;
    }
    // Metoda ustawiająca generację modelu
    public void setGeneracja(String generacja) {
        this.generacja = generacja;
    }
    // Metoda zwracająca obiekt encji "marka" do której przypisany jest model
    public Marka getMarka() {
        return marka;
    }
    // Metoda ustawiająca obiekt encji "marka" do której przypisany jest model
    public void setMarka(Marka marka) {
        this.marka = marka;
    }
    
}
