package com.projekt.projekt.model;
// Importy związane z obsługą JPA (Java Persistence API)
import jakarta.persistence.*;
// Deklaracja klasy encji, czyli obiektu mapowanego na tabelę w bazie danych
@Entity
// Deklaracja informacji o tabeli, z którą jest powiązana klasa
@Table(name = "zdjecie")
public class Zdjecie {
    // Deklaracja pola identyfikatora encji
    @Id
    // Deklaracja informacji o kolumnie w bazie danych, z którą jest powiązane pole
    @Column(name = "id")
    private Long id;

    // Deklaracja pola przechowującego obraz jako tablicę bajtów
    @Lob
    @Column(name = "zdjecie", columnDefinition = "LONGBLOB")
    private byte[] zdjecie;

    // Deklaracja relacji Many-to-One z inną encją (Part) poprzez klucz obcy (id_ogloszenia)
    @ManyToOne
    @JoinColumn(name = "id_ogloszenia")
    private Part part;

    // ... other methods ...

    // Metoda pobierająca wartość identyfikatora encji
    public Long getId() {
        return id;
    }
    // Metoda ustawiająca wartość identyfikatora encji
    public void setId(Long id) {
        this.id = id;
    }
    // Metoda pobierająca tablicę bajtów reprezentującą obraz
    public byte[] getZdjecie() {
        return zdjecie;
    }
    // Metoda ustawiająca tablicę bajtów reprezentującą obraz
    public void setZdjecie(byte[] zdjecie) {
        this.zdjecie = zdjecie;
    }
    // Metoda pobierająca powiązaną encję Part
    public Part getPart() {
        return part;
    }
    // Metoda ustawiająca powiązaną encję Part
    public void setPart(Part part) {
        this.part = part;
    }
}
