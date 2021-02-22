package Jbehave.steps;

import dataProvider.ConfigFileReader;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import raczynska.java.selenium.pageObject.AlertMsgPage;

public class AlertMsgSteps extends Steps {
    protected static WebDriver browser;
    private static ConfigFileReader configFileReader = new ConfigFileReader();
    private AlertMsgPage alertMsgPage;

    public AlertMsgSteps() {
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        browser = new ChromeDriver();
        alertMsgPage = new AlertMsgPage(browser);
        alertMsgPage.navigateTo("bootstrap-alert-messages-demo.html");
        browser.manage().window().maximize();
    }

    @When("user click on autocloseable $title message")
    public void selectAutocloseMsg(String title) {
        switch (title) {
            case "success":
                alertMsgPage.selectAutocloseSuccessMsg();
                break;
            case "warning":
                alertMsgPage.selectAutocloseWarnMsg();
                break;
            case "danger":
                alertMsgPage.selectAutocloseDangerMsg();
                break;
            case "info":
                alertMsgPage.selectAutocloseInfoMsg();
                break;
        }
    }

    @Then("check if button $name is clickable")
    public void checkIfBtnClickable(String name) {
        switch (name) {
            case "success":
                Assertions.assertFalse(alertMsgPage.ifAutocloseSuccessMsgEnable());
                break;
            case "warning":
                Assertions.assertFalse(alertMsgPage.ifAutocloseWarnMsgEnable());
                break;
            case "danger":
                Assertions.assertFalse(alertMsgPage.ifAutocloseDangerMsgEnable());
                break;
            case "info":
                Assertions.assertFalse(alertMsgPage.ifAutocloseInfoMsgEnable());
                break;
        }
    }

    @AfterStories
    public void closeBrowser() {
        browser.close();
    }
}
