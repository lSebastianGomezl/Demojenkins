package tasks.login;

import models.DatosUsuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.PaginaPrincipal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class IngresarDatosLoginTask implements Task {

    private DatosUsuario datosUsuario;

    public IngresarDatosLoginTask(DatosUsuario datosUsuario) {
        this.datosUsuario = datosUsuario;
    }

    public static IngresarDatosLoginTask credenciales(DatosUsuario datosUsuario) {
        return Tasks.instrumented(IngresarDatosLoginTask.class, datosUsuario);
    }

    private static Properties loadProperties(String filePath) {
        Properties properties = new Properties();
        try (InputStream input = IngresarDatosLoginTask.class.getClassLoader().getResourceAsStream(filePath)) {
            if (input == null) {
                System.out.println("Sorry, unable to find " + filePath);
                return properties;
            }

            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        String documentType = datosUsuario.getTipoDocumento();
        String user = datosUsuario.getUsuario();
        String password = datosUsuario.getContrasenna();


        actor.attemptsTo(
                Click.on(PaginaPrincipal.TIPO_DOCUMENTO),
                Click.on(PaginaPrincipal.TIPO_DOCUMENTO_OPTION.of(documentType)),
                Enter.theValue(user).into(PaginaPrincipal.USER),
                Enter.theValue(password).into(PaginaPrincipal.PASSWORD)

        );

        }
    }

