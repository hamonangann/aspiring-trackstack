package com.trackstack.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Schedule {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "TRAIN_ID", referencedColumnName = "ID")
    private Train train;

    @ManyToOne
    @JoinColumn(name = "STATION_ID", referencedColumnName = "ID")
    private Station station;

    private Integer departTime;

}
