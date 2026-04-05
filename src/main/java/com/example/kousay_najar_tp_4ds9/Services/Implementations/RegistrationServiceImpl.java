package com.example.kousay_najar_tp_4ds9.Services.Implementations;

import com.example.kousay_najar_tp_4ds9.Entity.Course;
import com.example.kousay_najar_tp_4ds9.Entity.Registration;
import com.example.kousay_najar_tp_4ds9.Entity.Skier;
import com.example.kousay_najar_tp_4ds9.Repository.CourseRepository;
import com.example.kousay_najar_tp_4ds9.Repository.RegistrationRepository;
import com.example.kousay_najar_tp_4ds9.Repository.SkierRepository;
import com.example.kousay_najar_tp_4ds9.Services.Interfaces.IRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements IRegistrationService {

    private final RegistrationRepository registrationRepository;
    private final SkierRepository skierRepository;
    private final CourseRepository courseRepository;

    @Override
    public Registration addRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Registration updateRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }

    @Override
    public Registration getRegistration(Long id) {
        return registrationRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Registration avec id " + id + " introuvable"));
    }

    @Override
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    @Override
    public Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkier) {
        // .orElse(null)
        Skier skier = skierRepository.findById(numSkier)
                .orElseThrow(() -> new RuntimeException("Skier not found"));

        registration.setSkier(skier);

        return registrationRepository.save(registration);
    }

    @Override
    public Registration assignRegistrationToCourse(Long numRegistration, Long numCourse) {
        Registration registration = registrationRepository.findById(numRegistration)
                .orElseThrow(() -> new RuntimeException("Registration not found"));

        Course course = courseRepository.findById(numCourse)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        registration.setCourse(course); // registration est la classe prioritaire

        return registrationRepository.save(registration);
    }

    @Override
    public Registration addRegistrationAndAssignToSkierAndCourse(Registration registration, Long numSkier, Long numCourse) {
        Skier skier = skierRepository.findById(numSkier)
                .orElseThrow(() -> new RuntimeException("Skier not found"));

        Course course = courseRepository.findById(numCourse)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        long count = registrationRepository.countByCourse(course);

        if ((course.getTypeCourse().name().contains("COLLECTIVE")) && count >= 6) {
            throw new RuntimeException("Course full");
        }

        int age = java.time.LocalDate.now().getYear() - skier.getDateOfBirth().getYear();

        if (course.getTypeCourse().name().contains("CHILDREN") && age > 12) {
            throw new RuntimeException("Age not allowed");
        }

        registration.setSkier(skier);
        registration.setCourse(course);

        return registrationRepository.save(registration);
    }

}