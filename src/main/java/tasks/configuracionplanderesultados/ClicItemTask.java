package tasks.configuracionplanderesultados;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.ConfiguracionSorteo;
import ui.PlanDeResultado;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClicItemTask implements Task {

    private final String texto;

    public ClicItemTask(String texto) {
        this.texto = texto;
    }

    public static ClicItemTask conTexto(String texto) {
        return instrumented(ClicItemTask.class, texto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PlanDeResultado.TAB_BY_TITLE.of(texto), isVisible()).forNoMoreThan(15).seconds(),
                Click.on(PlanDeResultado.TAB_BY_TITLE.of(texto))
        );
    }
}
