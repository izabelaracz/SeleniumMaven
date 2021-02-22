package raczynska.java.selenium.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPage extends PageObject {

    @FindBy(id = "user-message")
    private WebElement userMessage;

    @FindBy(xpath = "//*[@id=\"get-input\"]/button")
    private WebElement btnShowMessage;

    @FindBy(id = "display")
    private WebElement yourMessage;

    @FindBy(xpath = "//*[@id=\"sum1\"]")
    private WebElement valueOne;

    @FindBy(xpath = "//*[@id=\"sum2\"]")
    private WebElement valueTwo;

    @FindBy(xpath = "//*[@id=\"gettotal\"]/button")
    private WebElement btnGetTotal;

    @FindBy(id = "displayvalue")
    private WebElement total;

    @FindBy(id = "image-darkener")
    private WebElement imageDarkener;

    @FindBy(id = "at-cv-lightbox-close")
    private WebElement close;

    public FormPage(WebDriver browser) {
        super(browser);
    }

    public void enterMessage(String msg) {
        this.userMessage.clear();
        this.userMessage.sendKeys(msg);
    }

    public void submitMessage() {
        this.btnShowMessage.click();
    }

    public String confirmationYourMessage() {
        return yourMessage.getText();
    }

    public void enterValueOne(String val) {
        this.valueOne.clear();
        this.valueOne.sendKeys(val);
    }

    public void enterValueTwo(String val) {
        this.valueTwo.clear();
        this.valueTwo.sendKeys(val);
    }

    public void submitValues() {
        this.btnGetTotal.click();
    }

    public String confirmationTotal() {
        return total.getText();
    }

    public boolean ifDarkenerIsDisplayed() {
        if (imageDarkener.isEnabled())
            return imageDarkener.isDisplayed();
        else return false;
    }

    public void closeDarkener() {
        this.close.click();
    }

}
