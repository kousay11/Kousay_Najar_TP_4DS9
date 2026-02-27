package com.example.kousay_najar_tp_4ds9.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Set;
import java.io.Serializable;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Instructor implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long numInstructor;
        private String firstName;
        private String lastName;
        private LocalDate dateOfHire;

        @OneToMany(cascade = CascadeType.ALL) // Relation 1-* unidirectionnelle
        private Set<Course> courses;
}