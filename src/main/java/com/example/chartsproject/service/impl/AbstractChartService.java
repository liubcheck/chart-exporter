package com.example.chartsproject.service.impl;

import com.example.chartsproject.model.AbstractChartElement;
import com.example.chartsproject.repository.AbstractChartRepository;
import com.example.chartsproject.service.GenericChartService;
import java.util.List;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public abstract class AbstractChartService<T extends AbstractChartElement>
        implements GenericChartService {

    protected final AbstractChartRepository<T> repository;

    public AbstractChartService(AbstractChartRepository<T> repository) {
        this.repository = repository;
    }

    public void save(T element) {
        repository.save(element);
    }

    @Override
    public JFreeChart createChart() {
        List<T> elements = repository.findAll();
        JFreeChart chart = generateChart(elements);
        customizeChart(chart);
        return chart;
    }

    public abstract String getChartName();

    public abstract List<T> getInitialElements();

    protected PieDataset<String> createDataset(List<T> elements) {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        elements.forEach(element -> dataset.insertValue(
                element.getId() - 1,
                element.getSegmentValue(),
                element.getWeight())
        );
        return dataset;
    }

    protected abstract JFreeChart generateChart(List<T> elements);

    protected abstract void customizeChart(JFreeChart chart);
}
