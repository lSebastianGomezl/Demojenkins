package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Dashboard {

    public static final Target TITULO_DASHBOARD = Target.the("título del Dashboard")
            .located(By.xpath("//span[contains(@class, 'miga-modulo') and text()='GSV']"));


    public static Target menuLateralConTitulo(String titulo) {
        return Target.the("menú lateral con título " + titulo)
                .located(By.xpath("//div[@title='Gestor Sorteo Virtual' and contains(text(), '"+ titulo+"')]"));
    }

    public static Target submenuConTitulo(String titulo) {
        return Target.the("submenú con título " + titulo)
                .located(By.xpath("//a[@title='" + titulo + "']"));
    }
    public static Target botonConTexto(String texto) {
        return Target.the("botón con texto " + texto)
                .located(By.xpath("//button[.//label[normalize-space(text())='" + texto + "']]"));
    }










}
