package tasks.crearsorteo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.Dashboard;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClicBtoCrearSorteoTask implements Task {

    private final String texto;

    public ClicBtoCrearSorteoTask(String texto) {
        this.texto = texto;
    }

    public static ClicBtoCrearSorteoTask conTexto(String texto) {
        return instrumented(ClicBtoCrearSorteoTask.class, texto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(Dashboard.botonConTexto(texto), isVisible()).forNoMoreThan(15).seconds(),
                Click.on(Dashboard.botonConTexto(texto))
        );
    }
}
