package com.yourtravel.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "SHOWPLACE")
@Data
public class Showplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @Temporal(TemporalType.TIME)
    Date workStart;
    @Temporal(TemporalType.TIME)
    Date workEnd;

    @Column(precision = 3, scale = 2)
    Double rating;

    String description;

    @Lob
    @Column(name = "full_description", columnDefinition = "CLOB")
    String fullDescription;

    @Lob
    @Column(name = "audioguide", columnDefinition = "BLOB")
    byte[] audioguide;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", nullable = false)
    City city;

    @OneToMany(mappedBy = "showplace", fetch = FetchType.EAGER)
    private Set<Feedback> feedbacks;


}
