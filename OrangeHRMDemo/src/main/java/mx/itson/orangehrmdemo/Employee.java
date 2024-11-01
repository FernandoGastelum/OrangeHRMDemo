/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.orangehrmdemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
/**
 *
 * @author gaspa
 */
public class Employee {
    private WebDriver driver;
    private WebDriverWait wait;

    // Localizadores para los campos en la sección de Empleados
    private By addEmployeeButton = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]/a");
    private By firstNameField = By.name("firstName");
    private By lastNameField = By.name("lastName");
    private By middleNameField = By.name("middleName");
    private By employeeIdField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input");
    private By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]");
    private By searchEmployeeField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[1]/h6");
    private By searchButton = By.id("searchBtn");
    private By employeeName = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[1]/h6");
    private By PIMButton = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a");
    private By reportsButton = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]");
    private By addReportButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
    private By reportNameTextField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/input");
    
    

    // Constructor
    public Employee(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // Método para agregar un nuevo empleado
    public void addEmployee(String firstName, String middleName, String lastName, String employeeId) {
        wait.until(ExpectedConditions.elementToBeClickable(PIMButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addEmployeeButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(middleNameField).sendKeys(middleName);
        driver.findElement(employeeIdField).clear();
        driver.findElement(employeeIdField).sendKeys(employeeId);
        driver.findElement(saveButton).click();
    }

    // Método para buscar y validar que un empleado fue agregado
    public boolean isEmployeeAdded(String employeeName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchEmployeeField)).sendKeys(employeeName);
        driver.findElement(searchButton).click();
        // Verifica si el empleado aparece en los resultados
        return driver.findElements(By.xpath("//a[text()='" + employeeName + "']")).size() > 0;
    }

    // Método para editar un empleado existente
    public void editEmployee(String employeeName, String newLastName) {
        if (isEmployeeAdded(employeeName)) {
            WebElement employeeLink = driver.findElement(By.xpath("//a[text()='" + employeeName + "']"));
            employeeLink.click();
            WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));
            editButton.click();
            WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
            lastNameField.clear();
            lastNameField.sendKeys(newLastName);
            driver.findElement(saveButton).click();
        }
    }
    public boolean getEmployeeName(){
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(employeeName));
        return titleElement.isDisplayed();
    }
    public void viewReport(){
        
    }
}
