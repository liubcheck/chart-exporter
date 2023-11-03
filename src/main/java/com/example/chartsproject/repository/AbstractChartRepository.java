package com.example.chartsproject.repository;

import com.example.chartsproject.model.AbstractChartElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractChartRepository<T extends AbstractChartElement>
        extends JpaRepository<T, Integer> {
}
