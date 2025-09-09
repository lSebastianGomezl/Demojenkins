package tasks.creartipobalota;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.CreacionBalotaTotal;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarNombreTipoBalotaTask implements Task {

    private final String texto;

    public IngresarNombreTipoBalotaTask(String texto) {
        this.texto = texto;
    }

    public static IngresarNombreTipoBalotaTask on(String texto){
        return instrumented(IngresarNombreTipoBalotaTask.class, texto);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CreacionBalotaTotal.NOMBRE_TIPO_BALOTA, isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(texto).into(CreacionBalotaTotal.NOMBRE_TIPO_BALOTA)
        );
    }
}
