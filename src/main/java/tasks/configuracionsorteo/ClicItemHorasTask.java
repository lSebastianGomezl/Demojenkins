package tasks.configuracionsorteo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.ConfiguracionSorteo;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClicItemHorasTask implements Task {



    public static ClicItemHorasTask on() {
        return instrumented(ClicItemHorasTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ConfiguracionSorteo.ITEM_HORAS, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(ConfiguracionSorteo.ITEM_HORAS)
        );
    }
}
