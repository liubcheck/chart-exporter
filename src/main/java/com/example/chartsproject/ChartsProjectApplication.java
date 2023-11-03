package com.example.chartsproject;

import com.example.chartsproject.model.AbstractChartElement;
import com.example.chartsproject.service.PdfService;
import com.example.chartsproject.service.impl.AbstractChartService;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.example.chartsproject"})
public class ChartsProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChartsProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(List<AbstractChartService> chartServices, PdfService pdfService) {
        return args -> {
            for (AbstractChartService chartService : chartServices) {
                addChartElements(chartService);
            }
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("Amteil am Fondsvermögen.pdf"));
            document.open();
            document.add(new Paragraph(new Chunk(
                    "Amteil am Fondsvermögen",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20))));
            for (AbstractChartService chartService : chartServices) {
                pdfService.saveChartToPdfDocument(document, chartService.createChart(),
                        "\n" + chartService.getChartName());
            }

            document.close();
        };
    }

    private void addChartElements(AbstractChartService chartService) {
        List<AbstractChartElement> chartElements = chartService.getInitialElements();
        chartElements.forEach(chartService::save);
    }
}
