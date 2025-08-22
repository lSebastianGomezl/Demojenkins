package tasks.configuracionparametros;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.ConfiguracionParametros;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClicIconoEditarTask implements Task {


    public static ClicIconoEditarTask on() {
        return instrumented(ClicIconoEditarTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ConfiguracionParametros.BOTON_EDITAR, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(ConfiguracionParametros.BOTON_EDITAR)
        );

    }
}
