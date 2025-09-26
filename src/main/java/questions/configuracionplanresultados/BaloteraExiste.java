package questions.configuracionplanresultados;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import ui.PlanDeResultado;

import java.util.List;

public class BaloteraExiste implements Question<Boolean> {

    private final String nombreBalotera;

    public BaloteraExiste(String nombreBalotera) {
        this.nombreBalotera = nombreBalotera;
    }

    public static BaloteraExiste conNombre(String nombreBalotera) {
        return new BaloteraExiste(nombreBalotera);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return PlanDeResultado.LISTA_BALOTERAS.resolveAllFor(actor)
                .stream()
                .map(element -> element.getText().trim())
                .anyMatch(n -> n.equalsIgnoreCase(nombreBalotera));
    }

}
