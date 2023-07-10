package com.trackstack.api.repository;

import com.trackstack.api.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {
    Station findByName(String name);
    List<Station> findByOrderBetween(Integer startOrder, Integer endOrder);
}
