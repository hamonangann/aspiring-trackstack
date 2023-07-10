package com.trackstack.api.controller;

import com.trackstack.api.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping(path = "/train/{train_name}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<?> findTrainSchedule(@PathVariable(value = "train_name") String trainName) {
        return ResponseEntity.ok(scheduleService.findTrainSchedule(trainName));
    }

    @GetMapping(path = "/time/{station_name1}/{station_name2}/{depart_time}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<?> findScheduleInCertainTimeAndStation(
            @PathVariable(value = "station_name1") String stationName1,
            @PathVariable(value = "station_name2") String stationName2,
            @PathVariable(value = "depart_time") Integer departTime) {
        return ResponseEntity.ok(scheduleService.findScheduleInCertainTimeAndStation(
                stationName1, stationName2, departTime));
    }

    @PatchMapping(path = "/time/{id}/{depart_time}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<?> updateSchedule(
            @PathVariable(value = "id") Integer id,
            @PathVariable(value = "depart_time") Integer departTime) {
        return ResponseEntity.ok(scheduleService.updateSchedule(id, departTime));
    }
}
