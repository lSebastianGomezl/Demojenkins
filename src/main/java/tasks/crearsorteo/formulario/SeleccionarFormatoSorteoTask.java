package tasks.crearsorteo.formulario;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.ConfiguracionSorteo;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarFormatoSorteoTask implements Task {

    private String nombreFormato;

    public SeleccionarFormatoSorteoTask(String nombreFormato) {
        this.nombreFormato = nombreFormato;
    }

    public static Task nombreFormatoSorteo(String nombreFormato) {
        return instrumented(SeleccionarFormatoSorteoTask.class, nombreFormato);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ConfiguracionSorteo.formatoNombreSorteo(nombreFormato), isVisible()).forNoMoreThan(15).seconds(),
                Click.on(ConfiguracionSorteo.formatoNombreSorteo(nombreFormato))
        );

    }
}
