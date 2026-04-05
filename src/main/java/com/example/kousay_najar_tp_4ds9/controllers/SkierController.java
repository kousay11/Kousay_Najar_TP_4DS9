package com.example.kousay_najar_tp_4ds9.controllers;

import com.example.kousay_najar_tp_4ds9.Entity.Skier;
import com.example.kousay_najar_tp_4ds9.Entity.TypeSubscription;
import com.example.kousay_najar_tp_4ds9.Services.Interfaces.ISkierService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Expose cette classe comme contrôleur REST (sérialisation JSON par défaut)
@RestController
// Définit le préfixe commun pour tous les endpoints de ce contrôleur
@RequestMapping("/api/skier")
// Lombok génère un constructeur avec tous les attributs requis (injection via final)
@AllArgsConstructor
public class SkierController {
    // Service métier injecté pour exécuter la logique liée aux skieurs
    private final ISkierService skierService;

    // Crée un skieur avec son abonnement associé
    @PostMapping("/addSkier")
    public Skier addSkier(@RequestBody Skier skier) {
        return skierService.addSkier(skier);
    }

    // Met à jour les informations d'un skieur existant
    @PostMapping("/updateSkier")
    public Skier updateSkier(@RequestBody Skier skier) {
        return skierService.updateSkier(skier);
    }

    // Supprime un skieur et son abonnement
    @DeleteMapping("/deleteSkier/{id}")
    public void deleteSkier(@PathVariable Long id) {
        skierService.deleteSkier(id);
    }

    // Récupère un skieur par identifiant
    @GetMapping("/getSkier/{id}")
    public Skier getSkier(@PathVariable Long id) {
        return skierService.getSkier(id);
    }

    // Liste tous les skieurs
    @GetMapping("/getSkiers")
    public List<Skier> getAllSkiers() {
        return skierService.getAllSkiers();
    }

    // Associe un skieur à une piste donnée
    @PutMapping("/assignSkierToPiste/{numSkier}/{numPiste}")
    public Skier assignSkierToPiste(@PathVariable Long numSkier,
                                   @PathVariable Long numPiste) {

        return skierService.assignSkierToPiste(numSkier, numPiste);
    }

    // Ajoute un skieur puis l'inscrit à un cours donné
    @PostMapping("/addSkierAndAssignToCourse/{numCourse}")
    public Skier addSkierAndAssignToCourse(
            @RequestBody Skier skier,
            @PathVariable Long numCourse) {

        return skierService.addSkierAndAssignToCourse(skier, numCourse);
    }

    // Filtre les skieurs par type d'abonnement
    @GetMapping("/SkierbySubscription/{type}")
    public List<Skier> getSkiersBySubscriptionType(@PathVariable TypeSubscription type) {
        return skierService.retrieveSkiersBySubscriptionType(type);
    }
}
