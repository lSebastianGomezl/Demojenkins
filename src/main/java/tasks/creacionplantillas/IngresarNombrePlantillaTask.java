package tasks.creacionplantillas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.ConfiguracionSorteo;
import ui.CreacionPlantillas;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarNombrePlantillaTask implements Task {

    private final String texto;

    public IngresarNombrePlantillaTask(String texto) {
        this.texto = texto;
    }

    public static IngresarNombrePlantillaTask on(String texto){
        return instrumented(IngresarNombrePlantillaTask.class, texto);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CreacionPlantillas.NOMBRE_PLANTILLA, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(CreacionPlantillas.NOMBRE_PLANTILLA),
                Enter.theValue(texto).into(CreacionPlantillas.NOMBRE_PLANTILLA)
        );
    }
}
