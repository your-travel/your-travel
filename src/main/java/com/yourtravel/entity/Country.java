package com.yourtravel.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "COUNTRY")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;

}
