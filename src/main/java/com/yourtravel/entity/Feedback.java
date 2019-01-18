package com.yourtravel.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "FEEDBACK")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    Integer mark;

    Boolean valid;

    @ManyToOne(targetEntity = Showplace.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "showplace_id", nullable = false)
    Showplace showplace;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    User user;


}
