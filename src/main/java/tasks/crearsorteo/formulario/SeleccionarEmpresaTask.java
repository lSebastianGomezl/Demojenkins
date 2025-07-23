package tasks.crearsorteo.formulario;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.ConfiguracionSorteo;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarEmpresaTask implements Task {

    private String empresa;

    public SeleccionarEmpresaTask(String empresa) {
        this.empresa = empresa;
    }

    public static Task empresaPropietaria(String empresa) {
        return instrumented(SeleccionarEmpresaTask.class, empresa);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ConfiguracionSorteo.EMPRESA_PROPIETARIA, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(ConfiguracionSorteo.EMPRESA_PROPIETARIA)
        );

        actor.attemptsTo(
                WaitUntil.the(ConfiguracionSorteo.valorEmpresaPropietaria(empresa), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ConfiguracionSorteo.valorEmpresaPropietaria(empresa))
        );
    }
}
