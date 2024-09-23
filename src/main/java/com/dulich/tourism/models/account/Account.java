package com.dulich.tourism.models.account;

import com.dulich.tourism.models.Review;
import com.dulich.tourism.models.booking.Booking;
import com.dulich.tourism.models.booking.Payment;
import com.dulich.tourism.models.user.Admin;
import com.dulich.tourism.models.user.Customer;
import com.dulich.tourism.models.user.HotelOwner;
import com.dulich.tourism.models.user.TourOwner;
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
@Table(name = "accounts") // Đặt tên bảng phù hợp
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Profile profile;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Customer customer;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Admin admin;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private HotelOwner hotelOwner;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private TourOwner tourOwner;

//    @OneToMany(mappedBy = "account")
//    private Set<TourBooking> tourBookings;

    @OneToMany(mappedBy = "account")
    private Set<Payment> payments;

    @OneToMany(mappedBy = "account")
    private Set<Review> reviews;
}
