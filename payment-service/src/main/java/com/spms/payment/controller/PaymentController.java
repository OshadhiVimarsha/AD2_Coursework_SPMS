package com.spms.payment.controller;

import com.spms.payment.entity.Payment;
import com.spms.payment.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @GetMapping("/getAll")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public List<Payment> getPaymentsByUserId(@PathVariable String userId) {
        return paymentService.getPaymentsByUserId(userId);
    }

    @GetMapping("/parking-space/{parkingSpaceId}")
    public List<Payment> getPaymentsByParkingSpaceId(@PathVariable Long parkingSpaceId) {
        return paymentService.getPaymentsByParkingSpaceId(parkingSpaceId);
    }

    @PostMapping("/save")
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    @PostMapping("/{id}/process")
    public ResponseEntity<Payment> processPayment(@PathVariable Long id) {
        Payment processed = paymentService.processPayment(id);
        return processed != null ? ResponseEntity.ok(processed) : ResponseEntity.notFound().build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Payment> updatePayment(
            @PathVariable Long id,
            @RequestBody Payment payment) {
        Payment updated = paymentService.updatePayment(id, payment);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable Long id) {
        boolean deleted = paymentService.deletePayment(id);
        return deleted
                ? ResponseEntity.ok("Delete successful")
                : ResponseEntity.notFound().build();
    }

} 