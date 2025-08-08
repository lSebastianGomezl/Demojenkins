package questions.configuracionsorteo;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import ui.ConfiguracionSorteo;

public class ConfiguracionSorteoQuestion {

    public static Question<Boolean> configuracionSorteoSuccessful(String mensajeEsperado) {
        return actor -> {
            String textoUI = Text.of(ConfiguracionSorteo.validacionCracionSorteo(mensajeEsperado)).answeredBy(actor).trim();
            System.out.println("Texto en UI capturado: [" + textoUI + "]");
            System.out.println("Texto esperado: [" + mensajeEsperado.trim() + "]");
            return textoUI.equalsIgnoreCase(mensajeEsperado.trim());
        };
    }
}
