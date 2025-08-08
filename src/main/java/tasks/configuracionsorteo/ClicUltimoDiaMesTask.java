package tasks.configuracionsorteo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.ConfiguracionSorteo;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClicUltimoDiaMesTask implements Task {


    public static ClicUltimoDiaMesTask on() {
        return instrumented(ClicUltimoDiaMesTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ConfiguracionSorteo.RADIO_SELECCIONADO_ULTIMO_DIA, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(ConfiguracionSorteo.RADIO_SELECCIONADO_ULTIMO_DIA)
        );
    }
}
