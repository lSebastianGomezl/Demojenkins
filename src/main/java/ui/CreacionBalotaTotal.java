package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreacionBalotaTotal {

    public static final Target NOMBRE_TIPO_BALOTA = Target.the("nombre del sorteo")
            .located(By.xpath("//input[@formcontrolname='nombreTipoBalota']"));

    public static final Target SELECCIONAR = Target.the("tipo de sorteo")
            .located(By.xpath("//span[contains(@class, 'p-dropdown-label') and normalize-space(text())='Seleccionar']"));

    public static Target opcion(String valor) {
        return Target.the("opción de tipo sorteo")
                .located(By.xpath("//li[@role='option']//span[normalize-space(text())='" + valor + "']"));
    }

    public static Target botonConTexto(String texto) {
        return Target.the("botón con texto " + texto)
                .located(By.xpath("//button[.//label[normalize-space(text())='" + texto + "']]"));
    }

    public static Target validacionCracionTipoBalota(String texto) {
        return Target.the("botón con texto: " + texto)
                .located(By.xpath("//div[contains(@class, 'p-toast-detail') and contains(normalize-space(.), '" + texto + "')]"));

    }
    public static final Target BOTON_AGREGAR_PARAMETRO = Target.the("botón para agregar parámetro")
            .locatedBy("//button[contains(.,' Agregar párametro ')]");


    public static final Target CHECKBOX_PARAMETRO = Target.the("checkbox del parámetro {0}")
            .locatedBy("//div[@role='checkbox']");

    public static final Target CAMPO_TEXTO_COLOR = Target.the("campo de texto de 9 caracteres")
            .located(By.xpath("//input[@type='text' and @maxlength='9' and @pinputtext]"));

    public static final Target BTN_GUARDAR_MODAL= Target.the("campo de texto de 9 caracteres")
            .located(By.id("btnSaveModal"));

    public static final Target ALERT_SUCCESS = Target.the("detalle del toast de éxito")
            .located(By.xpath("//div[contains(@class,'p-toast')]//div[contains(@class,'p-toast-detail')]"));


    public static final Target COLOR = Target.the("campo de texto de 9 caracteres")
            .located(By.xpath("//li[@role='option' and contains(@class,'p-dropdown-item') and @aria-label='COLOR']\n"));

}
//button[@id="btnSaveModal"]