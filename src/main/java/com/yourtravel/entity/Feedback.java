package com.yourtravel.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "FEEDBACK")
@ToString(exclude = {"showplace", "user"})
@EqualsAndHashCode(exclude = {"showplace", "user"})
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private Integer mark;

    private Boolean valid;

    @ManyToOne(targetEntity = Showplace.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "showplace_id", nullable = false)
    private Showplace showplace;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}
