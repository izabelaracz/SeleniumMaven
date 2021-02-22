package raczynska.java.selenium.tests;

import dataProvider.ConfigFileReader;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FunctionalTest {
    protected static WebDriver browser;
    private static ConfigFileReader configFileReader = new ConfigFileReader();

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        browser = new ChromeDriver();
        browser.manage().window().maximize();
    }

    @After
    public void cleanUp() {
        browser.manage().deleteAllCookies();
    }

    @AfterAll
    public static void tearDown() {
        browser.close();
    }
}
