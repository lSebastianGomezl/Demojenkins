package tasks.configuracionsorteo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.ConfiguracionSorteo;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ElegirTipoDeFechaTask implements Task {

    private final String tipo;

    public ElegirTipoDeFechaTask(String tipo) {
        this.tipo = tipo;
    }

    public static ElegirTipoDeFechaTask on(String tipo) {
        return instrumented(ElegirTipoDeFechaTask.class, tipo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (tipo.equalsIgnoreCase("fechaUnica")) {
            actor.attemptsTo(
                    WaitUntil.the(ConfiguracionSorteo.CHECK_BOX, isVisible()).forNoMoreThan(15).seconds(),
                    Click.on(ConfiguracionSorteo.CHECK_BOX)
            );
        } else if (tipo.equalsIgnoreCase("multipleFecha")) {
            actor.attemptsTo(
                    WaitUntil.the(ConfiguracionSorteo.CHECK_BOX_MULTIPLES, isVisible()).forNoMoreThan(15).seconds(),
                    Click.on(ConfiguracionSorteo.CHECK_BOX_MULTIPLES)
            );
        } else {
            throw new IllegalArgumentException("Tipo de fecha no reconocido: " + tipo);
        }
    }
}
