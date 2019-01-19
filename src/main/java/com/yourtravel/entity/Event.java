package com.yourtravel.entity;

import com.yourtravel.entity.enums.EventType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EVENT")
@Data
@ToString(exclude = {"showplace", "travelDay"})
@EqualsAndHashCode(exclude = {"showplace", "travelDay"})
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "showplace_id")
    private Showplace showplace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "travel_day_id", nullable = false)
    private TravelDay travelDay;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

}
