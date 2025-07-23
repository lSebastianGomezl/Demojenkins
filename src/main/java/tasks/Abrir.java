package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import ui.PaginaPrincipal;

public class Abrir implements Task {

    private PaginaPrincipal pagina;

    public static Abrir laAplicacion() {
        return Tasks.instrumented(Abrir.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().the(pagina));
    }
}
