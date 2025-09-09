package tasks.creartipobalota;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.Dashboard;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClicBtoTask implements Task {

    private final String texto;

    public ClicBtoTask(String texto) {
        this.texto = texto;
    }

    public static ClicBtoTask conTexto(String texto) {
        return instrumented(ClicBtoTask.class, texto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(Dashboard.botonConTexto(texto), isVisible()).forNoMoreThan(15).seconds(),
                Click.on(Dashboard.botonConTexto(texto))
        );
    }
}
