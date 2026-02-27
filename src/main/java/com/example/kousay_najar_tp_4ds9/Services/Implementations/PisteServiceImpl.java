package com.example.kousay_najar_tp_4ds9.Services.Implementations;

import com.example.kousay_najar_tp_4ds9.Entity.Piste;
import com.example.kousay_najar_tp_4ds9.Repository.PisteRepository;
import com.example.kousay_najar_tp_4ds9.Services.Interfaces.IPisteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PisteServiceImpl implements IPisteService {

    private final PisteRepository pisteRepository;

    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public void deletePiste(Long id) {
        pisteRepository.deleteById(id);
    }

    @Override
    public Piste getPiste(Long id) {
        return pisteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Piste avec id " + id + " introuvable"));
    }

    @Override
    public List<Piste> getAllPistes() {
        return pisteRepository.findAll();
    }
}
