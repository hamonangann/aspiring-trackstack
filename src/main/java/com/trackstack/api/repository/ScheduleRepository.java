package com.trackstack.api.repository;

import com.trackstack.api.model.Schedule;
import com.trackstack.api.model.Station;
import com.trackstack.api.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findByTrain(Train train);
    List<Schedule> findByDepartTimeAndStationIn(Integer departTime, List<Station> stations);
}
