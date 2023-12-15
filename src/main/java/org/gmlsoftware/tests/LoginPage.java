package org.gmlsoftware.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class LoginPage {
    WebDriver driver;

    // Localizadores de elementos utilizando la anotación @FindBy
    @FindBy(id = "identifierId")
    WebElement emailField;
    @FindBy(id = "identifierNext")
    WebElement nextButton;
    @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div/div[2]/div/div[2]/c-wiz/div/div[1]")
    WebElement emailElement;
    @FindBy(id = "passwordNext")
    WebElement nextButton2;
    @FindBy(xpath = "//*[@id=\"gb\"]/div/div[2]/div[2]/div/a")
    WebElement userButton;

    // Constructor que inicializa el WebDriver y los elementos de la página
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Método para establecer el correo electrónico en el campo correspondiente
    public void setEmail(String email) {
        emailField.sendKeys(email);
    }

    // Método para hacer clic en el botón "Siguiente" en la primera pantalla de inicio de sesión
    public void clickNext() {
        nextButton.click();
    }

    // Método para hacer clic en el botón "Siguiente" en la segunda pantalla de inicio de sesión
    public void clickNext2() {
        nextButton2.click();
    }

    // Método para establecer la contraseña en el campo correspondiente
    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    // Método para hacer clic en el botón de usuario
    public void userButton() {
        userButton.click();
    }

    // Método para obtener el texto del elemento de correo electrónico
    public String getEmailText() {
        return emailElement.getText();
    }

    // Método para verificar si el correo electrónico está presente en el cuerpo de la página
    public boolean isEmailPresentInBody(String email) {
        List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(),'" + email + "')]"));
        return !elements.isEmpty();
    }
}
