package com.SpringBoot.TrainTracking.controller;


import com.SpringBoot.TrainTracking.entity.TrainSchedule;
import com.SpringBoot.TrainTracking.service.TrainSearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@CrossOrigin
public class TrainSearchController {

    private TrainSearchService trainSearchService;

    public TrainSearchController(TrainSearchService trainSearchService)
    {
        this.trainSearchService = trainSearchService;

    }

    @GetMapping("/byCode")
    public List<TrainSchedule> findTrainByStationCode(@RequestParam String sourceCode ,
                                                      @RequestParam String destinationCode)
    {
        return trainSearchService.findStationByStationCode(sourceCode.toUpperCase() , destinationCode.toUpperCase());

    }

    @GetMapping("/byName")
    public List<TrainSchedule> findTrainByStationName(@RequestParam String sourceName ,
                                                      @RequestParam String destinationName)
    {
        return trainSearchService.findStationByStationName(sourceName , destinationName);

    }


}
