package edu.gmail;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static edu.gmail.DriverUtil.getDriver;


public class GmailTest {

    private static Logger logger = LogManager.getLogger("GmailTest");

    @Test
    public void mailSendingTest() {
        WebDriver driver = getDriver();
        driver.get("http://mail.google.com");
        driver.findElement(By.cssSelector("input[type = 'email']"))
                .sendKeys("orest.zhmurkevych.secondary@gmail.com");
        driver.findElement(By.cssSelector("div[role = 'button']")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type = password]")));
        driver.findElement(By.cssSelector("input[type = password]")).sendKeys("passwordfortest");
        driver.findElement(By.cssSelector("div[id = 'passwordNext']")).click();
        (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 'T-I J-J5-Ji T-I-KE L3']")));
        driver.findElement(By.xpath("//div[@class = 'T-I J-J5-Ji T-I-KE L3']")).click();
        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("to")));
        driver.findElement(By.name("to")).sendKeys("orestzm@ukr.net");
        driver.findElement(By.className("aoT")).sendKeys("test message from automated program");
        driver.findElement(By.xpath("//div[@class = 'Am Al editable LW-avf' and @role = 'textbox']")).click();
        driver.findElement(By.xpath("//div[@class = 'Am Al editable LW-avf' and @role = 'textbox']"))
                .sendKeys("This sentence is written by automated program");
        driver.findElement(By.xpath("//div[@role = 'button' and @data-tooltip-delay = '800']")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//div[@class = 'qj qr']//parent::div[@class = 'TN bzz aHS-bnu']")));
        driver.findElement(By.xpath("//div[@class = 'qj qr']//parent::div[@class = 'TN bzz aHS-bnu']")).click();
        (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class = 'vh']")));
        logger.info("Email was sent successfully");
        driver.quit();
    }
}
