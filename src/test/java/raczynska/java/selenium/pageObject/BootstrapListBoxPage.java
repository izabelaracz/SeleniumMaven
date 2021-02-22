package raczynska.java.selenium.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BootstrapListBoxPage extends PageObject{

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/button[2]/span")
    private WebElement rightArrow;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/button[1]/span")
    private WebElement leftArrow;

    @FindBy(xpath = "//*[@id=\"listhead\"]/div[2]/div/a")
    private WebElement leftSelector;

    @FindBy(xpath = "//*[@id=\"listhead\"]/div[1]/div/input")
    private WebElement leftSearch;

    public BootstrapListBoxPage(WebDriver browser) {
        super(browser);
    }

    public void throwToOtherList() {
        this.rightArrow.click();
    }

    public void backToOriginalList() {
        this.leftArrow.click();
    }

    public void selectAll() {
        this.leftSelector.click();
    }

    public void enterItemName(String name) {
        this.leftSearch.clear();
        this.leftSearch.sendKeys(name);
    }

}
