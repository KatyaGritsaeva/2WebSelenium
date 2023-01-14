package ru.netology.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DebitCardApplicationTest {

    private WebDriver driver;

    @BeforeAll
    static void setUpAll(){
        System.setProperty("webdriver.crome.driver", "Driver/win/chromedriver.exe");
    }

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
    }

//    @BeforeEach
//    void  tearsDown(){
//        driver.quit();
//        driver=null;
//    }

    @Test
    void test1(){
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("[type=\"text\"]")).sendKeys("Екатерина");
        driver.findElement(By.cssSelector("[type=\"tel\"]")).sendKeys("+79112555555");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button")).click();
        String text = driver.findElement(By.className("paragraph")).getText();
        Assertions.assertEquals("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text);

    }

}
