package com.example.kousay_najar_tp_4ds9.controllers;

import com.example.kousay_najar_tp_4ds9.Entity.Registration;
import com.example.kousay_najar_tp_4ds9.Services.Interfaces.IRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registration")
@AllArgsConstructor
public class RegistrationController {
    private final IRegistrationService registrationService;

    @PostMapping("/addRegistration")
    public Registration addRegistration(@RequestBody Registration registration) {
        return registrationService.addRegistration(registration);
    }

    @PostMapping("/updateRegistration")
    public Registration updateRegistration(@RequestBody Registration registration) {
        return registrationService.updateRegistration(registration);
    }

    @DeleteMapping("/deleteRegistration/{id}")
    public void deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
    }

    @GetMapping("/getRegistration/{id}")
    public Registration getRegistration(@PathVariable Long id) {
        return registrationService.getRegistration(id);
    }

    @GetMapping("/getRegistrations")
    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }
    @PostMapping("/addRegistrationAndAssignToSkier/{numSkier}")
    public Registration addRegistrationAndAssignToSkier(
            @RequestBody Registration registration,
            @PathVariable Long numSkier) {

        return registrationService.addRegistrationAndAssignToSkier(registration, numSkier);
    }

    @PutMapping("/assignRegistrationToCourse/{numRegistration}/{numCourse}")
    public Registration assignRegistrationToCourse(
            @PathVariable Long numRegistration,
            @PathVariable Long numCourse) {

        return registrationService.assignRegistrationToCourse(numRegistration, numCourse);
    }

    @PostMapping("/addFullRegistration/{numSkier}/{numCourse}")
    public Registration addRegistrationAndAssignToSkierAndCourse(@RequestBody Registration registration,
                                            @PathVariable Long numSkier,
                                            @PathVariable Long numCourse) {

        return registrationService.addRegistrationAndAssignToSkierAndCourse(registration, numSkier, numCourse);
    }
}

