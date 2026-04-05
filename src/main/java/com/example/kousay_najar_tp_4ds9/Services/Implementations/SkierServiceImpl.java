package com.example.kousay_najar_tp_4ds9.Services.Implementations;

import com.example.kousay_najar_tp_4ds9.Entity.*;
import com.example.kousay_najar_tp_4ds9.Repository.CourseRepository;
import com.example.kousay_najar_tp_4ds9.Repository.PisteRepository;
import com.example.kousay_najar_tp_4ds9.Repository.RegistrationRepository;
import com.example.kousay_najar_tp_4ds9.Repository.SkierRepository;
import com.example.kousay_najar_tp_4ds9.Services.Interfaces.ISkierService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class SkierServiceImpl implements ISkierService {

    private final SkierRepository skierRepository;
    private  final PisteRepository pisteRepository;
    private final CourseRepository courseRepository;
    private final RegistrationRepository registrationRepository;

    @Override
    public Skier addSkier(Skier skier) {
        if (skier.getSubscription() == null) {
            throw new IllegalArgumentException("La subscription doit etre fournie lors de l'ajout du skier");
        }
        return skierRepository.save(skier);
    }

    @Override
    public Skier updateSkier(Skier skier) {
        return skierRepository.save(skier);
    }

    @Override
    public void deleteSkier(Long id) {
        skierRepository.deleteById(id);
    }

    @Override
    public Skier getSkier(Long id) {
        return skierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skier avec id " + id + " introuvable"));
    }

    @Override
    public List<Skier> getAllSkiers() {
        return skierRepository.findAll();
    }

    @Override
    public Skier assignSkierToPiste(Long numSkier, Long numPiste) {
        Skier skier = skierRepository.findById(numSkier).get();
        Piste piste = pisteRepository.findById(numPiste)
                .orElseThrow(() -> new RuntimeException("Piste not found"));
        Set<Piste> pisteMiseAjour = skier.getPistes();
        if(pisteMiseAjour == null)
        {
            pisteMiseAjour = new HashSet<>();
        }
        /*
        try{
           skier.getPistes().add(piste);}
           catch(NullPointerException ex) si pas private Set<Piste> pistes = new HashSet<>(); dans skier
          {
             System.out.println("La liste des pistes du skier est null, création d'une nouvelle liste");
             pisteMiseAjour = new HashSet<>();
             pisteMiseAjour.add(piste);
             skier.setPistes(pisteMiseAjour)
           }
         */

        pisteMiseAjour.add(piste);
        skier.setPistes(pisteMiseAjour);//skier.getPistes() = pisteMiseAjour;
        // cas d'initialisation si private Set<Piste> pistes = new HashSet<>(); dans skier
        //skier.getPistes().add(piste);

       return  skierRepository.save(skier);
    }
    /** addSkierAndAssignToCourse(skier, numCourse)
         ↓
     1. Trouver le Course par numCourse
         ↓
     2. Sauvegarder Skier + Subscription (auto cascade)
         ↓
     3. Créer Registration + lier Skier + lier Course
         ↓
     4. Sauvegarder Registration
         ↓
     5. Retourner le Skier sauvegardé
     */
    @Override
    public Skier addSkierAndAssignToCourse(Skier skier, Long numCourse) {
        Course course = courseRepository.findById(numCourse)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // save skier (subscription auto grâce au cascade)
        Skier savedSkier = skierRepository.save(skier);

        // créer registration
        Registration registration = new Registration();
        registration.setNumWeek(1);
        registration.setSkier(savedSkier);
        registration.setCourse(course);

        registrationRepository.save(registration);

        return savedSkier;
    }

    @Override
    public List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription type) {
        return skierRepository.findBySubscription_TypeSub(type);
    }
}
