package com.example.kousay_najar_tp_4ds9.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Set;
import java.io.Serializable;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Skier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkier;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String city;

    @OneToOne(cascade = CascadeType.ALL) // Relation 1-1 avec Subscription
    private Subscription subscription;

    @OneToMany(mappedBy = "skier", cascade = {CascadeType.PERSIST,CascadeType.REMOVE}) // Relation 1-* avec Registration
    private Set<Registration> registrations;

    @ManyToMany // Relation *-* avec Piste
    private Set<Piste> pistes;
}