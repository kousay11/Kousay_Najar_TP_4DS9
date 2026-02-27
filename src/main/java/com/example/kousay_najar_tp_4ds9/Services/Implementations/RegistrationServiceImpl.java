package com.example.kousay_najar_tp_4ds9.Services.Implementations;

import com.example.kousay_najar_tp_4ds9.Entity.Registration;
import com.example.kousay_najar_tp_4ds9.Repository.RegistrationRepository;
import com.example.kousay_najar_tp_4ds9.Services.Interfaces.IRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements IRegistrationService {

    private final RegistrationRepository registrationRepository;

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
}