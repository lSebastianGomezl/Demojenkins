package utils;

import net.thucydides.core.reports.html.HtmlAggregateStoryReporter;
import org.apache.commons.io.FileUtils;

import java.awt.*;
import java.io.File;

public class GenerarReporteSerenity {
    public static void generar() {
        try {
            // 🔹 Generador de reportes
            HtmlAggregateStoryReporter reporter = new HtmlAggregateStoryReporter("Serenity Report");
            reporter.setOutputDirectory(new File("target/site/serenity"));
            reporter.generateReportsForTestResultsFrom(new File("target/site/serenity"));

            // 🔹 Abrir el index.html generado
            File reporte = new File("target/site/serenity/index.html");
            if (reporte.exists()) {
                Desktop.getDesktop().browse(reporte.toURI());
            } else {
                System.err.println("No se encontró el reporte en: " + reporte.getAbsolutePath());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void limpiarReportes() {
        try {
            FileUtils.deleteDirectory(new File("target/site/serenity"));
            System.out.println("✅ Reportes eliminados antes de ejecutar");
        } catch (Exception e) {
            System.out.println("⚠ No se pudieron borrar reportes: " + e.getMessage());
        }
    }
}
