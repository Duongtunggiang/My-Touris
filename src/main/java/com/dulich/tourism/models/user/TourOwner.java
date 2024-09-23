package com.dulich.tourism.models.user;

import com.dulich.tourism.models.TourPackage;
import com.dulich.tourism.models.account.Account;
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
@Table(name = "tour_owner")
public class TourOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @OneToMany(mappedBy = "tour_owner")
//    private Set<TourPackage> tourPackages;

    @OneToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}
