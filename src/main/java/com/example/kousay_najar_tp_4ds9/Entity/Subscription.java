package com.example.kousay_najar_tp_4ds9.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.io.Serializable;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Subscription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSub;
    private LocalDate startDate;
    private LocalDate endDate;
    private Float price;

    @Enumerated(EnumType.STRING)
    private TypeSubscription typeSub;
}