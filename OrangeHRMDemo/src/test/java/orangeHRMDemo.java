/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SeleniumTests/SeleneseIT.java to edit this template
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author gaspa
 */
public class orangeHRMDemo {
    
    WebDriver driver;
    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    
}
