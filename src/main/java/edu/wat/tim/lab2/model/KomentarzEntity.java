package edu.wat.tim.lab2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="komentarz")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class KomentarzEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Autor")
    private String autor;
    @Column(name = "Tresc")
    private String tresc;

    @ManyToOne
    @JoinColumn(name = "produkt_id")
    private ProduktEntity produkt;

    // konstruktory, gettery, settery
}

