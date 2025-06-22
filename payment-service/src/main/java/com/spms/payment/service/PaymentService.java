package com.spms.payment.service;

import com.spms.payment.entity.Payment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentService {
    List<Payment> getAllPayments();

    Optional<Payment> getPaymentById(Long id);

    List<Payment> getPaymentsByUserId(String userId);

    List<Payment> getPaymentsByParkingSpaceId(Long parkingSpaceId);

    Payment createPayment(Payment payment);

    Payment processPayment(Long id);

    Payment updatePayment(Long id, Payment payment);

    boolean deletePayment(Long id);
}
