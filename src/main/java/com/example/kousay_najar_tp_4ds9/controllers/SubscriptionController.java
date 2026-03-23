package com.example.kousay_najar_tp_4ds9.controllers;

import com.example.kousay_najar_tp_4ds9.Entity.Subscription;
import com.example.kousay_najar_tp_4ds9.Entity.TypeSubscription;
import com.example.kousay_najar_tp_4ds9.Services.Interfaces.ISubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/subscription")
@AllArgsConstructor
public class SubscriptionController {
    private final ISubscriptionService subscriptionService;

    @PostMapping("/addSubscription")
    public Subscription addSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.addSubscription(subscription);
    }

    @PostMapping("/updateSubscription")
    public Subscription updateSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.updateSubscription(subscription);
    }

    @DeleteMapping("/deleteSubscription/{id}")
    public void deleteSubscription(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
    }

    @GetMapping("/getSubscription/{id}")
    public Subscription getSubscription(@PathVariable Long id) {
        return subscriptionService.getSubscription(id);
    }

    @GetMapping("/getSubscriptions")
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    @GetMapping("/byType/{type}")
    public Set<Subscription> getSubscriptionByType(@PathVariable TypeSubscription type) {
        return subscriptionService.getSubscriptionByType(type);
    }

    @GetMapping("/byDates")
    public List<Subscription> getSubscriptionsByDates(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {

        return subscriptionService.retrieveSubscriptionsByDates(startDate, endDate);
    }
}

