package day04;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static java.lang.Thread.sleep;

public class StreamsWithSelenium {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://practice.cydeo.com/");
    }

    @Test
    public void getNameFields() throws InterruptedException{
        driver.findElement(By.linkText("Registration Form")).click();

        //Get all input elements that contains "name" in name attribute then type test
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        inputs.stream().filter(input -> input.getAttribute("name").contains("name"))
                .forEach(input -> input.sendKeys("Test"));

        //get all options from departments dropdown
        Select select = new Select(driver.findElement(By.name("department")));
        select.getOptions().stream()
                .filter(option -> option.getText().contains("Office"))
                .forEach(option -> {
                    select.selectByVisibleText(option.getText());
                    try {
                        sleep(1234);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
        });
    }



    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
