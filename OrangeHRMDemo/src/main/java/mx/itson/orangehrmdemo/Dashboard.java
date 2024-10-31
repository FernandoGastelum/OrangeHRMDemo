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

    // Localizador para el título de Dashboard
    private By dashboardTitle = By.xpath("//h6[text()='Dashboard']");

    // Constructor
    public Dashboard(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Método para verificar que el Dashboard esté visible
    public boolean isDashboardDisplayed() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardTitle));
        return titleElement.isDisplayed();
    }

    // Método para navegar a la sección de "My Info"
    public void goToMyInfo() {
        WebElement myInfoTab = wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewMyDetails")));
        myInfoTab.click();
    }

    // Método para navegar a la sección de "Leave"
    public void goToLeave() {
        WebElement leaveTab = wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_leave_viewLeaveModule")));
        leaveTab.click();
    }

    // Método para navegar a la sección de "Admin"
    public void goToAdmin() {
        WebElement adminTab = wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_admin_viewAdminModule")));
        adminTab.click();
    }
}
