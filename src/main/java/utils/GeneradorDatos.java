package utils;

import net.serenitybdd.core.Serenity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class GeneradorDatos {

    public static String nombreDeSorteoUnico() {
        return "Sorteo_" + UUID.randomUUID().toString().substring(0, 8);
    }

    public static String codigoUnico() {
        long tiempo = System.nanoTime();
        int aleatorio = (int) (Math.random() * 1000); // 0-999
        return String.format("COD%d%03d", tiempo, aleatorio);
    }

    public static String fechaActual() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    public static String fechaAnterior() {
        LocalDate ayer = LocalDate.now().minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return ayer.format(formatter);
    }

}
