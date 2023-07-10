package com.trackstack.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Station {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "orderz")
    private Integer order;
    private String name;

    @OneToMany(mappedBy = "station")
    private List<Schedule> schedules;
}
