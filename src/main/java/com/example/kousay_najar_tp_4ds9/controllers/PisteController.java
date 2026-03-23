package com.example.kousay_najar_tp_4ds9.controllers;

import com.example.kousay_najar_tp_4ds9.Entity.Piste;
import com.example.kousay_najar_tp_4ds9.Services.Interfaces.IPisteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/piste")
@AllArgsConstructor
public class PisteController {
    private final IPisteService pisteService;

    @PostMapping("/addPiste")
    public Piste addPiste(@RequestBody Piste piste) {
        return pisteService.addPiste(piste);
    }

    @PostMapping("/updatePiste")
    public Piste updatePiste(@RequestBody Piste piste) {
        return pisteService.updatePiste(piste);
    }

    @DeleteMapping("/deletePiste/{id}")
    public void deletePiste(@PathVariable Long id) {
        pisteService.deletePiste(id);
    }

    @GetMapping("/getPiste/{id}")
    public Piste getPiste(@PathVariable Long id) {
        return pisteService.getPiste(id);
    }

    @GetMapping("/getPistes")
    public List<Piste> getAllPistes() {
        return pisteService.getAllPistes();
    }
}

