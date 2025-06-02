package com.SpringBoot.TrainTracking.repo;

import com.SpringBoot.TrainTracking.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train , Long> {

}
