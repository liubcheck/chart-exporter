package com.example.chartsproject.service.impl;

import com.example.chartsproject.model.PieChartElement;
import com.example.chartsproject.repository.AbstractChartRepository;
import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.ui.RectangleEdge;
import org.springframework.stereotype.Service;

@Service
public class PieChartService extends AbstractChartService<PieChartElement> {
    private static final String CHART_NAME = "Pie Chart";

    public PieChartService(AbstractChartRepository<PieChartElement> repository) {
        super(repository);
    }

    @Override
    public String getChartName() {
        return CHART_NAME;
    }

    @Override
    public List<PieChartElement> getInitialElements() {
        return Arrays.asList(
                new PieChartElement(null, "Deutschland", 36.95),
                new PieChartElement(null, "Frankreich", 31.51),
                new PieChartElement(null, "Spanien", 12.44),
                new PieChartElement(null, "Niederlande", 6.41),
                new PieChartElement(null, "Belgien", 2.76),
                new PieChartElement(null, "Italien", 2.29),
                new PieChartElement(null, "Großbritannien", 1.71),
                new PieChartElement(null, "Kanada", 1.21),
                new PieChartElement(null, "Liquidität/Terminkontrakte", 4.71)
        );
    }

    @Override
    protected JFreeChart generateChart(List<PieChartElement> elements) {
        return ChartFactory.createPieChart("", createDataset(elements));
    }

    @Override
    protected void customizeChart(JFreeChart chart) {
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setSectionPaint("Deutschland", new Color(126, 208, 150, 255));
        plot.setSectionPaint("Frankreich", new Color(41, 157, 135, 255));
        plot.setSectionPaint("Spanien", new Color(25, 144, 212, 255));
        plot.setSectionPaint("Niederlande", new Color(130, 117, 68, 255));
        plot.setSectionPaint("Belgien", new Color(106, 121, 112, 255));
        plot.setSectionPaint("Italien", new Color(172, 159, 98, 255));
        plot.setSectionPaint("Großbritannien", new Color(233, 209, 28, 255));
        plot.setSectionPaint("Kanada", new Color(248, 185, 11, 255));
        plot.setSectionPaint("Liquidität/Terminkontrakte", new Color(244, 213, 108, 255));
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{2}"));
        chart.getLegend().setPosition(RectangleEdge.BOTTOM);
    }
}
