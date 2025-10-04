package tasks.aprobarprogramacionsorteos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.ConfiguracionParametros;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClicEmpresaPropietariaTask implements Task {


    private final String nombreEmpresa;

    public ClicEmpresaPropietariaTask(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public static ClicEmpresaPropietariaTask on(String nombreEmpresa) {
        return instrumented(ClicEmpresaPropietariaTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ConfiguracionParametros.EMPRESA_PROPIETARIA, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(ConfiguracionParametros.EMPRESA_PROPIETARIA)
        );

        actor.attemptsTo(
                WaitUntil.the(ConfiguracionParametros.OPCION_EMPRESA(nombreEmpresa), isVisible()).forNoMoreThan(15).seconds(),
                Click.on(ConfiguracionParametros.OPCION_EMPRESA(nombreEmpresa))
        );
    }
}
