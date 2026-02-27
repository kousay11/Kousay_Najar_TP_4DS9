package com.example.kousay_najar_tp_4ds9.Repository;

import com.example.kousay_najar_tp_4ds9.Entity.Piste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PisteRepository extends JpaRepository<Piste, Long> {
}
