package com.dulich.tourism.models.user;

import com.dulich.tourism.models.Service;
import com.dulich.tourism.models.account.Account;
import com.dulich.tourism.models.adds.Adds;
import com.dulich.tourism.models.adds.GiftGuarantee;
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
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @OneToMany(mappedBy = "admin")
    private Set<Adds> adds;

    @OneToMany(mappedBy = "admin")
    private Set<GiftGuarantee> giftGuarantees;

    @OneToMany(mappedBy = "admin")
    private Set<Service> services;
}
