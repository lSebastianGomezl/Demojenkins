package tasks.configuracionsorteo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.ConfiguracionSorteo;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarCodigoSorteoConsultaTask implements Task {

    private final String texto;

    public IngresarCodigoSorteoConsultaTask(String texto) {
        this.texto = texto;
    }

    public static IngresarCodigoSorteoConsultaTask on(String texto){
        return instrumented(IngresarCodigoSorteoConsultaTask.class, texto);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ConfiguracionSorteo.CONSULTAR_CODIGO_UNICO, isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(texto).into(ConfiguracionSorteo.CONSULTAR_CODIGO_UNICO)
        );
    }
}
