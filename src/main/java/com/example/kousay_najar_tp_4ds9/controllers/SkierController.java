package com.example.kousay_najar_tp_4ds9.controllers;

import com.example.kousay_najar_tp_4ds9.Entity.Skier;
import com.example.kousay_najar_tp_4ds9.Entity.TypeSubscription;
import com.example.kousay_najar_tp_4ds9.Services.Interfaces.ISkierService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skier")
@AllArgsConstructor
public class SkierController {
    private final ISkierService skierService;

    @PostMapping("/addSkier")
    public Skier addSkier(@RequestBody Skier skier) {
        return skierService.addSkier(skier);
    }

    @PostMapping("/updateSkier")
    public Skier updateSkier(@RequestBody Skier skier) {
        return skierService.updateSkier(skier);
    }

    @DeleteMapping("/deleteSkier/{id}")
    public void deleteSkier(@PathVariable Long id) {
        skierService.deleteSkier(id);
    }

    @GetMapping("/getSkier/{id}")
    public Skier getSkier(@PathVariable Long id) {
        return skierService.getSkier(id);
    }

    @GetMapping("/getSkiers")
    public List<Skier> getAllSkiers() {
        return skierService.getAllSkiers();
    }
    @PutMapping("/assignSkierToPiste/{numSkier}/{numPiste}")
    public void assignSkierToPiste(@PathVariable Long numSkier,
                                   @PathVariable Long numPiste) {

        skierService.assignSkierToPiste(numSkier, numPiste);
    }
    @PostMapping("/addSkierAndAssignToCourse/{numCourse}")
    public Skier addSkierAndAssignToCourse(
            @RequestBody Skier skier,
            @PathVariable Long numCourse) {

        return skierService.addSkierAndAssignToCourse(skier, numCourse);
    }

    @GetMapping("/SkierbySubscription/{type}")
    public List<Skier> getSkiersBySubscriptionType(@PathVariable TypeSubscription type) {
        return skierService.retrieveSkiersBySubscriptionType(type);
    }
}

