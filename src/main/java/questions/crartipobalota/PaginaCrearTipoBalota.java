package questions.crartipobalota;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import ui.ConfiguracionSorteo;
import ui.CreacionBalotaTotal;

import java.time.Duration;

public class PaginaCrearTipoBalota {


    public static Question<Boolean> tipoBalotaParametroSuccessful(String textoEsperado) {
        return actor -> {
            WebElementFacade alert = CreacionBalotaTotal.ALERT_SUCCESS.resolveFor(actor);

            alert.waitUntilVisible();
            String textoUI = alert.getText().trim().replaceAll("\\s+", " ");

            System.out.println("Texto capturado en UI: [" + textoUI + "]");
            System.out.println("Texto esperado: [" + textoEsperado.trim() + "]");

            return alert.isVisible() &&
                    textoUI.equalsIgnoreCase(textoEsperado.trim().replaceAll("\\s+", " "));
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
