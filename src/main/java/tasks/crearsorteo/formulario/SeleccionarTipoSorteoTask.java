package tasks.crearsorteo.formulario;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.ConfiguracionSorteo;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarTipoSorteoTask implements Task {

    private String sorteo;

    public SeleccionarTipoSorteoTask(String sorteo) {
        this.sorteo = sorteo;
    }

    public static Task tipoSorteo(String sorteo) {
        return instrumented(SeleccionarTipoSorteoTask.class, sorteo);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ConfiguracionSorteo.TIPO_SORTEO, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(ConfiguracionSorteo.TIPO_SORTEO)
        );

        actor.attemptsTo(
                WaitUntil.the(ConfiguracionSorteo.valorEmpresaPropietaria(sorteo), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ConfiguracionSorteo.valorTipoDeSorte(sorteo))
        );
    }
}
