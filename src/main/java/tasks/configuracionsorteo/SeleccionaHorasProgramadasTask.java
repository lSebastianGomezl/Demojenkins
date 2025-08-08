package tasks.configuracionsorteo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import ui.ConfiguracionSorteo;
import utils.GeneradorDatos;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionaHorasProgramadasTask implements Task {

    public String horaInicial;
    public String horaFinal;

    public SeleccionaHorasProgramadasTask(String horaInicial, String horaFinal) {
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String horaI = GeneradorDatos.extraerHora(horaInicial);
        String horaF = GeneradorDatos.extraerHora(horaFinal);
        System.out.println("Horas generadas inicial" + horaI);
        System.out.println("Horas generadas final" + horaF);

        actor.attemptsTo(
                Click.on("//label[@for='hora0']"),
                Click.on(ConfiguracionSorteo.HORA_ESPECIFICA(horaI)),
                Click.on(ConfiguracionSorteo.HORA_ESPECIFICA(horaF))
        );
    }

    public static SeleccionaHorasProgramadasTask on(String horaInicial, String horaFinal) {
        return instrumented(SeleccionaHorasProgramadasTask.class,horaInicial,horaFinal);
    }

}
