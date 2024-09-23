package com.dulich.tourism.models.booking;

import com.dulich.tourism.models.account.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @Column(name = "amount")
    private int amount;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}