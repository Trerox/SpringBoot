package edu.wat.tim.lab2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="produkt")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class ProduktEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nazwa_produktu")
    private String nazwaProduktu;

    @Column(name = "Jednostka_miary")
    private String jednostka_miary;

    @Column(name = "Opis")
    private String opis;

    @OneToMany(mappedBy = "produkt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<KomentarzEntity> komentarze = new ArrayList<>();


}
