/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.orangehrmdemo;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author gaspa
 */
public class Configuration {
    private WebDriver driver;
    private WebDriverWait wait;
    private List<WebElement> names;
    List<WebElement> items;
    
    private By terminationReasonsTitle = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/p");
    private WebElement terminationReasonsNameField;
    private By terminationReasons = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/ul/li[5]/a");
    private By configButton = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]");
    private By terminationReasonsDetails = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div/div[1]/div/div/div/div[2]/div/div/button[2]");
    private By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]");
    private By removeTerminationReasonButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div/div[3]/div/div/div/div[2]/div/div/button[1]");
    private By addTerminationReasonButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button");
    private By addReasonField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input");
    private By confirmDeleteButton = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]");
    public Configuration(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    
    public void goToTerminationReasons(){
        
        WebElement configButton = wait.until(ExpectedConditions.elementToBeClickable(this.configButton));
        configButton.click();
        WebElement terminationReasonsTab = wait.until(ExpectedConditions.elementToBeClickable(terminationReasons));
        terminationReasonsTab.click();
    }
    
    public void goToTerminationReasonsDetails(){
        WebElement terminationReasonsTab = wait.until(ExpectedConditions.elementToBeClickable(terminationReasonsDetails));
        terminationReasonsTab.click();
    }
    
    public void editTerminationReason(String reason){
        terminationReasonsNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")));
        terminationReasonsNameField.clear();
        terminationReasonsNameField.sendKeys(reason);
        //wait.until(ExpectedConditions.textToBe(terminationReasonsNameField, ""));
        //driver.findElement(terminationReasonsNameField).sendKeys(reason);
        driver.findElement(saveButton).click();
    }
    
    public boolean checkName(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) driver.findElements(By.className("data"))));
        names = driver.findElements(By.className("data"));
        for(WebElement name: names){
            if(name.getText().equals(text)){
                return true;
            }
            else{
                System.out.println("No se ha encontrado el nombre buscado, se encontro - "+name.getText());
            }
        }
        return false;
        
    }
    
    public boolean clickItem(String text){
        items = driver.findElements(By.className("data"));
        for(WebElement item: items){
            if(item.getText().equals(text)){
                return true;
                
            }
            else{
                System.out.println("No se ha encontrado el elemento - " + item.getText());
            }
        }
        return false;
        
    }
    
    public boolean isTerminationReasonsDisplayed(){
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(terminationReasonsTitle));
        return titleElement.isDisplayed();
    }
    
    public void removeTerminationReason(){
        wait.until(ExpectedConditions.elementToBeClickable(removeTerminationReasonButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton)).click();
    }
    public void addTerminationReason(String reason){
        wait.until(ExpectedConditions.elementToBeClickable(addTerminationReasonButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addReasonField)).sendKeys(reason);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")))).click();
    }    
    
    
}
