package com.example.chartsproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "pie_chart_elements")
public class PieChartElement extends AbstractChartElement {
    public PieChartElement(Integer id, String key, double weight) {
        super(id, key, weight);
    }
}
