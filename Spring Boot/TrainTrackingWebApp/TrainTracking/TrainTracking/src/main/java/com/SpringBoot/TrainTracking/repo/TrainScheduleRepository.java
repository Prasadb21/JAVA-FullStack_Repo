package com.SpringBoot.TrainTracking.repo;


import com.SpringBoot.TrainTracking.entity.TrainSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainScheduleRepository extends JpaRepository<TrainSchedule , Long> {


    List<TrainSchedule> findBySource_StationCodeAndDestination_StationCode(String sourceCode, String destinationCode);

    List<TrainSchedule> findBySource_StationNameAndDestination_StationName(String sourceStation, String destinationStation);

}
