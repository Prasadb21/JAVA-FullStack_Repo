package com.SpringBoot.TrainTracking.controller;


import com.SpringBoot.TrainTracking.entity.Train;
import com.SpringBoot.TrainTracking.entity.TrainStation;
import com.SpringBoot.TrainTracking.service.TrainService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trains")
@CrossOrigin
public class TrainController {


    private TrainService trainService;

    public TrainController(TrainService trainService)
    {
        this.trainService = trainService;

    }

    @GetMapping
    public List<Train> getAllTrains()
    {
        return trainService.getAllTrains();
    }

    @PostMapping
    public Train addTrainToDatabase(@RequestBody Train train)
    {
        return trainService.addTrains(train);

    }




}
