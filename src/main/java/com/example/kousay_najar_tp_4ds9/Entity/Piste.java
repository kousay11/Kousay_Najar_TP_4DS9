package com.example.kousay_najar_tp_4ds9.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;
import java.io.Serializable;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Piste implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numPiste;
    private String namePiste;

    @Enumerated(EnumType.STRING)
    private Color color;

    private int length;
    private int slope;

    @ManyToMany(mappedBy = "pistes") // Skier est le côté propriétaire
    private Set<Skier> skiers;
}