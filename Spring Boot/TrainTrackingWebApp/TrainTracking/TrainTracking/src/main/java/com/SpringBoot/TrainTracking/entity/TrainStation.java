package com.SpringBoot.TrainTracking.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "TrainStations")
public class TrainStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stationName")
    private String stationName;

    @Column(name = "stationCode")
    private String stationCode;



}
