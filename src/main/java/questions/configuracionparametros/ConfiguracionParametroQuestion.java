package questions.configuracionparametros;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.ConfiguracionSorteo;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConfiguracionParametroQuestion {

    public static Question<Boolean> configuracionParametroSuccessful(String mensajeEsperado) {
        return actor -> {
            // Esperar hasta que el toast esté visible
            actor.attemptsTo(
                    WaitUntil.the(
                            ConfiguracionSorteo.validacionCracionSorteo(mensajeEsperado),
                            WebElementStateMatchers.isVisible()
                    ).forNoMoreThan(5).seconds()
            );

            // Capturar el texto
            String textoUI = Text.of(ConfiguracionSorteo.validacionCracionSorteo(mensajeEsperado))
                    .answeredBy(actor)
                    .trim();

            System.out.println("Texto en UI capturado: [" + textoUI + "]");
            System.out.println("Texto esperado: [" + mensajeEsperado.trim() + "]");

            return textoUI.equalsIgnoreCase(mensajeEsperado.trim());
        };
    }

}
