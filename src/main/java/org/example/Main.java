package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.pdfbox.pdmodel.interactive.viewerpreferences.PDViewerPreferences;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    private static WebDriver driver;
    private String testUrl = "https://pagatodowebqa.dcsas.com.co:8123/index.html#login";

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.MICROSECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void login(){
        WebElement botonIniciarSesion;

        driver.get(testUrl);

        botonIniciarSesion = driver.findElement(By.cssSelector("flt-semantics[@aria-label=\"Iniciar sesión\"]"));
        botonIniciarSesion.click();

    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}