package com.projekt.projekt.model;

import jakarta.persistence.*;

@Entity
@Table(name = "zdjecie")
public class Zdjecie {

    @Id
    @Column(name = "id")
    private Long id;

    @Lob
    @Column(name = "zdjecie", columnDefinition = "LONGBLOB")
    private byte[] zdjecie;

    @ManyToOne
    @JoinColumn(name = "id_ogloszenia")
    private Part part;

    // ... other methods ...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getZdjecie() {
        return zdjecie;
    }

    public void setZdjecie(byte[] zdjecie) {
        this.zdjecie = zdjecie;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }
}
