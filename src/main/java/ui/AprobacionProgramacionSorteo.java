package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AprobacionProgramacionSorteo {

    public static final Target BOTON_VER_DETALLE = Target.the("botón Ver Detalle")
            .locatedBy("//i[@title='Ver Detalle' and contains(@class,'pi-chevron-right')]");

    public static final Target CAMPO_MOTIVO = Target.the("campo de texto Motivo")
            .locatedBy("//textarea[@placeholder='Escriba el motivo aquí...']");

    public static Target validacion(String texto) {
        return Target.the("botón con texto: " + texto)
                .located(By.xpath("//div[contains(@class, 'p-toast-detail') and contains(normalize-space(.), '" + texto + "')]"));
    }

    public static final Target TEXTO_GELSA = Target.the("texto GELSA")
            .locatedBy("//span[normalize-space()='GELSA']");

    public static final Target ENCABEZADO_VIGENCIA = Target.the("encabezado Vigencia de la Programación")
            .locatedBy("//th[normalize-space()='Vigencia de la Programación']");
    public static final Target BOTON_VER_ACCIONES= Target.the("botón Ver Detalle")
            .locatedBy("//i[@title='Ver Detalles' and contains(@class,'pi-chevron-right')]");

    public static final Target MENSAJE_EXITO = Target.the("mensaje éxito")
        .located(By.xpath("//p[text()=' Programación de sorteo no aprobada correctamente ']"));



}
