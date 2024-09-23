package com.dulich.tourism.models.booking;

import com.dulich.tourism.models.account.Account;
import com.dulich.tourism.models.hotel.Room;
import com.dulich.tourism.models.user.Customer;
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
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

//    @ManyToOne
//    @JoinColumn(name = "room_id", nullable = false)
//    private Room room;

    @OneToMany(mappedBy = "booking")
    private Set<RoomBooking> roomBookings;

    @Column(name = "check_in_date")
    @Temporal(TemporalType.DATE)
    private Date checkInDate;

    @Column(name = "check_out_date")
    @Temporal(TemporalType.DATE)
    private Date checkOutDate;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}