package questions.configuracionplanresultados;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import ui.CreacionBalotaTotal;
import ui.PlanDeResultado;

import java.util.concurrent.TimeUnit;

import static ui.PlanDeResultado.MENSAJE_EXITO;

public class ConfiguracionPlanResultadosQuestions {

    public static Question<Boolean> configuracionPlanResultadoSuccessful(String mensajeEsperado) {
        return actor -> {
            WebElementFacade alert = MENSAJE_EXITO.resolveFor(actor);

            alert.waitUntilVisible().withTimeoutOf(10, TimeUnit.SECONDS);

            String textoUI = alert.getText().trim().replaceAll("\\s+", " ");
            String esperado = mensajeEsperado.trim().replaceAll("\\s+", " ");

            System.out.println("Texto capturado en UI: [" + textoUI + "]");
            System.out.println("Texto esperado: [" + esperado + "]");

            return alert.isVisible() && textoUI.equalsIgnoreCase(esperado);
        };
    }
}
