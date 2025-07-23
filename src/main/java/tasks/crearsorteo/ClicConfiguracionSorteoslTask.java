package tasks.crearsorteo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.Dashboard;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClicConfiguracionSorteoslTask implements Task {

    private final String texto;

    public ClicConfiguracionSorteoslTask(String texto) {
        this.texto = texto;
    }

    public static ClicConfiguracionSorteoslTask on(String texto){
        return instrumented(ClicConfiguracionSorteoslTask.class, texto);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(Dashboard.submenuConTitulo(texto), isVisible()).forNoMoreThan(15).seconds(),
                Click.on(Dashboard.submenuConTitulo(texto))
        );
    }
}
