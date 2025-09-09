package tasks.creartipobalota;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.CreacionBalotaTotal;
import ui.Dashboard;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClicBtoGuardarTask implements Task {


    public static ClicBtoGuardarTask on() {
        return instrumented(ClicBtoGuardarTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CreacionBalotaTotal.BTN_GUARDAR_MODAL, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(CreacionBalotaTotal.BTN_GUARDAR_MODAL)
        );
    }
}
