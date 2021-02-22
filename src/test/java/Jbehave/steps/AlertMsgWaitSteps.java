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

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlertMsgWaitSteps extends Steps {

    protected static WebDriver browser;
    private static ConfigFileReader configFileReader = new ConfigFileReader();
    private AlertMsgPage alertMsgPage;

    public AlertMsgWaitSteps() {
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

    @When("user waits until $alert alert disappears")
    public void waitUntilAlertDisappears(String alert) {
        switch (alert) {
            case "success":
                alertMsgPage.waitUntilSuccessMsgDisappear();
                break;
            case "warning":
                alertMsgPage.waitUntilWarnMsgDisappear();
                break;
            case "danger":
                alertMsgPage.waitUntilDangerMsgDisappear();
                break;
            case "info":
                alertMsgPage.waitUntilInfoMsgDisappear();
                break;
        }
    }

    @Then("autocloseable $name message is clickable again")
    public void checkIfBtnClickable(String name) {
        switch (name) {
            case "success":
                assertTrue(alertMsgPage.ifAutocloseSuccessMsgEnable());
                break;
            case "warning":
                assertTrue(alertMsgPage.ifAutocloseWarnMsgEnable());
                break;
            case "danger":
                Assertions.assertTrue(alertMsgPage.ifAutocloseDangerMsgEnable());
                break;
            case "info":
                Assertions.assertTrue(alertMsgPage.ifAutocloseInfoMsgEnable());
                break;
        }
    }

    @AfterStories
    public void closeBrowser() {
        browser.close();
    }
}
