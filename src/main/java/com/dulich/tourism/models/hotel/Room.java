package com.dulich.tourism.models.hotel;

import com.dulich.tourism.models.booking.RoomBooking;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "description")
    private String description;

    @Column(name = "price_per_night")
    private int pricePerNight;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "availability")
    private String availability;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @OneToMany(mappedBy = "room")
    private Set<RoomBooking> roomBookings;
}