package edu.wat.tim.lab2.service;

import edu.wat.tim.lab2.model.*;
import edu.wat.tim.lab2.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SampleService {

    private final KlientEntityRepository klientEntityRepository;
    private final KoszykEntityRepository koszykEntityRepository;
    private final ProduktEntityRepository produktEntityRepository;
    private final ProduktWKoszykuEntityRepository produktWKoszykuEntityRepository;
    private final KomentarzEntityRepository komentarzEntityRepository;


    public KlientEntity addKlient(KlientEntity klient) {
        return klientEntityRepository.save(klient);
    }

    public KoszykEntity addKoszyk(KoszykEntity koszyk, Long klientId) {
        KlientEntity klient = klientEntityRepository.findById(klientId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono klienta o id " + klientId));

        koszyk.setKlientEntity(klient);
        return koszykEntityRepository.save(koszyk);
    }
    public void addProduktToKoszyk(String nazwaProduktu, int liczbaProduktow, Long koszykId) {
        KoszykEntity koszyk = koszykEntityRepository.findById(koszykId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono koszyka o id " + koszykId));

        List<ProduktEntity> produkty = produktEntityRepository.findByNazwaProduktu(nazwaProduktu);
        if (produkty.isEmpty()) {
            throw new RuntimeException("Nie znaleziono produktu o nazwie " + nazwaProduktu);
        }

        for (int i = 0; i < liczbaProduktow; i++) {
            ProduktEntity produkt = produkty.get(i % produkty.size());
            ProduktWKoszykuEntity produktWKoszyku = new ProduktWKoszykuEntity();
            produktWKoszyku.setKoszykEntity(koszyk);
            produktWKoszyku.setProduktEntity(produkt);
            produktWKoszykuEntityRepository.save(produktWKoszyku);
        }
    }

    public void removeProduktFromKoszyk(Long produktWKoszykId) {
        ProduktWKoszykuEntity produktWKoszyku = produktWKoszykuEntityRepository.findById(produktWKoszykId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono produktu w koszyku o id " + produktWKoszykId));

        produktWKoszykuEntityRepository.delete(produktWKoszyku);
    }
    public ProduktEntity addProdukt(ProduktEntity produkt) {
        return produktEntityRepository.save(produkt);
    }

    public KomentarzEntity addKomentarzToProdukt(String nazwaKlienta, Long produktId, String tresc) {
        ProduktEntity produkt = produktEntityRepository.findById(produktId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono produktu o id " + produktId));

        KomentarzEntity komentarz = new KomentarzEntity();
        komentarz.setProdukt(produkt);
        komentarz.setAutor(nazwaKlienta);
        komentarz.setTresc(tresc);
        return komentarzEntityRepository.save(komentarz);
    }
    public List<KlientEntity> getAllKlienci() {
        return klientEntityRepository.findAll();
    }

    public KlientEntity getKlientById(Long id) {
        return klientEntityRepository.findById(id).orElse(null);
    }

    public List<ProduktEntity> getAllProdukty() {
        return produktEntityRepository.findAll();
    }

    public ProduktEntity getProduktById(Long id) {
        return produktEntityRepository.findById(id).orElse(null);
    }

    public List<KoszykEntity> getAllKoszyki() {
        return koszykEntityRepository.findAll();
    }

    public KoszykEntity getKoszykById(Long id) {
        return koszykEntityRepository.findById(id).orElse(null);
    }

    public List<ProduktWKoszykuEntity> getAllProduktyWKoszyku() {
        return produktWKoszykuEntityRepository.findAll();
    }

    public ProduktWKoszykuEntity getProduktWKoszykuById(Long id) {
        return produktWKoszykuEntityRepository.findById(id).orElse(null);
    }

    // Dodatkowe metody do zarządzania klientami, koszykami, produktami, itp.

}
