package com.dulich.tourism.models.account;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private int phone;

    @Column(name = "address")
    private String address;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}
