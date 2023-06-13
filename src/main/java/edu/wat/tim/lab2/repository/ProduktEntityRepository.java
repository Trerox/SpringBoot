package edu.wat.tim.lab2.repository;


import edu.wat.tim.lab2.model.KomentarzEntity;
import edu.wat.tim.lab2.model.ProduktEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduktEntityRepository extends JpaRepository<ProduktEntity, Long> {
    List<ProduktEntity> findByNazwaProduktu(String nazwaProduktu);


}