package tasks.creartipobalota;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.CreacionBalotaTotal;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarColorTask implements Task {

    private final String texto;

    public IngresarColorTask(String texto) {
        this.texto = texto;
    }

    public static IngresarColorTask on(String texto){
        return instrumented(IngresarColorTask.class, texto);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CreacionBalotaTotal.CAMPO_TEXTO_COLOR, isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(texto).into(CreacionBalotaTotal.CAMPO_TEXTO_COLOR)
        );
    }
}
