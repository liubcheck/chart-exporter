package com.example.chartsproject.service.impl;

import com.example.chartsproject.model.RingChartElement;
import com.example.chartsproject.repository.RingChartRepository;
import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.ui.RectangleEdge;
import org.springframework.stereotype.Service;

@Service
public class RingChartService extends AbstractChartService<RingChartElement> {
    private static final String CHART_NAME = "Ring Chart";

    public RingChartService(RingChartRepository repository) {
        super(repository);
    }

    @Override
    public String getChartName() {
        return CHART_NAME;
    }

    @Override
    public List<RingChartElement> getInitialElements() {
        return Arrays.asList(
                new RingChartElement(null, "Apple", 0.30),
                new RingChartElement(null, "L'Oreal Skincare and Health Ltd.", 0.2),
                new RingChartElement(null, "Volkswagen AG", 0.15),
                new RingChartElement(null, "Microsoft Computers and ASCII Art Inc.", 0.15),
                new RingChartElement(null, "München Mag Dich T-Shirts GmbH", 0.10),
                new RingChartElement(null, "American Airlines Inc.", 0.05)
        );
    }

    @Override
    protected JFreeChart generateChart(List<RingChartElement> elements) {
        return ChartFactory.createRingChart("", createDataset(elements),
                true, true, Locale.GERMANY);
    }

    @Override
    protected void customizeChart(JFreeChart chart) {
        RingPlot plot = (RingPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setSectionPaint("Apple", new Color(126, 208, 150, 255));
        plot.setSectionPaint("L'Oreal Skincare and Health Ltd.", new Color(41, 157, 135, 255));
        plot.setSectionPaint("Volkswagen AG", new Color(25, 144, 212, 255));
        plot.setSectionPaint("Microsoft Computers and ASCII Art Inc.", new Color(57, 91, 133, 255));
        plot.setSectionPaint("München Mag Dich T-Shirts GmbH", new Color(95, 85, 25, 255));
        plot.setSectionPaint("American Airlines Inc.", new Color(22, 90, 63, 255));
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{2}"));
        chart.getLegend().setPosition(RectangleEdge.RIGHT);
    }
}
