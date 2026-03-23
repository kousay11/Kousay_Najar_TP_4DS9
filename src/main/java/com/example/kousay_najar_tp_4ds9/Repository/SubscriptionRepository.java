package com.example.kousay_najar_tp_4ds9.Repository;

import com.example.kousay_najar_tp_4ds9.Entity.Subscription;
import com.example.kousay_najar_tp_4ds9.Entity.TypeSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Set<Subscription> findByTypeSubOrderByStartDateAsc(TypeSubscription type);
    List<Subscription> findByStartDateBetween(LocalDate startDate, LocalDate endDate);

}
