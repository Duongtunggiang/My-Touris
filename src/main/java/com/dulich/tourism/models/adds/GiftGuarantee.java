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
public class GiftGuarantee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "gift_name")
    private String giftName;

    @Column(name = "guarantee")
    private String guarantee;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;

//    @ManyToOne
//    @JoinColumn(name = "product_id", nullable = false)
//    private Product product;
}
