package Jbehave.steps;

import dataProvider.ConfigFileReader;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import raczynska.java.selenium.pageObject.FormPage;

public class FormAddSteps extends Steps {
    protected static WebDriver browser;
    private static ConfigFileReader configFileReader = new ConfigFileReader();
    private FormPage formPage;

    public FormAddSteps() {
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        browser = new ChromeDriver();
        formPage = new FormPage(browser);
        formPage.navigateTo("basic-first-form-demo.html");
        browser.manage().window().maximize();
        if (formPage.ifDarkenerIsDisplayed()) {
            formPage.closeDarkener();
        }
    }

    @When("user enter first value as $value1")
    public void enterFirstValue(String value1) {
        formPage.enterValueOne(value1);
    }

    @When("user enter second value as $value2")
    public void enterSecondValue(String value2) {
        formPage.enterValueTwo(value2);
    }

    @Then("user submit to get total")
    public void SubmitGetTotal() {
        formPage.submitValues();
    }

    @Then("get total result as $result")
    public void confirmTotalResult(String result) {
        Assertions.assertEquals(result, formPage.confirmationTotal());
    }

    @AfterStories
    public void closeBrowser() {
        browser.close();
    }

}
