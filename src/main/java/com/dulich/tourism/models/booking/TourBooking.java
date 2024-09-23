package com.dulich.tourism.models.booking;

import com.dulich.tourism.models.TourPackage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tour_bookings")
public class TourBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "tour_package_id", nullable = false)
    private TourPackage tourPackage;

    @Column(name = "number_of_people")
    private int numberOfPeople;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}