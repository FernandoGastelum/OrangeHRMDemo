/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.orangehrmdemo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author gaspa
 */
public class Dashboard {
    private WebDriver driver;
    private WebDriverWait wait;

    private By dashboardTitle = By.xpath("//h6[text()='Dashboard']");
    private By profileDropdown = By.xpath("//p[@class='oxd-userdropdown-name']");
    private By logoutButton = By.xpath("//a[text()='Logout']");
    private By changePasswordButton = By.xpath("//a[text()='Change Password']");
    private By supportButton = By.xpath("//a[text()='Support']");

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isDashboardDisplayed() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardTitle));
        return titleElement.isDisplayed();
    }

    public void goToMyInfo() {
        WebElement myInfoTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a")));
        myInfoTab.click();
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(profileDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }



    // Método para navegar a la sección de "Leave"
    public void goToLeave() {
        WebElement leaveTab = wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_leave_viewLeaveModule")));
        leaveTab.click();
    }

    // Método para navegar a la sección de "Admin"
    public void goToAdmin() {
        WebElement adminTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")));
        adminTab.click();
    }
    
    // Método para abrir el apartado de "Change My Password"
    public void goToChangePassword() {
        wait.until(ExpectedConditions.elementToBeClickable(profileDropdown)).click();
        WebElement changePasswordElement = wait.until(ExpectedConditions.elementToBeClickable(changePasswordButton));
        changePasswordElement.click();

    }
    public void goToPIM(){
            WebElement adminTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")));
            adminTab.click();
        }
    public void goToSupport() {

        wait.until(ExpectedConditions.elementToBeClickable(profileDropdown)).click();
        WebElement changePasswordElement = wait.until(ExpectedConditions.elementToBeClickable(supportButton));
        changePasswordElement.click();
    }

    public void goToWorkShifts() {


    }


}

