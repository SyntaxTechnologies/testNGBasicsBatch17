package class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class softAssertion {
/*
verify that the login button is enabled
verify that you are able to login into HRMS website
*/
  public  static WebDriver driver;
@BeforeMethod
public void SetupBrowser(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}

    @Test
    public void login(){
        WebElement username = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        username.sendKeys("Admin");
        WebElement pasword = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        pasword.sendKeys("Hum@nhrm123");
//        verify that the login button is enabled
        WebElement loginBtn = driver.findElement(By.xpath("//input[@name='Submit']"));
        boolean status = loginBtn.isEnabled();
        SoftAssert soft=new SoftAssert();
        status=false;
        soft.assertTrue(status);
        System.out.println("heloooooooooooo");
        loginBtn.click();

        WebElement actualMsg = driver.findElement(By.xpath("//a[@id='welcome']"));
        String actualMessage = actualMsg.getText();

        soft.assertEquals(actualMessage,"Welcome Admins");

         soft.assertAll();

//         for testing the concept of soft assertion i am on purpose failing both the assertion

    }

}
