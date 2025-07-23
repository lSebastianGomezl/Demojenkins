package tasks.crearsorteo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.Dashboard;
import ui.PaginaPrincipal;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClicGestorSorteoVirtualTask implements Task {

    private final String texto;

    public ClicGestorSorteoVirtualTask(String texto) {
        this.texto = texto;
    }

    public static ClicGestorSorteoVirtualTask on(String texto){
        return instrumented(ClicGestorSorteoVirtualTask.class, texto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(Dashboard.menuLateralConTitulo(texto), isVisible()).forNoMoreThan(15).seconds(),
                Click.on(Dashboard.menuLateralConTitulo(texto))
        );
    }
}
