package Jbehave.steps;

import dataProvider.ConfigFileReader;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import raczynska.java.selenium.pageObject.SelectDropdownListPage;

public class SelectDropdownDaySteps extends Steps {
    protected static WebDriver browser;
    private static ConfigFileReader configFileReader = new ConfigFileReader();
    private SelectDropdownListPage selectDropdownListPage;

    public SelectDropdownDaySteps() {
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        browser = new ChromeDriver();
        selectDropdownListPage = new SelectDropdownListPage(browser);
        selectDropdownListPage.navigateTo("basic-select-dropdown-demo.html");
        browser.manage().window().maximize();
    }

    @When("user choose $day")
    public void selectDay(String day) {
        switch (day) {
            case "Monday":
                selectDropdownListPage.selectMonday();
                break;
            case "Tuesday":
                selectDropdownListPage.selectTuesday();
                break;
            case "Wednesday":
                selectDropdownListPage.selectWednesday();
                break;
            case "Thursday":
                selectDropdownListPage.selectThursday();
                break;
            case "Friday":
                selectDropdownListPage.selectFriday();
                break;
            case "Saturday":
                selectDropdownListPage.selectSaturday();
                break;
            case "Sunday":
                selectDropdownListPage.selectSunday();
                break;
        }
    }

    @Then("display $message")
    public void confirmSelectedDay(String message) {
        Assertions.assertEquals(message, selectDropdownListPage.confirmSelectedDay());
    }

    @AfterStories
    public void closeBrowser() {
        browser.close();
    }
}
