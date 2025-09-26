package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreacionPlantillas {

    public static final Target NOMBRE_PLANTILLA = Target.the("campo nombre de la plantilla")
            .located(By.cssSelector("input[formcontrolname='name']"));

    public static final Target CODIGO_UNICO = Target.the("código único del sorteo")
            .located(By.xpath("//input[@formcontrolname='code']"));

    public static final Target DESCRIPCION = Target.the("descripción")
            .located(By.xpath("//textarea[@formcontrolname='description']"));

    public static final Target INPUT_FILE = Target.the("input de carga de archivo")
            .located(By.cssSelector("input[type='file']"));

    public static final Target BTN_EXAMINAR = Target.the("input oculto de archivo")
            .located(By.id("image_botonExaminar"));

}
