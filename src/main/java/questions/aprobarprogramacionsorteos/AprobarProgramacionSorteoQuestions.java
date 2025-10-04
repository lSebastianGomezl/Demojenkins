package questions.aprobarprogramacionsorteos;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Question;
import ui.AprobacionProgramacionSorteo;

import java.util.concurrent.TimeUnit;



public class AprobarProgramacionSorteoQuestions {

    public static Question<Boolean> aprobacionSuccessful(String mensajeEsperado) {
        return actor -> {
            WebElementFacade alert = AprobacionProgramacionSorteo.MENSAJE_EXITO.resolveFor(actor);

            alert.waitUntilVisible().withTimeoutOf(10, TimeUnit.SECONDS);

            String textoUI = alert.getText().trim().replaceAll("\\s+", " ");
            String esperado = mensajeEsperado.trim().replaceAll("\\s+", " ");

            System.out.println("Texto capturado en UI: [" + textoUI + "]");
            System.out.println("Texto esperado: [" + esperado + "]");

            return alert.isVisible() && textoUI.equalsIgnoreCase(esperado);
        };
    }
}
