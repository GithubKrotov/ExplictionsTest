package org.example.explictionstest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/dynamic-properties");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void visibleButton () {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement visibleButton = driver.findElement(By.cssSelector("#visibleAfter"));
        wait.until(d -> visibleButton.isDisplayed());
        assertTrue(visibleButton.isDisplayed(), "Кнопка стала видимой");
    }
}
