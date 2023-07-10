package com.trackstack.api.repository;

import com.trackstack.api.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train, Integer> {
    Train findByName(String name);
}
