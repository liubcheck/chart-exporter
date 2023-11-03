package com.example.chartsproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "ring_chart_elements")
public class RingChartElement extends AbstractChartElement {
    public RingChartElement(Integer id, String key, Double weight) {
        super(id, key, weight);
    }
}
