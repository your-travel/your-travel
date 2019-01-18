package com.yourtravel.entity;


import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "CITY")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", nullable = false)
    Country country;

}
