package com.example.chartsproject.service;

import com.lowagie.text.Document;
import org.jfree.chart.JFreeChart;

public interface PdfService {
    void saveChartToPdfDocument(Document document, JFreeChart chart, String chartName);
}
