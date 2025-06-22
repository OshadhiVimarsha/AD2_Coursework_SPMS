package com.spms.payment.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private Long parkingSpaceId;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private String status; // PENDING, COMPLETED, FAILED

    @Column(nullable = false)
    private LocalDateTime timestamp;


    @Column
    private String paymentMethod; // CREDIT_CARD, DEBIT_CARD, etc.

    @Column
    private String receiptNumber;
} 