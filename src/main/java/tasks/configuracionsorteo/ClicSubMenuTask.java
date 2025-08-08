package tasks.configuracionsorteo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.ConfiguracionSorteo;
import ui.Dashboard;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClicSubMenuTask implements Task {

    private final String texto;

    public ClicSubMenuTask(String texto) {
        this.texto = texto;
    }

    public static ClicSubMenuTask conTexto(String texto) {
        return instrumented(ClicSubMenuTask.class, texto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ConfiguracionSorteo.botonSubMenu(texto), isVisible()).forNoMoreThan(15).seconds(),
                Click.on(ConfiguracionSorteo.botonSubMenu(texto))
        );
    }
}
