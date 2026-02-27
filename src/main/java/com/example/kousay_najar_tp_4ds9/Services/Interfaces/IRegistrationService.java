package com.example.kousay_najar_tp_4ds9.Services.Interfaces;

import com.example.kousay_najar_tp_4ds9.Entity.Registration;

import java.util.List;

public interface IRegistrationService {
    Registration addRegistration(Registration registration);
    Registration updateRegistration(Registration registration);
    void deleteRegistration(Long id);
    Registration getRegistration(Long id);
    List<Registration> getAllRegistrations();
}
