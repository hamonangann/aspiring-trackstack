package com.trackstack.api.service;

import com.trackstack.api.model.Schedule;
import com.trackstack.api.model.Station;
import com.trackstack.api.model.Train;
import com.trackstack.api.repository.ScheduleRepository;
import com.trackstack.api.repository.StationRepository;
import com.trackstack.api.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private StationRepository stationRepository;

    public List<Schedule> findTrainSchedule(String trainName) {
        Train train = trainRepository.findByName(trainName);
        return scheduleRepository.findByTrain(train);
    }

    public List<Schedule> findScheduleInCertainTimeAndStation(String stationName1, String stationName2, Integer departTime) {
        Station station1 = stationRepository.findByName(stationName1);
        Station station2 = stationRepository.findByName(stationName2);

        int startOrder = station1.getOrder();
        int endOrder = station2.getOrder();
        if (endOrder < startOrder) {
            int temp = endOrder;
            endOrder = startOrder;
            startOrder = temp;
        }

        List<Station> stations = stationRepository.findByOrderBetween(startOrder, endOrder);

        return scheduleRepository.findByDepartTimeAndStationIn(departTime, stations);
    }

    public Schedule updateSchedule(Integer id, Integer departTime) {
        Optional<Schedule> schedule = scheduleRepository.findById(id);
        if (schedule.isPresent()) {
            Schedule sch = schedule.get();
            sch.setDepartTime(departTime);
            scheduleRepository.save(sch);

            return sch;
        }

        return null;
    }
}
