package com.springelasticsearch.api;

import com.springelasticsearch.entity.Kisi;
import com.springelasticsearch.repository.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/kisi")
public class KisiController {

    private final KisiRepository kisiRepository;

    public KisiController(KisiRepository kisiRepository) {
        this.kisiRepository = kisiRepository;
    }

    @PostConstruct
    public void init(){
        System.out.println("Metod Calisiyor.");
        Kisi kis = new Kisi();
        kis.setAd("Serkan");
        kis.setSoyad("Polat");
        kis.setAdres("Okmeydani");
        kis.setDogumTarihi(Calendar.getInstance().getTime());
        kisiRepository.save(kis);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search){
    List<Kisi> k = kisiRepository.getByCustomQuery(search);
        return ResponseEntity.ok(k);

    }

}
