package Jbehave.steps;

import dataProvider.ConfigFileReader;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import raczynska.java.selenium.pageObject.AjaxFromSubmitPage;

public class AjaxFromSubmitSteps extends Steps {
    protected static WebDriver browser;
    private static ConfigFileReader configFileReader = new ConfigFileReader();
    private AjaxFromSubmitPage ajaxFromSubmitPage;

    public AjaxFromSubmitSteps() {
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        browser = new ChromeDriver();
        ajaxFromSubmitPage = new AjaxFromSubmitPage(browser);
        ajaxFromSubmitPage.navigateTo("ajax-form-submit-demo.html");
        browser.manage().window().maximize();
    }

    @When("user submit")
    public void userEnterUsername() {
        ajaxFromSubmitPage.submit();
    }

    @Then("user see result")
    public void confirm() {
        Assertions.assertEquals("*", ajaxFromSubmitPage.confirmLabelStar());
        Assertions.assertEquals("border: 1px solid rgb(255, 0, 0);", ajaxFromSubmitPage.confirmChangeBorder());
    }

    @AfterStories
    public void closeBrowser() {
        browser.close();
    }
}
