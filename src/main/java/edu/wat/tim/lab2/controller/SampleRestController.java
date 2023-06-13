package edu.wat.tim.lab2.controller;

import edu.wat.tim.lab2.model.KlientEntity;
import edu.wat.tim.lab2.model.KomentarzEntity;
import edu.wat.tim.lab2.model.KoszykEntity;
import edu.wat.tim.lab2.model.ProduktEntity;
import edu.wat.tim.lab2.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SampleRestController {

    private final SampleService sampleService;

    @GetMapping("/klienci")
    public List<KlientEntity> getAllKlienci() {
        return sampleService.getAllKlienci();
    }

    @GetMapping("/klienci/{id}")
    public KlientEntity getKlientById(@PathVariable Long id) {
        return sampleService.getKlientById(id);
    }

    @PostMapping("/klienci")
    public KlientEntity addKlient(@RequestBody KlientEntity klient) {
        return sampleService.addKlient(klient);
    }

    @PostMapping("/klienci/{klientId}/koszyki")
    public KoszykEntity addKoszyk(@PathVariable Long klientId, @RequestBody KoszykEntity koszyk) {
        return sampleService.addKoszyk(koszyk, klientId);
    }

    @PostMapping("/koszyki/{koszykId}/produkty")
    public void addProduktToKoszyk(
            @PathVariable Long koszykId,
            @RequestParam String nazwaProduktu,
            @RequestParam int liczbaProduktow) {
        sampleService.addProduktToKoszyk(nazwaProduktu, liczbaProduktow, koszykId);
    }
    @DeleteMapping("/koszyki/{koszykId}/produkty/{produktWKoszykId}")
    public void removeProduktFromKoszyk(@PathVariable Long koszykId, @PathVariable Long produktWKoszykId) {
        sampleService.removeProduktFromKoszyk(produktWKoszykId);
    }
    @PostMapping("/produkty/{produktId}/komentarze")
    public ResponseEntity<KomentarzEntity> dodajKomentarzDoProduktu(
            @PathVariable Long produktId,
            @RequestParam String nazwaKlienta,
            @RequestParam String tresc) {

        KomentarzEntity nowyKomentarz = sampleService.addKomentarzToProdukt(nazwaKlienta, produktId, tresc);
        return ResponseEntity.ok(nowyKomentarz);
    }




    @PostMapping("/produkty")
    public ProduktEntity addProdukt(@RequestBody ProduktEntity produkt) {
        return sampleService.addProdukt(produkt);
    }
    // Endpointy do obsługi koszyków, produktów itp.

}
