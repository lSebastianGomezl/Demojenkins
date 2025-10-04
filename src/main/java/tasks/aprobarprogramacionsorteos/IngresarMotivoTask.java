package tasks.aprobarprogramacionsorteos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.Keys;
import ui.AprobacionProgramacionSorteo;
import ui.ConfiguracionParametros;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarMotivoTask implements Task {

    private final String valor;

    public IngresarMotivoTask(String valor) {
        this.valor = valor;
    }
    public static IngresarMotivoTask on(String valor) {
        return instrumented(IngresarMotivoTask.class, valor);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(valor).into(AprobacionProgramacionSorteo.CAMPO_MOTIVO)
        );
    }
}
