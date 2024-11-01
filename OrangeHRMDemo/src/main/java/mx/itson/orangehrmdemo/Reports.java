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

public class Reports {

    private WebDriver driver;
    private WebDriverWait wait;

    // Localizadores de los elementos de la sección de reportes
    private By reportMenu = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]");
    private By reportNameField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div/div/div[2]/div/div/input");
    private By searchButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");
    private By generatedReportSection = By.id("resultTable");
    private By consultReportButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div/div/div/div/div/div[2]/div/div/button[3]");
    private By reportTitle = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/h6");
    private By expandEmployeeReportsBtn = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div[3]");
    private WebElement errorMessageText;
    

    // Constructor
    public Reports(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
    }

    // Método para acceder a la sección de reportes
    public void goToReportsSection() {
        wait.until(ExpectedConditions.elementToBeClickable(reportMenu)).click();
    }

    // Método para buscar un reporte por nombre
    public void searchReportByName(String reportName) {
        goToReportsSection();
        wait.until(ExpectedConditions.visibilityOfElementLocated(expandEmployeeReportsBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(reportNameField)).sendKeys(reportName);
        driver.findElement(searchButton).click();
    }

    // Método para verificar si el reporte está disponible en la lista generada
    public boolean isReportAvailable(String reportName) {
        return driver.findElements(By.xpath("//a[text()='" + reportName + "']")).size() > 0;
    }
    
    public String getErrorMessage(){
        errorMessageText = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div/div/span"));
        return errorMessageText.getText();
    }
    public void goToDetailsReport(){
        wait.until(ExpectedConditions.elementToBeClickable(consultReportButton)).click();
    }
    public boolean isReportDisplayed(){
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(reportTitle));
        return titleElement.isDisplayed();
    }
}
