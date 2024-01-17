package com.projekt.projekt.model;
// Importowanie adnotacji z pakietu jakarta.persistence
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// Deklaracja klasy encji o nazwie "Marka"
@Entity
// Adnotacja określająca nazwę tabeli w bazie danych
@Table(name = "marka")
public class Marka {
    // Adnotacja oznaczająca, że to pole jest kluczem głównym
    @Id
    // Adnotacja określająca nazwę kolumny w bazie danych
    @Column(name = "id")
    private Integer id;
    // Adnotacja określająca nazwę kolumny w bazie danych
    @Column(name = "nazwa_marki")
    private String nazwaMarki;

    // Metoda zwracająca wartość pola "id"
    public Integer getId() {
        return id;
    }
    // Metoda ustawiająca wartość pola "id"
    public void setId(Integer id) {
        this.id = id;
    }
    // Metoda zwracająca wartość pola "nazwaMarki"
    public String getNazwaMarki() {
        return nazwaMarki;
    }
    // Metoda ustawiająca wartość pola "nazwaMarki"
    public void setNazwaMarki(String nazwaMarki) {
        this.nazwaMarki = nazwaMarki;
    }

    


    
}
