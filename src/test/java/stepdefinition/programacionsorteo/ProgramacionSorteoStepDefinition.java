package stepdefinition.programacionsorteo;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import models.DatosUsuario;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.configuracionsorteo.ConfiguracionSorteoQuestion;
import questions.login.PaginaDashboard;
import stepdefinition.login.LoginStepDefinition;
import tasks.Abrir;
import tasks.configuracionsorteo.*;
import tasks.crearsorteo.ClicBtoCrearSorteoTask;
import tasks.crearsorteo.ClicConfiguracionSorteoslTask;
import tasks.crearsorteo.ClicGestorSorteoVirtualTask;
import tasks.login.*;
import utils.GeneradorDatos;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ProgramacionSorteoStepDefinition {
    private static final Logger LOGGER = Logger.getLogger(LoginStepDefinition.class.getName());
    private Map<String, String> datosDinamicos = new HashMap<>();
    private boolean validarFechaInvalida = false;

    @Before
    public void prepararDatosDinamicos() {
        String nombreSorteo = GeneradorDatos.nombreDeSorteoUnico();
        String codigoUnico = GeneradorDatos.codigoUnico();
        String fechaActual = GeneradorDatos.fechaActual();
        String fechaInvalida = GeneradorDatos.fechaAnterior();
        //String fechaFormat  = GeneradorDatos.obtenerFechaActualFormateada();


        Serenity.setSessionVariable("nombreSorteo").to(nombreSorteo);
        Serenity.setSessionVariable("codigoUnico").to(codigoUnico);
        Serenity.setSessionVariable("fechaActual").to(fechaActual);
        Serenity.setSessionVariable("fechaInvalida").to(fechaInvalida);
        //Serenity.setSessionVariable("fechaFormat").to(fechaFormat);
    }

    private String valor(String input) {
        switch (input) {
            case "dinamico":
                return Serenity.sessionVariableCalled("nombreSorteo");
            case "autoincremental":
                return Serenity.sessionVariableCalled("codigoUnico");
            case "fechaActual":
                return Serenity.sessionVariableCalled("fechaActual");
            case "fechaInvalida":
                return Serenity.sessionVariableCalled("fechaInvalida");
            case "fechaFormat":
                return Serenity.sessionVariableCalled("fechaFormat");
            default:
                return input;
        }
    }

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

    @Cuando("el usuario ingresa al menú lateral {string}")
    public void elUsuarioIngresaAlMenúLateral(String tituloMenu) {
        LOGGER.info("==> Ingresa al menu de GSV");
        //System.out.println(tituloMenu);
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicGestorSorteoVirtualTask.on(tituloMenu)
        );
    }

    @Cuando("selecciona el submenú {string}")
    public void seleccionaElSubmenú(String tituloSubmenu) {
        LOGGER.info("==> Ingresa al sub menu configuracion de sorteo");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicConfiguracionSorteoslTask.on(tituloSubmenu)
        );
    }

    @Entonces("debería abrirse una nueva ventana con el buscador de sorteos {string}")
    public void deberíaAbrirseUnaNuevaVentanaConElBuscadorDeSorteos(String tituloEsperado) {
        LOGGER.info("==> Validando que se muestra la página: " + tituloEsperado);
        OnStage.theActorInTheSpotlight().should(
                seeThat(PaginaDashboard.esVisible(tituloEsperado))
        );
    }

    @Cuando("ingresa el codigo numero {string} en el codigo unico de sorteo")
    public void ingresaElCodigoNumeroEnElCodigoUnicoDeSorteo(String codSorteo) {
        LOGGER.info("==> Ingresando el codigo de sorteo a consultar: ");
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarCodigoSorteoConsultaTask.on(codSorteo)
        );
    }
    @Cuando("el usuario da clic en el botón {string}")
    public void elUsuarioDaClicEnElBotón(String textoBoton) {
        LOGGER.info("==> Da clic en el boton de consultar");
        System.out.println("Texto del boton" + textoBoton);
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicBtoCrearSorteoTask.conTexto(textoBoton)
        );
    }
    @Cuando("el usuario da clic en la accion editar del codigo de sorteo {string}")
    public void elUsuarioDaClicEnLaAccionEditarDelCodigoDeSorteo(String editarSorteo) {
        LOGGER.info("==> Da clic en el icono de editar sorteo");
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarEditarSorteoTask.editarSorteo(editarSorteo)
        );

    }
    @Cuando("el usuario ingresa al menú {string}")
    public void elUsuarioIngresaAlMenú(String txtMenu) {
        LOGGER.info("==> Da clic en el sub menu de Programaciones de sorteo");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicSubMenuTask.conTexto(txtMenu)
        );

    }

    @Cuando("el usuario da de nuevo clic en el botón {string}")
    public void elUsuarioDaDeNuevoClicEnElBotón(String textoBoton) {

        LOGGER.info("==> Da clic en el boton de Nueva Programacion");
        System.out.println("Texto del boton" + textoBoton);
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicBtoCrearSorteoTask.conTexto(textoBoton)
        );
    }

    @Cuando("el usuario elige si es una {string}")
    public void elUsuarioEligeSiEsUna(String tipoFecha) {
        LOGGER.info("==> Da clic el seleccion de tipo de fecha");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ElegirTipoDeFechaTask.on(tipoFecha)
        );
    }

    @Cuando("la fecha de inicio fecha y {string} de ejecucion del sorteo")
    public void laFechaDeInicioFechaYDeEjecucionDelSorteo(String hora) {
        LOGGER.info("==> Ingresa la fecha y hora del sorteo");
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarFechaSorteoTask.on(),
                IngresarHoraSorteoTask.on(hora)
        );

    }
    @Cuando("el usuario hace clic en {string} en el modal")
    public void elUsuarioHaceClicEnEnElModal(String texto) {
        LOGGER.info("==> Da clic en el boton guardar programacion");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicBtoCrearSorteoTask.conTexto(texto)
        );
    }
    @Entonces("debería aparecer un modal de confirmación {string}")
    public void deberíaAparecerUnModalDeConfirmación(String textoAlerta) {
        LOGGER.info("==> Valida la alert de la creacion de configuracion de sorteo exitoso");
        OnStage.theActorInTheSpotlight().should(
                seeThat(ConfiguracionSorteoQuestion.configuracionSorteoSuccessful(textoAlerta))
        );
    }
    @Cuando("el usuario ingresa la fecha rango inicial y rango final y la {string} y {string}")
    public void elUsuarioIngresaLaFechaRangoInicialYRangoFinalYLaY(String horaInicial, String horaFinal) {
        LOGGER.info("==> Valida el ingreso de fecha de rango inicial, final y de igual manera la hora inicial y final");
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarFechaInicioSorteoTask.on(),
                IngresarFechaFinalSorteoTask.on(),
                IngresarHoraInicialSorteoTask.on(horaInicial),
                IngresarHoraFinalSorteoTask.on(horaFinal)
        );


    }

    @Cuando("el usuario selecciona el item mes")
    public void elUsuarioSeleccionaElItemMes() {
        LOGGER.info("el usuario selecciona el item del mes");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicItemMesTask.on()
        );
    }
    @Cuando("el usuario selecciona el mes especifico")
    public void elUsuarioSeleccionaElMesEspecifico() {
        LOGGER.info("El usuario selecciona un mes despues del actual");
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarMesActual.on()
        );
    }
    @Cuando("el usuario selecciona el item dias")
    public void elUsuarioSeleccionaElItemDias() {
        LOGGER.info("El usuario ingresa al item de dias");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicItemDiasTask.on(),
                SeleccionaDiaEspecificoTask.on(),
                SeleccionarDiaActualTask.hoy()
        );
    }

        @Cuando("el usuario selecciona el item de horas")
        public void elUsuarioSeleccionaElItemDeHoras() {
            LOGGER.info("El usuario ingresa al item de horas");
            OnStage.theActorInTheSpotlight().attemptsTo(
                    ClicItemHorasTask.on()
            );
        }
        @Cuando("el usuario selecciona la {string} y la {string} programadas")
        public void elUsuarioSeleccionaLaYLaProgramadas(String horaInicial, String horaFinal) {
            LOGGER.info("El usuario selecciona las horas programadas anteriormente");
            OnStage.theActorInTheSpotlight().attemptsTo(
                    SeleccionaHorasProgramadasTask.on(horaInicial,horaFinal)
            );
        }
    }



