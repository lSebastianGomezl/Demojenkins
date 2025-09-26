package tasks.creacionplantillas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.CreacionPlantillas;

import java.nio.file.Paths;

public class CargarArchivoTask implements Task {

    private final String rutaArchivo;

    public CargarArchivoTask(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public static CargarArchivoTask desdeResources(String nombreArchivo) {
        // Construye la ruta absoluta: <proyecto>/src/main/resources/<nombreArchivo>
        String ruta = Paths.get("src", "main", "resources", nombreArchivo)
                .toAbsolutePath()
                .toString();

        return Tasks.instrumented(CargarArchivoTask.class, ruta);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        CreacionPlantillas.INPUT_FILE.resolveFor(actor).sendKeys(rutaArchivo);

        actor.attemptsTo(

        );
    }
}
