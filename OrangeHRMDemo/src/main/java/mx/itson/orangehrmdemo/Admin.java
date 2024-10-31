/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.orangehrmdemo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author gaspa
 */
public class Admin {
    private WebDriver driver;
    private WebDriverWait wait;
    
    private By editButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div/div[5]/div/div/div[1]/div[2]/div/div/button[2]");
    private By employeeUserNameTextField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");
    private By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]");
    private By pageTitle = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5");
   // Actualiza el localizador searchUsernameField con la nueva ruta XPath proporcionada
private By searchUsernameField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");

    private By searchButton = By.xpath("//button[@type='submit']");
    private By employeeResult = By.xpath("//div[@class='oxd-table-row']"); // Localizador para el resultado de búsqueda
    
    public Admin(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    
    public void searchEmployee(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchUsernameField)).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public boolean isEmployeeFound() {
    try {
        // Localizador para el texto de confirmación de que se encontró un registro
        By recordFoundText = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span");

        // Esperar a que aparezca el texto "(1) Record Found"
        WebElement recordFoundElement = wait.until(ExpectedConditions.visibilityOfElementLocated(recordFoundText));
        
        // Verificar que el texto encontrado contenga "(1) Record Found"
        return recordFoundElement.getText().contains("(1) Record Found");
    } catch (TimeoutException e) {
        return false;
    }
}
    
    public void deleteEmployee() {
    // Localizador para el botón de eliminar
    By deleteButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[6]/div/button[1]/i");
    
    // Localizador para el botón de confirmación en el cuadro de diálogo
    By confirmDeleteButton = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]");
    
    // Esperar y hacer clic en el botón de eliminar
    wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
    
    // Esperar y hacer clic en el botón de confirmación en el cuadro de diálogo
    wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton)).click();
}
    
    
    
    public void changePassword(String currentPassword) {
    // Localizador para el campo de contraseña actual
    By currentPasswordField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/input");
    
    // Localizador para el campo de nueva contraseña
    By newPasswordField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
    
    // Localizador para el campo de confirmación de nueva contraseña
    By confirmPasswordField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
    
    // Localizador para el botón de guardar cambios
    By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");
    
    // Espera y escribe la contraseña actual en el campo correspondiente
    wait.until(ExpectedConditions.visibilityOfElementLocated(currentPasswordField)).sendKeys(currentPassword);
    
    // Escribe la nueva contraseña en el campo de nueva contraseña
    String newPassword = "Admin1234"; // Nueva contraseña establecida en el método de prueba
    driver.findElement(newPasswordField).sendKeys(newPassword);
    
    // Confirma la nueva contraseña en el campo de confirmación
    driver.findElement(confirmPasswordField).sendKeys(newPassword);
    
    // Hacer clic en el botón "Save" para guardar el cambio de contraseña
    driver.findElement(saveButton).click();
}

    public void deleteLanguage() {
    // Localizador para el menú desplegable "Qualifications"
    By qualificationsMenu = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]/span/i");

    // Localizador para la opción "Languages" dentro de Qualifications
    By languagesOption = By.xpath("//*[text()='Languages']");

    // Localizador para el botón de eliminar el idioma
    By deleteButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[3]/div/button[1]/i");

    // Localizador para el botón de confirmación en el cuadro de diálogo
    By confirmDeleteButton = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]");

    // Hacer clic en el menú "Qualifications" para desplegar las opciones
    wait.until(ExpectedConditions.elementToBeClickable(qualificationsMenu)).click();

    // Seleccionar la opción "Languages"
    wait.until(ExpectedConditions.elementToBeClickable(languagesOption)).click();

    // Hacer clic en el botón de eliminar el idioma
    wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();

    // Confirmar la eliminación
    wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton)).click();
}

public void editSkill() throws InterruptedException {
    // Localizador para el menú desplegable "Qualifications"
    By qualificationsMenu = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]/span/i");

    // Localizador para la opción "Skills" dentro de Qualifications
    By skillsOption = By.xpath("//*[text()='Skills']");

    // Localizador para el botón de editar la habilidad
    By editButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[4]/div/button[2]/i");

    // Localizador para el campo de nombre de habilidad
    By skillNameField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input");

    // Localizador para el campo de descripción de habilidad
    By skillDescriptionField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/textarea");

    // Localizador para el botón de guardar cambios
    By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");

    // Hacer clic en el menú "Qualifications" para desplegar las opciones
    wait.until(ExpectedConditions.elementToBeClickable(qualificationsMenu)).click();
    Thread.sleep(1000); // Pausa de 1 segundo

    // Seleccionar la opción "Skills"
    wait.until(ExpectedConditions.elementToBeClickable(skillsOption)).click();
    Thread.sleep(1000);

    // Hacer clic en el botón de editar la habilidad
    wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
    Thread.sleep(1000);

    // Borrar el contenido del campo de nombre de habilidad y escribir "Content Management"
    WebElement skillNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(skillNameField));
    skillNameElement.clear();
    Thread.sleep(500); // Pausa de medio segundo para ver el campo vacío
    skillNameElement.sendKeys("Content Management");
    Thread.sleep(1000);

    // Borrar el contenido del campo de descripción de habilidad y escribir "Digital skills"
    WebElement skillDescriptionElement = driver.findElement(skillDescriptionField);
    skillDescriptionElement.clear();
    Thread.sleep(500);
    skillDescriptionElement.sendKeys("Digital skills");
    Thread.sleep(1000);

    // Hacer clic en el botón de guardar cambios
    driver.findElement(saveButton).click();
    Thread.sleep(1000); // Pausa final para observar el guardado
}




    
    public void editEmployeeUsername(String name){
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeUserNameTextField));
        driver.findElement(employeeUserNameTextField).clear();
        driver.findElement(employeeUserNameTextField).sendKeys(name);
        driver.findElement(saveButton).click();
    }
    public String getTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).toString();
    }
    
    
}