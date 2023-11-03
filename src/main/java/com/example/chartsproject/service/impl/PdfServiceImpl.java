package com.example.chartsproject.service.impl;

import com.example.chartsproject.exception.ExportException;
import com.example.chartsproject.service.PdfService;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.springframework.stereotype.Service;

@Service
public class PdfServiceImpl implements PdfService {
    @Override
    public void saveChartToPdfDocument(Document document, JFreeChart chart, String chartName) {
        try {
            document.add(new Paragraph(chartName));
            document.add(castToImage(chart));
        } catch (DocumentException | IOException e) {
            throw new ExportException("Error by exporting the chart to PDF", e);
        }
    }

    private Image castToImage(JFreeChart chart) throws IOException {
        ByteArrayOutputStream chartOutStream = new ByteArrayOutputStream();
        ChartUtils.writeChartAsPNG(chartOutStream, chart, 500, 300);
        return Image.getInstance(chartOutStream.toByteArray());
    }
}
