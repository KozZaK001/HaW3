package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ExampleMain
{
    public static void main( String[] args ) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://pikabu.ru/");
        WebElement webElement1 = driver.findElement(By.name("username"));
        webElement1.click();
        webElement1.sendKeys("Perkintver");

        WebElement element = driver.findElement(By.name("password"));
        Actions builder = new Actions(driver);
        builder.doubleClick(element).perform();
        element.sendKeys("Maksim123");
        WebElement button = driver.findElement(By.cssSelector("button__title"));
        button.click();
    }

}
