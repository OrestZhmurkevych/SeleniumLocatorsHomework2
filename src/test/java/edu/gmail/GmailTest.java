package edu.gmail;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static edu.gmail.DriverUtil.getDriver;


public class GmailTest {

    private static Logger logger = LogManager.getLogger("GmailTest");

    @Test
    public void mailSendingTest() {
        WebDriver driver = getDriver();
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//        Calendar currentTime;
//        String currentTimeString;
        driver.get("http://mail.google.com");
        //TODO try to implement entrance from google main page and automatic check
//        driver.findElement(By.xpath("//*[text() = 'Gmail']")).click();
//        (new WebDriverWait(driver, 10)).until((dr) -> dr.getTitle().toLowerCase().startsWith("gmail"));
//        driver.findElement(By.cssSelector("li.h-c-header__cta-li g-mail-nav-links--mobile  link--last")).click();
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
//        currentTime = Calendar.getInstance();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//div[@class = 'qj qr']//parent::div[@class = 'TN bzz aHS-bnu']")));
        driver.findElement(By.xpath("//div[@class = 'qj qr']//parent::div[@class = 'TN bzz aHS-bnu']")).click();
//        driver.findElement(By.xpath("//tr[@class = 'zA yO' and @jsaction = 'bjyjJe:NOSeAe;pInidd:NOSeAe;']")).click();
//        currentTimeString = sdf.format(currentTime.getTime());
//        Assert.assertEquals(currentTimeString,
//                driver.findElement(By.xpath("//*[contains(., '" + currentTimeString + "')]")).getText());
//        driver.findElement(By.xpath("//td[@class = 'xW xY ']//following::*[contains(@title, '"
//                + sdf.format(currentTime.getTime()) + "')]"));
//        (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class = 'xY a4W']//following::span")));
//        Assert.assertTrue(driver.findElement(By.xpath("//td[@class = 'xY a4W']//following::span"))
//                        .getText().contains("test message from automated program"));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        logger.info("Email was sent successfully");
        driver.quit();
    }
}
