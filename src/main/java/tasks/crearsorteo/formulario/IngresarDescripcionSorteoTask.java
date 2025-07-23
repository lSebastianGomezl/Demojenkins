package tasks.crearsorteo.formulario;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.ConfiguracionSorteo;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarDescripcionSorteoTask implements Task {

    private final String texto;

    public IngresarDescripcionSorteoTask(String texto) {
        this.texto = texto;
    }

    public static IngresarDescripcionSorteoTask on(String texto){
        return instrumented(IngresarDescripcionSorteoTask.class, texto);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ConfiguracionSorteo.DESCRIPCION, isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(texto).into(ConfiguracionSorteo.DESCRIPCION)
        );
    }
}
