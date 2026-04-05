package com.example.kousay_najar_tp_4ds9.Services.Interfaces;

import com.example.kousay_najar_tp_4ds9.Entity.Skier;
import com.example.kousay_najar_tp_4ds9.Entity.TypeSubscription;

import java.util.List;

public interface ISkierService {
    Skier addSkier(Skier skier);
    Skier updateSkier(Skier skier);
    void deleteSkier(Long id);
    Skier getSkier(Long id);
    List<Skier> getAllSkiers();

    Skier assignSkierToPiste(Long numSkier, Long numPiste);
    Skier addSkierAndAssignToCourse(Skier skier, Long numCourse);
    List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription type);

}
