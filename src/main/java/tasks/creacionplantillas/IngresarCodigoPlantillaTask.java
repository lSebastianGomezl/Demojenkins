package tasks.creacionplantillas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.ConfiguracionSorteo;
import ui.CreacionPlantillas;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarCodigoPlantillaTask implements Task {

    private final String texto;

    public IngresarCodigoPlantillaTask(String texto) {
        this.texto = texto;
    }

    public static IngresarCodigoPlantillaTask on(String texto){
        return instrumented(IngresarCodigoPlantillaTask.class, texto);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CreacionPlantillas.CODIGO_UNICO, isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(texto).into(CreacionPlantillas.CODIGO_UNICO)
        );
    }
}
