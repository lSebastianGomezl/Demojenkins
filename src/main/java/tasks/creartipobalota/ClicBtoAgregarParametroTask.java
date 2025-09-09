package tasks.creartipobalota;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.CreacionBalotaTotal;
import ui.Dashboard;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClicBtoAgregarParametroTask implements Task {



    public static ClicBtoAgregarParametroTask on() {
        return instrumented(ClicBtoAgregarParametroTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CreacionBalotaTotal.BOTON_AGREGAR_PARAMETRO, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(CreacionBalotaTotal.BOTON_AGREGAR_PARAMETRO)
        );
    }
}
