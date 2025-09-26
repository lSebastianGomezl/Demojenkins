package tasks.configuracionplanderesultados;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.PlanDeResultado;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClicGuardarModalTask implements Task {


    public static ClicGuardarModalTask btnGuardar() {
        return instrumented(ClicGuardarModalTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PlanDeResultado.BTN_GUARDAR, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(PlanDeResultado.BTN_GUARDAR)
        );
    }
}
