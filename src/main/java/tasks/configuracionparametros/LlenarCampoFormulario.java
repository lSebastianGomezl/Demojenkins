package tasks.configuracionparametros;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import ui.ConfiguracionParametros;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LlenarCampoFormulario implements Task {

    private final String campo;
    private final String valor;

    public LlenarCampoFormulario(String campo, String valor) {
        this.campo = campo;
        this.valor = valor;
    }

    public static LlenarCampoFormulario conValor(String campo, String valor) {
        return instrumented(LlenarCampoFormulario.class, campo, valor);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(ConfiguracionParametros.SELECCIONAR_TITULO_FORMULARIO(campo)),
                Click.on(ConfiguracionParametros.OPCION_DROPDOWN.of(valor))
        );

        actor.attemptsTo(
                Click.on(ConfiguracionParametros.SELECCIONAR_TITULO_FORMULARIO(campo)),
                Click.on(ConfiguracionParametros.OPCION_DROPDOWN.of(valor))
        );


    }
}
