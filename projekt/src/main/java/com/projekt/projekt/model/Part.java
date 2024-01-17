package com.projekt.projekt.model;

import java.util.List;

import com.projekt.projekt.Utils.ImageUtils;

import jakarta.persistence.*;

@Entity
@Table(name = "ogloszenie")
public class Part {

    // Identyfikator części
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    // Tytuł części
    @Column(name = "tytul")
    private String title;
    // Opis części
    @Column(name = "opis")
    private String description;
    // Powiązanie z użytkownikiem - właścicielem części
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    // Powiązanie z modelem części
    @ManyToOne
    @JoinColumn(name = "id_modelu")
    private Model model;
    // Rok produkcji samochodu, do którego pasuje część
    @Column(name = "rok_produkcji_samochodu")
    private Integer carProductionYear;
    // Producent części
    @Column(name = "producent")
    private String manufacturer;
    // Cena części
    @Column(name = "cena")
    private Integer price;
     // Ilość dostępnych sztuk danej części
    @Column(name = "ilosc")
    private Integer quantity;
    // Lista zdjęć części
    @OneToMany(mappedBy = "part", cascade = CascadeType.ALL)
    private List<Zdjecie> zdjecia;
    // Pole przechowujące obraz w formacie Base64
    @Transient
    private String base64Image;

    @Column(name = "is_archived")
    private Boolean isArchived;

    // Getter and setter for isArchived
    public Boolean getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(Boolean isArchived) {
        this.isArchived = isArchived;
    }

    // Metoda pobierająca obraz w formie Base64
    public String getBase64Image() {
        return base64Image;
    }
    // Metoda ustawiająca obraz w formie Base64
    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
    // Metoda zwracająca pierwsze zdjęcie w formie Base64
    @Transient
    public String getFirstImageBase64() {
        if (zdjecia != null && !zdjecia.isEmpty()) {
            return ImageUtils.encodeByteArrayToBase64(zdjecia.get(0).getZdjecie());
        }
        return null;
    }
    
     // Metody dostępowe do pól obiektu

    public List<Zdjecie> getZdjecia() {
        return zdjecia;
    }

    public void setZdjecia(List<Zdjecie> zdjecia) {
        this.zdjecia = zdjecia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Integer getCarProductionYear() {
        return carProductionYear;
    }

    public void setCarProductionYear(Integer carProductionYear) {
        this.carProductionYear = carProductionYear;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
