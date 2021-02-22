package Jbehave.steps;

import dataProvider.ConfigFileReader;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import raczynska.java.selenium.pageObject.FormPage;

public class FormSteps extends Steps {
    protected static WebDriver browser;
    private static ConfigFileReader configFileReader = new ConfigFileReader();
    private FormPage formPage;

    @Given("seleniumeasy form page")
    public void openFormPage() {
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        browser = new ChromeDriver();
        formPage = new FormPage(browser);
        formPage.navigateTo("basic-first-form-demo.html");
        browser.manage().window().maximize();
        if (formPage.ifDarkenerIsDisplayed()) {
            formPage.closeDarkener();
        }
    }

    @When("user enter $message and submit")
    public void enterAndSubmitMessage(String message) {
        formPage.enterMessage(message);
        formPage.submitMessage();
    }

    @Then("display user $message")
    public void confirmUserMessage(String message) {
        Assert.assertEquals(message, formPage.confirmationYourMessage());
    }

    @AfterStories
    public void closeBrowser() {
        browser.close();
    }
}
