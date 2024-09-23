package com.dulich.tourism.models.user;

import com.dulich.tourism.models.account.Account;
import com.dulich.tourism.models.hotel.Hotel;
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
@Table(name = "hotel_owner")
public class HotelOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @OneToMany(mappedBy = "hotel_owner")
//    private Set<Hotel> hotels;

    @OneToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}
