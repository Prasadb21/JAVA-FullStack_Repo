package com.SpringBoot.TrainTracking.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Trains")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "trainName")
    private String trainName;

    @Column(name = "trainNumber")
    private String trainNumber;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JsonBackReference
    private List<TrainSchedule> scheduleList;



}
