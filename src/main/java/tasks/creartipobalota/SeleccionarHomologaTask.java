package tasks.creartipobalota;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.CreacionBalotaTotal;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarHomologaTask implements Task {


    private final String texto;

    public SeleccionarHomologaTask(String texto) {
        this.texto = texto;
    }
    public static SeleccionarHomologaTask on(String texto){
        return instrumented(SeleccionarHomologaTask.class, texto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(CreacionBalotaTotal.SELECCIONAR, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(CreacionBalotaTotal.SELECCIONAR)
        );

        actor.attemptsTo(
                WaitUntil.the(CreacionBalotaTotal.opcion(texto), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CreacionBalotaTotal.opcion(texto))
        );
    }

}
