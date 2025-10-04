package tasks.aprobarprogramacionsorteos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.AprobacionProgramacionSorteo;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClicApartadoDetallesTask implements Task {


    public static ClicApartadoDetallesTask on() {
        return instrumented(ClicApartadoDetallesTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(AprobacionProgramacionSorteo.BOTON_VER_ACCIONES, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(AprobacionProgramacionSorteo.BOTON_VER_ACCIONES)
        );
    }
}
