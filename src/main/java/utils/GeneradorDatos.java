package utils;

import net.serenitybdd.core.Serenity;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class GeneradorDatos {

    public static String nombreDeSorteoUnico() {
        return "Aleatorio_" + UUID.randomUUID().toString().substring(0, 8);
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
    public static String obtenerDiaActual() {
        return String.valueOf(LocalDate.now().getDayOfMonth());
    }
    public static int obtenerMesActual() {
        return LocalDate.now().getMonthValue();
    }
    public static String obtenerValorDiaSemana() {
        DayOfWeek dia = LocalDate.now().getDayOfWeek();
        int valor = dia.getValue();
        return String.valueOf(valor == 7 ? 1 : valor + 1);
    }
    public static String extraerHora(String horaCompleta) {
        return horaCompleta.substring(0, 2); // Devuelve las dos primeras cifras
    }


}
