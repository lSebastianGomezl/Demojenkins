package stepdefinition.login;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.*;
import models.DatosUsuario;

import net.serenitybdd.screenplay.actors.OnStage;
import questions.login.PaginaDashboard;
import tasks.Abrir;
import tasks.login.*;


import java.util.Map;
import java.util.logging.Logger;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class LoginStepDefinition {


    private static final Logger LOGGER = Logger.getLogger(LoginStepDefinition.class.getName());

    @Dado("que el actor abre la aplicación")
    public void queElActorAbreLaAplicación() {
        LOGGER.info("==> Abriendo la aplicación web");
        OnStage.theActorInTheSpotlight().attemptsTo(
                Abrir.laAplicacion()
        );
        LOGGER.info("Actor activo: " + OnStage.theActorInTheSpotlight().getName());
    }

    @Dado("diligencia el formulario de login con los siguientes datos:")
    public void diligenciaElFormularioDeLoginConLosSiguientesDatos(DataTable dataTable) {
        Map<String, String> entry = dataTable.asMaps().get(0);

        DatosUsuario usuario = new DatosUsuario(
                entry.get("tipoDocumento"),
                entry.get("usuario"),
                entry.get("contrasenna")
        );

        LOGGER.info("==> Ingresando credenciales:");
        LOGGER.info("    Tipo de documento: " + usuario.getTipoDocumento());
        LOGGER.info("    Usuario: " + usuario.getUsuario());
        LOGGER.info("    Contraseña: ********");

        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarDatosLoginTask.credenciales(usuario)
        );
    }

    @Dado("hace clic en el botón validar biometrico")
    public void haceClicEnElBotónValidarBiometrico() {
        LOGGER.info("==> Clic en el botón Validar Biométrico");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicValidarBiometrico.on()
        );
    }

    @Dado("hace clic en el botón Iniciar sesión")
    public void haceClicEnElBotónIniciarSesión() {
        LOGGER.info("==> Clic en el botón Iniciar Sesión");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicBtnIniciarSesion.on()
        );
    }

    @Dado("acepta la primera alerta")
    public void aceptaLaPrimeraAlerta() {
        LOGGER.info("==> Acepta la primera alerta (Huella)");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicBtnAceptarHuella.on()
        );
    }

    @Dado("acepta la segunda alerta")
    public void aceptaLaSegundaAlerta() {
        LOGGER.info("==> Acepta la segunda alerta (Confirmación de huella)");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicBtnConfirmarHuella.on()
        );
    }

    @Entonces("debería ver la página de {string}")
    public void deberíaVerLaPáginaDe(String paginaEsperada) {
        LOGGER.info("==> Validando que se muestra la página: " + paginaEsperada);
        OnStage.theActorInTheSpotlight().should(
                seeThat(PaginaDashboard.esVisible(paginaEsperada))
        );
    }
}
