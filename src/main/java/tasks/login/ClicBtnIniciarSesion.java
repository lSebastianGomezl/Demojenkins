package tasks.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import ui.PaginaPrincipal;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClicBtnIniciarSesion implements Task {


    public static ClicBtnIniciarSesion on(){
        return instrumented(ClicBtnIniciarSesion.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(PaginaPrincipal.BTN_SING_IN)
        );

    }
}
