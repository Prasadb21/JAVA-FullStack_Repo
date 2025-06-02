package com.SpringBoot.TrainTracking.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "TrainSchedule")
public class TrainSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "train_id")
    @JsonManagedReference
    private Train train;

    @ManyToOne
    @JoinColumn(name = "source_station_id")
    private TrainStation source;

    @ManyToOne
    @JoinColumn(name = "destination_station_id")
    private TrainStation destination;

    @Column(name="TrainDepartureTime")
    private String trainDepartureTime;

    @Column(name = "TrainArrivalTime")
    private String trainArrivalTime;


}
