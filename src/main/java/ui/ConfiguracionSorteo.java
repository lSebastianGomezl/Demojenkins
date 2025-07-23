package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConfiguracionSorteo {

    public static Target tituloInformacionSorteo(String texto) {
        return Target.the("título del panel con texto " + texto)
                .located(By.xpath("//div[contains(@id, 'p-panel') and contains(@class, 'p-panel-header')]//span[contains(@class, 'sub-title') and normalize-space(text())='" + texto + "']"));

    }
    public static final Target EMPRESA_PROPIETARIA = Target.the("empresa propietaria")
            .located(By.xpath("//span[contains(@class, 'p-dropdown-label') and text()='Seleccionar']"));

    public static Target valorEmpresaPropietaria(String valor) {
        return Target.the("opción del dropdown")
                .located(By.xpath("//li[@role='option' and @aria-label='" + valor + "']"));
    }
    public static final Target NOMBRE_SORTEO = Target.the("nombre del sorteo")
            .located(By.xpath("//input[@formcontrolname='nombreSorteo']"));

    public static final Target CODIGO_UNICO = Target.the("código único del sorteo")
            .located(By.xpath("//input[@formcontrolname='codigoUnico']"));

    public static final Target TIPO_SORTEO = Target.the("tipo de sorteo")
            .located(By.xpath("//span[contains(@class, 'p-dropdown-label') and normalize-space(text())='Seleccionar']"));
    public static Target valorTipoDeSorte(String valor) {
        return Target.the("opción de tipo sorteo")
                .located(By.xpath("//li[@role='option']//span[normalize-space(text())='" + valor + "']"));
    }
    public static final Target DESCRIPCION = Target.the("descripción")
            .located(By.xpath("//textarea[@formcontrolname='descripcionSorteo']"));
    public static final Target FECHA_INICIO = Target.the("fecha de inicio")
            .located(By.id("fechaInicio"));
    public static final Target FECHA_FIN = Target.the("fecha de fin")
            .located(By.id("fechaFin"));

    public static Target formatoNombreSorteo(String texto) {
        return Target.the("botón con texto: " + texto)
                .located(By.xpath("//button[contains(normalize-space(.), '" + texto + "')]"));
    }

    public static final Target ALERT_SUCCESSFUL = Target.the("Creacion de sorteo exitoso")
            .located(By.xpath("//div[contains(@class, 'p-toast-detail') and contains(normalize-space(.), 'Configuración de sorteo creado exitosamente.')]"));

    public static Target validacionCracionSorteo(String texto) {
        return Target.the("botón con texto: " + texto)
                .located(By.xpath("//div[contains(@class, 'p-toast-detail') and contains(normalize-space(.), '" + texto + "')]"));
    }




}
