package com.dulich.tourism.models.adds;

import com.dulich.tourism.models.user.Admin;
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
public class Adds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "add_name")
    private String addName;

    @Column(name = "text_add")
    private String textAdd;

    private String image;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;
}
