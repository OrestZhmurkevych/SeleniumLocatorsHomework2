package edu.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static edu.gmail.DriverUtil.getDriver;

public class GmailTest {

    @Test
    public void mailSendingTest() {
        WebDriver driver = getDriver();
        driver.get("http://mail.google.com");
        //TODO try to implement entrance from google main page
//        driver.findElement(By.xpath("//*[text() = 'Gmail']")).click();
//        (new WebDriverWait(driver, 10)).until((dr) -> dr.getTitle().toLowerCase().startsWith("gmail"));
//        driver.findElement(By.cssSelector("li.h-c-header__cta-li g-mail-nav-links--mobile  link--last")).click();
        driver.findElement(By.cssSelector("input[type = 'email']")).sendKeys("orest.zhmurkevych.secondary@gmail.com");
        driver.findElement(By.cssSelector("div[role = 'button']")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type = password]")));
        driver.findElement(By.cssSelector("input[type = password]")).sendKeys("passwordfortest");
        driver.findElement(By.cssSelector("div[id = 'passwordNext']")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 'T-I J-J5-Ji T-I-KE L3']")));
        driver.findElement(By.xpath("//div[@class = 'T-I J-J5-Ji T-I-KE L3']")).click();
        (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("to")));
        driver.findElement(By.name("to")).sendKeys("orestzm@ukr.net");
        driver.findElement(By.className("aoT")).sendKeys("test message from automated program");
        driver.findElement(By.id(":a9")).click();
        driver.findElement(By.id(":a9")).sendKeys("This sentence is written by automated program");
        driver.findElement(By.xpath("//div[@id = ':8u' and @role = 'button']")).click();
    }
}
