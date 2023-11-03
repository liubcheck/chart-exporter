package com.example.chartsproject.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class AbstractChartElement implements Comparable<AbstractChartElement> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;
    protected String segmentValue;
    protected Double weight;

    @Override
    public int compareTo(AbstractChartElement element) {
        return Double.compare(this.weight, element.weight);
    }
}
