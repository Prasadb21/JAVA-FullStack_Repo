package com.SpringBoot.TrainTracking.service;


import com.SpringBoot.TrainTracking.entity.TrainSchedule;
import com.SpringBoot.TrainTracking.repo.TrainScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainSearchService {

    private TrainScheduleRepository trainScheduleRepository;

    public TrainSearchService(TrainScheduleRepository trainScheduleRepository)
    {
        this.trainScheduleRepository = trainScheduleRepository;

    }


    public List<TrainSchedule> findStationByStationCode(String sourceCode, String destinationCode) {

        return trainScheduleRepository.
                findBySource_StationCodeAndDestination_StationCode(sourceCode , destinationCode);

    }

    public List<TrainSchedule> findStationByStationName(String sourceStation, String destinationStation) {

        return trainScheduleRepository.
                findBySource_StationNameAndDestination_StationName(sourceStation , destinationStation);

    }


}
