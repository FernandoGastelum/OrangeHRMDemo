/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import mx.itson.orangehrmdemo.Admin;
import mx.itson.orangehrmdemo.Dashboard;
import mx.itson.orangehrmdemo.Employee;
import mx.itson.orangehrmdemo.Login;
import mx.itson.orangehrmdemo.MyInfo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 *
 * @author caarl
 */
public class CarlosTest {
    
     Login loginPage;
    Employee employee;
    Dashboard dashboard;
    MyInfo myInfoPage;
    Admin admin;
    WebDriver driver;
    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        employee = new Employee(driver);
        loginPage = new Login(driver);
        dashboard = new Dashboard(driver);
        myInfoPage = new MyInfo(driver);
        admin = new Admin(driver);
    
    
    
}
    
    //1.- ya funciona
//    @Test
//public void logoutTest() {
//    loginPage.startLogin("admin", "admin123");
//    Assert.assertTrue("Dashboard no está visible después del login", dashboard.isDashboardDisplayed());
//    
//    dashboard.logout();
//    
//    // Validar que estamos de vuelta en la pantalla de login
//    Assert.assertTrue("No se redirigió a la página de login", loginPage.isLoginDisplayed());
//}
//2.- ya funciona
//     @Test
//public void searchExistingEmployeeTest() {
//    loginPage.startLogin("admin", "admin123");
//    dashboard.goToAdmin();
//    
//    admin.searchEmployee("FMLName");  
//    
//    Assert.assertTrue("El empleado no se encontró en los resultados", admin.isEmployeeFound());
//}

//3.- ya ffunciona
//@Test
//public void deleteEmployeeTest() {
//    loginPage.startLogin("admin", "admin123");
//    dashboard.goToAdmin();
//    
//    // Buscar al empleado
//    admin.searchEmployee("FMLName");  // Cambia "JohnDoe" por un nombre existente en el sistema
//    Assert.assertTrue("El empleado no se encontró en los resultados", admin.isEmployeeFound());
//    
//    // Eliminar al empleado
//    admin.deleteEmployee();
//    
//    // Verificar que ya no se encuentre el empleado (puedes implementar un método adicional si es necesario)
//    admin.searchEmployee("FMLName");
//    Assert.assertFalse("El empleado todavía aparece en los resultados", admin.isEmployeeFound());
//}
//4.-Ya funciona
//@Test
//public void changePasswordTest() {
//    // Iniciar sesión con las credenciales actuales
//    loginPage.startLogin("admin", "admin123");
//
//    // Navegar a la sección "Change My Password" usando el nuevo método de Dashboard
//    dashboard.goToChangePassword();
//
//    // Cambiar la contraseña a "Admin1234" (usando el método en Admin)
//    admin.changePassword("admin123");
//
//}
// 5.- ya funciona
//@Test
//public void suPPortArea() {
//    // Iniciar sesión con las credenciales actuales
//    loginPage.startLogin("admin", "admin123");
//
//   
//    dashboard.goToSupport();
//
//}
// 6.- ya funciona
//    @Test
//public void deleteLanguageTest() {
//    // Iniciar sesión en la aplicación
//    loginPage.startLogin("admin", "admin123");
//
//    // Navegar a la sección de Administración
//    dashboard.goToAdmin();
//
//    // Ejecutar el método para eliminar un idioma
//    admin.deleteLanguage();
//
//    // Opcional: Verificar que el idioma fue eliminado con éxito, si existe un indicador de éxito
//}
    //7.- ya funciona
//    @Test
//public void editSkillTest() throws InterruptedException {
//    // Iniciar sesión en la aplicación
//    loginPage.startLogin("admin", "admin123");
//
//    // Navegar a la sección de Administración
//    dashboard.goToAdmin();
//
//    // Ejecutar el método para editar una habilidad
//    admin.editSkill();
//
//    // Opcional: Verificar que los cambios en la habilidad se han guardado con éxito
//}
/**
 * 8.- ya funciona
 */
//@Test
//public void testEditWorkShift() throws InterruptedException {
//    // Iniciar sesión y realizar otras configuraciones necesarias
//    loginPage.startLogin("admin", "admin123");
//
//    
//    // Navegar a la sección de Administración
//    dashboard.goToAdmin();
//
//    // Ir al dashboard y editar el horario laboral
//    admin.editWorkShift();
//}

/**
 * 9.- ya funciona 
 */
    
//    @Test
//public void testAssignEmployee() throws InterruptedException {
//    // Iniciar sesión y realizar otras configuraciones necesarias
//    loginPage.startLogin("admin", "admin123");
//    
//     // Navegar a la sección de Administración
//    dashboard.goToAdmin();
//
//    // Ir al dashboard y asignar el empleado
//    admin.assignEmployee();
//}

    /**
     * 10.- 
     */
@Test
public void testDeleteWorkShift() throws InterruptedException {
    // Iniciar sesión y realizar otras configuraciones necesarias
    loginPage.startLogin("admin", "admin123");
    
    // Navegar a la sección de Administración
    dashboard.goToAdmin();

    // Ir al dashboard y eliminar el horario laboral
    admin.deleteWorkShift();
}


    @After
    public void tearDown(){
        driver.quit();
    }
   


    
    
    
}