package raczynska.java.selenium.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JQueryDropdownPage extends PageObject{

    @FindBy(id = "select2-country-container")
    private WebElement countryContainer;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[1]/div/div[2]/span/span[1]/span/span[2]/b")
    private WebElement countrySelect;

    @FindBy(xpath = "/html/body/span/span/span[1]/input")
    private WebElement countrySearch;

    @FindBy(xpath = "//*[@id=\"select2-country-results\"]/li")
    private WebElement searchResult;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[2]/div/div[2]/span/span[1]/span/ul/li/input")
    private WebElement stateSelector;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[2]/div/div[2]/span/span[1]/span/ul/li[2]/span")
    private WebElement californiaX;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[3]/div/div[2]/span/span[1]/span/span[2]")
    private WebElement usTeritoriesArrow;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[3]/div/div[2]/span/span[1]/span/span[1]")
    private WebElement usTeritoriesContainer;

    @FindBy(xpath = "/html/body/span/span/span[1]/input")
    private WebElement usSearch;

    @FindBy(id = "files")
    private WebElement files;

    @FindBy(xpath = "//*[@id=\"files\"]/optgroup[1]")
    private WebElement scriptLanguages;

    public JQueryDropdownPage(WebDriver browser) {
        super(browser);
    }

    public void dropdownCountrySelect() {
        this.countrySelect.click();
    }

    public void enterCountry(String country) {
        this.countrySearch.clear();
        this.countrySearch.sendKeys(country);
    }

    public void enterAndSubmitCountry(String country) {
        this.countrySearch.clear();
        this.countrySearch.sendKeys(country, Keys.ENTER);
    }

    public String confirmResultSearchMessage() {
        return searchResult.getText();
    }

    public String confirmCountry() {
        return countryContainer.getText();
    }

    public void dropdownStates() {
        this.stateSelector.click();
    }

    public void searchState(String state) {
        this.stateSelector.clear();
        this.stateSelector.sendKeys(state);
    }

    public void closeCalifornia() {
        this.californiaX.click();
    }

    public void dropdownUSTeritories() {
        this.usTeritoriesArrow.click();
    }

    public void enterUSTeritory(String us) {
        this.usSearch.clear();
        this.usSearch.sendKeys(us);
    }

    public String confirmUSContainer() {
        return usTeritoriesContainer.getText();
    }

    public void dropdownFiles() {
        this.files.click();
    }

    public void selectScriptLanguages() {
        this.scriptLanguages.click();
    }
}
