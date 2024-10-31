/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SeleniumTests/SeleneseIT.java to edit this template
 */

import mx.itson.orangehrmdemo.Dashboard;
import mx.itson.orangehrmdemo.Employee;
import mx.itson.orangehrmdemo.Login;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author gaspa
 */
public class orangeHRMDemo {
    
    WebDriver driver;
    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    //Testea el login de la pagina
    @Test
    public void successfulLoginTest() {
        Login loginPage = new Login(driver);
        loginPage.startLogin("admin", "admin123");
        Dashboard dashboard = new Dashboard(driver);
        Assert.assertTrue(dashboard.isDashboardDisplayed());
    }
    //Agrega un empleado y se asegura que se muestre la pantalla con el nombre del usuario
    @Test
    public void addNewEmployeeTest() {
        Login loginPage = new Login(driver);
        loginPage.startLogin("admin", "admin123");
        Employee employee = new Employee(driver);
        employee.addEmployee("John", "Milton", "Doe", "100144");
        Assert.assertTrue(employee.getEmployeeName());
    }
    
    @After
    public void tearDown(){
        driver.quit();
    }
    
}
