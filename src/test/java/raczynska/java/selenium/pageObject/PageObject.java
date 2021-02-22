package raczynska.java.selenium.pageObject;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    protected WebDriver browser;
    ConfigFileReader configFileReader;

    public PageObject(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        configFileReader = new ConfigFileReader();
    }

    public void navigateTo(String search) {
        browser.get(configFileReader.getApplicationUrl() + search);
    }
}
