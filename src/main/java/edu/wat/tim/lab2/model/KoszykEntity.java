package edu.wat.tim.lab2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="koszyk")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class KoszykEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nazwa_koszyka")
    private String nazwa_koszyka;

    @ManyToOne
    @JoinColumn(name="klient_id", nullable=false)
    @JsonIgnore
    private KlientEntity klientEntity;

    @OneToMany(mappedBy = "koszykEntity", cascade = CascadeType.MERGE)
    private List<ProduktWKoszykuEntity> produktWKoszykuEntities = new ArrayList<>();

//    public void dodajProduktDoKoszyka(ProduktEntity produkt, int ilosc) {
//        ProduktWKoszykuEntity produktWKoszyku = new ProduktWKoszykuEntity();
//        produktWKoszyku.setProduktEntity(produkt);
//        produktWKoszyku.setKoszykEntity(this);
//        produktWKoszykuEntities.add(produktWKoszyku);
//    }
}
