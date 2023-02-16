import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.time.Duration;

public class Ejemplo{
    
    @Test
    public  void prueba(){
        System.setProperty("webdriver.chrome.driver","./src/test/resources/Driver/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        driver.manage().window().maximize();

        String title = driver.getTitle();
        Assert.assertEquals("Web form", title);
        System.out.println("Exitoso");

        WebElement text_input = driver.findElement(By.id("my-text-id"));

        text_input.sendKeys("Esta es una prueba");


    }
}
