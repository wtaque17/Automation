import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.IOException;

import java.sql.Driver;
import java.time.Duration;
import java.util.Random;

public class Ejemplo{

    @Test
    public  void prueba() throws InterruptedException {
        double random_1 = (Math.random() * 2);
        Random random = new Random();
        int random_2 = random.nextInt(1,5);
        System.out.println(random_2);
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/Driver/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
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

        WebElement drop_down_data_list = driver.findElement(By.xpath("//input[@name='my-datalist']"));
        drop_down_data_list.sendKeys("San Francisco");
        drop_down_data_list.clear();
        drop_down_data_list.sendKeys("Los Angeles");

        try {
            File file = new File("PruebaDoc.txt");
            if (file.createNewFile()) {//creacion del archivo
                System.out.println("Se creo el archivo");
            } else {
                System.out.println("ya existe un doc con ese nombre");
            }

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error");
            e.printStackTrace();//el error que tre se imprime
        }

        WebElement choose_file = driver.findElement(By.xpath(("//input[@name='my-file']")));
        choose_file.sendKeys("/Users/william/Desktop/Project_001/PruebaDoc.txt");

        WebElement check_box = driver.findElement(By.xpath(("(//input[@name='my-check'])[1]")));
        check_box.click();

        WebElement check_box_2 = driver.findElement(By.xpath(("(//input[@name='my-check'])[2]")));
        check_box_2.click();

        WebElement color_picker = driver.findElement(By.xpath(("//input[@name='my-colors']")));
        color_picker.sendKeys("#58C615");

        WebElement date_picker = driver.findElement(By.xpath(("//input[@name='my-date']")));
        date_picker.click();

        WebElement open_months = driver.findElement(By.xpath("(//TH[not(@style='display: none;') and @class='datepicker-switch' ])[1]"));
        open_months.click();

        WebElement open_days = driver.findElement(By.xpath("(//TH[not(@style='display: none;') and @class='datepicker-switch' ])[2]"));
        open_days.click();

        WebElement year = driver.findElement(By.xpath("//span[contains(text(),'2024')]"));
        year.click();

        WebElement month = driver.findElement(By.xpath("//span[contains(text(),'Mar')]"));
        month.click();

        WebElement day = driver.findElement(By.xpath("//td[contains(text(),'11')]"));
        day.click();

        WebElement default_radio = driver.findElement(By.xpath("//input[@type='radio']"));
        default_radio.click();

        WebElement example_range = driver.findElement(By.xpath("//input[@class='form-range']"));

        if (random_1 <= 1) {
            for (int i = 0; i < random_2; i++) {
                example_range.sendKeys(Keys.ARROW_LEFT);
            }
        }else{
            for (int i = 0; i < random_2; i++) {
                example_range.sendKeys(Keys.ARROW_RIGHT);
        }

    }
        System.out.println(random_1);



























    }
}
