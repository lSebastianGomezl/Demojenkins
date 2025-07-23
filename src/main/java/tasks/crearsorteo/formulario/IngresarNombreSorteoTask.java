package tasks.crearsorteo.formulario;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.ConfiguracionSorteo;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarNombreSorteoTask implements Task {

    private final String texto;

    public IngresarNombreSorteoTask(String texto) {
        this.texto = texto;
    }

    public static IngresarNombreSorteoTask on(String texto){
        return instrumented(IngresarNombreSorteoTask.class, texto);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ConfiguracionSorteo.NOMBRE_SORTEO, isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(texto).into(ConfiguracionSorteo.NOMBRE_SORTEO)
        );
    }
}
