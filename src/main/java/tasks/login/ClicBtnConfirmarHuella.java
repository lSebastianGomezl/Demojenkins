package tasks.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.PaginaPrincipal;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class ClicBtnConfirmarHuella implements Task {


    public static ClicBtnConfirmarHuella on(){

        return instrumented(ClicBtnConfirmarHuella.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(PaginaPrincipal.BTN_ACEPTAR_HUELLA, isNotVisible()).forNoMoreThan(60).seconds(),
                Click.on(PaginaPrincipal.BTN_ACEPTAR_HUELLA)
        );

    }
}
