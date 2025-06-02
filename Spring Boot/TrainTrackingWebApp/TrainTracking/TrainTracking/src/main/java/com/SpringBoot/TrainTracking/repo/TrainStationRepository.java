package com.SpringBoot.TrainTracking.repo;


import com.SpringBoot.TrainTracking.entity.TrainStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainStationRepository extends JpaRepository<TrainStation , Long> {

}
