package com.example.kousay_najar_tp_4ds9.Repository;

import com.example.kousay_najar_tp_4ds9.Entity.Skier;
import com.example.kousay_najar_tp_4ds9.Entity.TypeSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkierRepository extends JpaRepository<Skier, Long> {
    List<Skier> findBySubscription_TypeSub(TypeSubscription type);

}
