package com.dulich.tourism.models.user;

import com.dulich.tourism.models.account.Account;
import com.dulich.tourism.models.booking.Booking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @OneToMany(mappedBy = "customer")
//    private Set<Booking> bookings;

    @OneToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}
