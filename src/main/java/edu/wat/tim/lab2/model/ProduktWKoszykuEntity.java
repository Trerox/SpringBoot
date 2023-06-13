package edu.wat.tim.lab2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="produktwkoszyku")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProduktWKoszykuEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produkt_id")
    @JsonIgnore
    private ProduktEntity produktEntity;

    @ManyToOne
    @JoinColumn(name ="koszyk_id")
    @JsonIgnore
    private KoszykEntity koszykEntity;

}
