package com.projekt.projekt.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "koszyk")
public class Cart {

    @Id
    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "id_produkty")
    private Integer idProdukty;

    @ManyToMany
    @JoinTable(
        name = "koszyk_ogloszenie",
        joinColumns = @JoinColumn(name = "koszyk_id_produkty", referencedColumnName = "id_produkty"),
        inverseJoinColumns = @JoinColumn(name = "ogloszenie_id", referencedColumnName = "id")
    )
    private List<Part> part;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public List<Part> getPart() {
        return part;
    }

    public void setPart(List<Part> part) {
        this.part = part;
    }

    public Integer getIdProdukty() {
        return idProdukty;
    }

    public void setIdProdukty(Integer idProdukty) {
        this.idProdukty = idProdukty;
    } 
    

}
