package com.yourtravel.entity;

import com.yourtravel.entity.enums.EventType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EVENT")
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Temporal(TemporalType.TIMESTAMP)
    Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "showplace_id")
    Showplace showplace;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "travel_day_id", nullable = false)
    TravelDay travelDay;

    @Enumerated(EnumType.STRING)
    EventType eventType;

}
