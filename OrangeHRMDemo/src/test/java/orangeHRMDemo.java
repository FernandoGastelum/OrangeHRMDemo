/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SeleniumTests/SeleneseIT.java to edit this template
 */

import mx.itson.orangehrmdemo.Admin;
import mx.itson.orangehrmdemo.Configuration;
import mx.itson.orangehrmdemo.Dashboard;
import mx.itson.orangehrmdemo.Employee;
import mx.itson.orangehrmdemo.Login;
import mx.itson.orangehrmdemo.MyInfo;
import mx.itson.orangehrmdemo.Reports;
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
    Login loginPage;
    Employee employee;
    Dashboard dashboard;
    MyInfo myInfoPage;
    Admin admin;
    Reports reports;
    Configuration config;
    WebDriver driver;
    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        employee = new Employee(driver);
        loginPage = new Login(driver);
        dashboard = new Dashboard(driver);
        myInfoPage = new MyInfo(driver);
        reports = new Reports(driver);
        admin = new Admin(driver);
        config = new Configuration(driver);
        
    }
    //Testea el login de la pagina
    @Test
    public void successfulLoginTest() {
        
        loginPage.startLogin("admin", "admin123");
        
        Assert.assertTrue(dashboard.isDashboardDisplayed());
    }
    //Agrega un empleado y se asegura que se muestre la pantalla con el nombre del usuario
    @Test
    public void addNewEmployeeTest() {
        
        loginPage.startLogin("admin", "admin123");
        
        employee.addEmployee("John", "Milton", "Doe", "100144");
        Assert.assertTrue(employee.getEmployeeName());
    }
    //Comprueba que sucede cuando insertamos una contrasena erronea
    @Test
    public void wrongCredentials(){
        
        loginPage.startLogin("admin", "badPassword");
        Assert.assertTrue("El mensaje de error no es correcto",loginPage.validateWrongPasswordMessage());
    }
    //Navegación a la sección “My Info” para verificar y actualizar información personal.
    @Test
    public void verifyMyInfo(){
       
        loginPage.startLogin("admin", "admin123");
       
        dashboard.goToMyInfo();
        
        Assert.assertTrue(myInfoPage.isMyInfoDisplayed());
    }
    //Editar la información de un empleado existente.
    @Test
    public void editExistentEmployeeData(){
        loginPage.startLogin("admin", "admin123");
        dashboard.goToAdmin();
        admin.editEmployeeUsername("Marlong");
        Assert.assertTrue("Error", admin.isAdminDisplayed());
    }
    //Comprueba que no se pueden consultar reportes con el boton de busqueda
    @Test
    public void searchReportError(){
        loginPage.startLogin("admin", "admin123");
        dashboard.goToPIM();
        reports.goToReportsSection();
        reports.searchReportByName("Prueba reporte");
        Assert.assertTrue("Error", reports.getErrorMessage().equals("Invalid"));
    }
    @Test
    //Comprueba si se puede consultar un reporte de la lista general de reportes
    public void consultGeneralReport(){
        loginPage.startLogin("admin", "admin123");
        dashboard.goToPIM();
        reports.goToReportsSection();
        reports.goToDetailsReport();
        Assert.assertTrue(reports.isReportDisplayed());
    }
    @Test
    public void editTerminationReason(){
        loginPage.startLogin("admin", "admin123");
        dashboard.goToPIM();
        config.goToTerminationReasons();
        config.goToTerminationReasonsDetails();
        config.editTerminationReason("Prueba1234");
        Assert.assertTrue(config.isTerminationReasonsDisplayed());
    }
    @Test
    public void addTerminationReason(){
        loginPage.startLogin("admin", "admin123");
        dashboard.goToPIM();
        config.goToTerminationReasons();
        config.addTerminationReason("Ejemplo12");
        Assert.assertTrue("Error", config.isTerminationReasonsDisplayed());
    }
    @Test
    public void removeTerminationReason(){
        loginPage.startLogin("admin", "admin123");
        dashboard.goToPIM();
        config.goToTerminationReasons();
        config.removeTerminationReason();
        Assert.assertTrue("Error", config.isTerminationReasonsDisplayed());
    }
    
    @After
    public void tearDown(){
        driver.quit();
    }
    
}
