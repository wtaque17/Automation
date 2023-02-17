import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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


        WebElement text_input = driver.findElement(By.id("my-text-id"));
        text_input.sendKeys("Esta es una prueba");

        WebElement password_input = driver.findElement(By.xpath("//input[@name='my-password']"));
        password_input.sendKeys("1234567890");

        WebElement text_area_input = driver.findElement(By.cssSelector("body > main > div > form > div > div:nth-child(1) > label:nth-child(3) > textarea"));
        text_area_input.sendKeys("Segunda clase de automatizacion");

        WebElement disabled_input = driver.findElement(By.xpath("//input[@name='my-disabled']"));
        Assert.assertFalse(disabled_input.isEnabled());

        WebElement read_only_input = driver.findElement(By.xpath("//label[@class='form-label w-100'][5]"));
        Assert.assertEquals("Readonly input", read_only_input.getText());

        WebElement drop_down_select = driver.findElement(By.xpath("//select[@class='form-select']"));
        Select option = new Select(drop_down_select);
        option.selectByValue("3");






        //WebElement return_index = driver.findElement(By.xpath("/html/body/main/div/form/div/div[1]/div/a"));
        //return_index.click();





    }
}
