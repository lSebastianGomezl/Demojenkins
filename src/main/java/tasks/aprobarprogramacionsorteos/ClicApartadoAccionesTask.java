package tasks.aprobarprogramacionsorteos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.AprobacionProgramacionSorteo;
import ui.ConfiguracionParametros;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClicApartadoAccionesTask implements Task {


    public static ClicApartadoAccionesTask on() {
        return instrumented(ClicApartadoAccionesTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(AprobacionProgramacionSorteo.BOTON_VER_DETALLE, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(AprobacionProgramacionSorteo.BOTON_VER_DETALLE)
        );
    }
}
