package tasks.configuracionsorteo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import ui.ConfiguracionSorteo;
import utils.GeneradorDatos;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarDiaActualTask implements Task {

    private final String dia;

    public SeleccionarDiaActualTask(String dia) {
        this.dia = dia;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("este es el dia : " + dia);

        if (!"1".equals(dia)) {
            // Si NO es domingo, hace clic en domingo primero
            actor.attemptsTo(
                    Click.on(Target.the("Domingo")
                            .locatedBy("//label[@for='dia1' and text()='Domingo']"))
            );
        }

        // Luego selecciona el día actual
        actor.attemptsTo(
                Click.on(ConfiguracionSorteo.DIA_SEMANA(dia))
        );

    }


    public static SeleccionarDiaActualTask hoy() {
        return instrumented(SeleccionarDiaActualTask.class, GeneradorDatos.obtenerValorDiaSemana());
    }
}
