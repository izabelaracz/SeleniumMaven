package Jbehave.steps;

import dataProvider.ConfigFileReader;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import raczynska.java.selenium.pageObject.CheckboxPage;

import java.util.concurrent.TimeUnit;

public class CheckboxSteps extends Steps {
    protected static WebDriver browser;
    private static ConfigFileReader configFileReader = new ConfigFileReader();
    private CheckboxPage checkboxPage;

    public CheckboxSteps() {
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        browser = new ChromeDriver();
        checkboxPage = new CheckboxPage(browser);
        checkboxPage.navigateTo("basic-checkbox-demo.html");
        browser.manage().window().maximize();
    }

    @When("user check all option as $options")
    public void checkAllOption(String options) {
        switch (options) {
            case "all_options":
                checkboxPage.checkOption1();
                checkboxPage.checkOption2();
                checkboxPage.checkOption3();
                checkboxPage.checkOption4();
                browser.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                break;
            case "Check_all":
                checkboxPage.chooseAll();
                break;
        }
    }

    @Then("text on button is $text")
    public void confirmTextOnButton(String text) {
        Assertions.assertEquals(text, checkboxPage.textOnBtnCheck());
    }

    @AfterStories
    public void closeBrowser() {
        browser.close();
    }

}
