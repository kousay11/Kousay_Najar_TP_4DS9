package com.example.kousay_najar_tp_4ds9.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;
import java.io.Serializable;

/**
 * Entité représentant un cours proposé par la station de ski.
 * Implémente Serializable pour permettre le transport et la mise en cache des données.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numCourse; // Identifiant unique (Clé Primaire) auto-incrémenté

    private int level; // Niveau requis pour le cours (ex: 1, 2, 3)

    @Enumerated(EnumType.STRING)
    private TypeCourse typeCourse; // Type de cours : Collectif Enfant, Adulte ou Individuel (Stocké en texte en BD)

    @Enumerated(EnumType.STRING)
    private Support support; // Support utilisé : SKI ou SNOWBOARD (Stocké en texte en BD)

    private Float price; // Prix du cours

    private int timeSlot; // Créneau horaire du cours (ex: matin, après-midi)

    /**
     * Relation One-To-Many avec Registration.
     * Un cours peut avoir plusieurs inscriptions (registrations).
     * 'mappedBy = "course"' indique que le champ 'course' dans la classe Registration
     * est le propriétaire de la relation (celui qui contient la clé étrangère).
     */
    @OneToMany(mappedBy = "course")
    private Set<Registration> registrations;

    /**
     * Note sur la relation Instructor/Course :
     * Ce champ est commenté car, selon le diagramme UML, la relation est UNIDIRECTIONNELLE
     * partant de l'Instructeur vers le Cours.
     * Le Cours n'a donc pas besoin de connaître son Instructeur dans son propre code.
     * C'est l'Instructeur qui gère ses cours via une table d'association générée par JPA.
     */
    // @ManyToOne
    // private Instructor instructor;
}