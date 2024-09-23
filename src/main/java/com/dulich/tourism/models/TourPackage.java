package com.dulich.tourism.models;
import com.dulich.tourism.models.user.TourOwner;
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
@Table(name = "tour_packages")
public class TourPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "duration")
    private int duration;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "itinerary")
    private String itinerary;

    @Column(name = "status")
    private String status;

//    @OneToMany(mappedBy = "tour_packages")
//    private Set<Review> reviews;
    @ManyToOne
    @JoinColumn(name = "tour_owner_id")
    private TourOwner tourOwner;
}