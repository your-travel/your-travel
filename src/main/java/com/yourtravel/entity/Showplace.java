package com.yourtravel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "SHOWPLACE")
@Data
@ToString(exclude = {"city", "feedbacks"})
@EqualsAndHashCode(exclude = {"city", "feedbacks"})
public class Showplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Temporal(TemporalType.TIME)
    private Date workStart;
    @Temporal(TemporalType.TIME)
    private Date workEnd;

    @Column(precision = 3, scale = 2)
    private Double rating;

    private String description;

    @Lob
    @Column(name = "full_description", columnDefinition = "CLOB")
    private String fullDescription;

    @JsonIgnore
    @Lob
    @Column(name = "audioguide", columnDefinition = "BLOB")
    private byte[] audioguide;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @OneToMany(mappedBy = "showplace", fetch = FetchType.LAZY)
    private Set<Feedback> feedbacks;


}
