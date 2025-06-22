package com.spms.payment.service.impl;

import com.spms.payment.entity.Payment;
import com.spms.payment.repository.PaymentRepository;
import com.spms.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public List<Payment> getPaymentsByUserId(String userId) {
        return paymentRepository.findByUserId(userId);
    }

    public List<Payment> getPaymentsByParkingSpaceId(Long parkingSpaceId) {
        return paymentRepository.findByParkingSpaceId(parkingSpaceId);
    }

    public Payment createPayment(Payment payment) {
        payment.setTimestamp(LocalDateTime.now());
        payment.setStatus("PENDING");
        return paymentRepository.save(payment);
    }

    public Payment processPayment(Long id) {
        Optional<Payment> paymentOpt = paymentRepository.findById(id);
        if (paymentOpt.isPresent()) {
            Payment payment = paymentOpt.get();
            // Simulate payment processing
            if (Math.random() > 0.1) { // 90% success rate
                payment.setStatus("COMPLETED");
                payment.setReceiptNumber("RCP-" + UUID.randomUUID().toString().substring(0, 8));
            } else {
                payment.setStatus("FAILED");
            }
            return paymentRepository.save(payment);
        }
        return null;
    }

    public Payment updatePayment(Long id, Payment payment) {
        if (paymentRepository.existsById(id)) {
            payment.setId(id);
            return paymentRepository.save(payment);
        }
        return null;
    }

    public boolean deletePayment(Long id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
            return true;
        }
        return false;
    }
} 