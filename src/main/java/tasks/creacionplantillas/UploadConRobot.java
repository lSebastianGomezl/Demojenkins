package tasks.creacionplantillas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import ui.CreacionPlantillas;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadConRobot implements Task {

    private final String rutaArchivo;

    public UploadConRobot(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public static UploadConRobot desde(String rutaArchivo) {
        return Tasks.instrumented(UploadConRobot.class, rutaArchivo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Click en el botón que abre la ventana de archivos
        actor.attemptsTo(Click.on(CreacionPlantillas.BTN_EXAMINAR));

        try {
            Robot robot = new Robot();
            robot.delay(2000); // espera a que aparezca la ventana

            // Normalizar la ruta → usar "/" en lugar de "\"
            String rutaNormalizada = rutaArchivo.replace("\\", "/");

            // Copiar ruta al portapapeles
            StringSelection selection = new StringSelection(rutaNormalizada);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

            // CTRL + V para pegar la ruta
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.delay(500);

            // ENTER para confirmar
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (Exception e) {
            throw new RuntimeException("Error al usar Robot", e);
        }
    }
}
