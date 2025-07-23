package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class GeneradorDatos {

    public static String nombreDeSorteoUnico() {
        return "Sorteo_" + UUID.randomUUID().toString().substring(0, 8);
    }

    public static String codigoUnico() {
        long timestamp = System.currentTimeMillis();
        return String.format("COD%04d", timestamp);
    }

    public static String fechaActual() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
