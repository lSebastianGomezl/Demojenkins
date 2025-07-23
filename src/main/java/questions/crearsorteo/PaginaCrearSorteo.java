package questions.crearsorteo;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import ui.ConfiguracionSorteo;
import ui.Dashboard;

public class PaginaCrearSorteo {

    public static Question<Boolean> tituloFormulario(String texto) {
        return actor -> {
            String textoUI = Text.of(ConfiguracionSorteo.tituloInformacionSorteo(texto)).answeredBy(actor).trim();
            System.out.println("Texto en UI capturado: [" + textoUI + "]");
            System.out.println("Texto esperado: [" + texto.trim() + "]");
            return textoUI.equalsIgnoreCase(texto.trim());
        };

    }

    public static Question<Boolean> sorteoSuccessful(String mensajeEsperado) {
        return actor -> {
            String textoUI = Text.of(ConfiguracionSorteo.validacionCracionSorteo(mensajeEsperado)).answeredBy(actor).trim();
            System.out.println("Texto en UI capturado: [" + textoUI + "]");
            System.out.println("Texto esperado: [" + mensajeEsperado.trim() + "]");
            return textoUI.equalsIgnoreCase(mensajeEsperado.trim());
        };
    }
}
