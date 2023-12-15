package org.gmlsoftware.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestLogin {
    @Test
    public void testLogin() throws IOException {
        // Cargar las propiedades desde el archivo de configuración
        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
        prop.load(ip);

        // Inicializar el WebDriver (ChromeDriver en este caso)
        WebDriver driver = new ChromeDriver();

        // Inicializar la página de inicio de sesión
        LoginPage loginPage = new LoginPage(driver);

        // Configurar el tiempo de espera
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        // Abrir la aplicación en la URL especificada en el archivo de propiedades
        driver.get(prop.getProperty("AppURL"));

        // Ingresar el correo electrónico y hacer clic en "Siguiente"
        loginPage.setEmail(prop.getProperty("Mail"));
        loginPage.clickNext();

        // Imprimir en la consola la propiedad "pruebaElemento" del archivo de propiedades
        System.out.println(prop.getProperty("pruebaElemento"));

        // Esperar a que el campo de contraseña sea cliclable
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.passwordField));

        // Ingresar la contraseña y hacer clic en "Siguiente"
        loginPage.setPassword(prop.getProperty("Password"));
        loginPage.clickNext2();

        // Esperar a que el botón de usuario sea visible
        wait.until(ExpectedConditions.visibilityOf(loginPage.userButton));

        // Hacer clic en el botón de usuario
        loginPage.userButton();

        // Verificar si el correo electrónico está presente en el cuerpo de la página
        boolean emailPresentInBody = loginPage.isEmailPresentInBody(prop.getProperty("Mail"));

        // Afirmar que el correo electrónico está presente en el cuerpo de la página
        Assertions.assertTrue(emailPresentInBody, "El correo electrónico no está presente en el cuerpo de la página web");

        // Cerrar el WebDriver al finalizar la prueba
        driver.quit();
    }
}