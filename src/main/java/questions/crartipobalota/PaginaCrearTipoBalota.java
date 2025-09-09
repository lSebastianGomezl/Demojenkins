package questions.crartipobalota;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import ui.ConfiguracionSorteo;
import ui.CreacionBalotaTotal;

import java.time.Duration;

public class PaginaCrearTipoBalota {


    public static Question<Boolean> tipoBalotaParametroSuccessful(String textoEsperado) {
        return actor -> {
            // Esperar a que sea visible
            CreacionBalotaTotal.ALERT_SUCCESS.resolveFor(actor).waitUntilVisible();

            // Capturar texto
            String textoUI = CreacionBalotaTotal.ALERT_SUCCESS.resolveFor(actor).getText().trim();

            System.out.println("Texto capturado en UI: [" + textoUI + "]");
            System.out.println("Texto esperado: [" + textoEsperado.trim() + "]");

            // Validar visibilidad + texto
            return CreacionBalotaTotal.ALERT_SUCCESS.resolveFor(actor).isVisible()
                    && textoUI.equalsIgnoreCase(textoEsperado.trim());
        };
//    public static Question<Boolean> tipoBalotaParametroSuccessful() {
//        return actor -> {
//            CreacionBalotaTotal.ALERT_SUCCESS.resolveFor(actor).waitUntilVisible();
//            return CreacionBalotaTotal.ALERT_SUCCESS.resolveFor(actor).isVisible();
//        };
//    }

//    public static Question<Boolean> tipoBalotaParametroSuccessful(String textoEsperado) {
//        return actor -> {
//            String textoUI = Text.of(CreacionBalotaTotal.ALERT_SUCCESS).answeredBy(actor).trim();
//            System.out.println("Texto en UI capturado: [" + textoUI + "]");
//            System.out.println("Texto esperado: [" + textoEsperado.trim() + "]");
//            return textoUI.toLowerCase().contains(textoEsperado.trim().toLowerCase());
//        };
//    }

    }
}
