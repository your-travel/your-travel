package com.yourtravel.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TRAVEL_PLAN")
public class TravelPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    Integer adultCount;

    Integer childCount;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    Date endDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", nullable = false)
    City city;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    User user;
}
