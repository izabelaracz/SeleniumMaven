package raczynska.java.selenium.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjaxFromSubmitPage extends PageObject {

    @FindBy(id = "title")
    private WebElement usernameLabel;

    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/span")
    private WebElement userNameLabelStar;

    @FindBy(id = "btn-submit")
    private WebElement btnSubmit;

    @FindBy(id = "submit-control")
    private WebElement submitControl;

    @FindBy(xpath = "//*[@id=\"submit-control\"]/img")
    private WebElement waitingGif;

    public AjaxFromSubmitPage(WebDriver browser) {
        super(browser);
    }

    public void enterUsername(String name) {
        this.usernameLabel.clear();
        this.usernameLabel.sendKeys(name);
    }

    public void submit() {
        this.btnSubmit.click();
    }

    public String confirmLabelStar() {
        return userNameLabelStar.getText();
    }

    public String confirmChangeBorder() {
        return usernameLabel.getAttribute("style");
    }

    public void waitUntilGifAppears() {
        WebDriverWait wait = new WebDriverWait(browser, 5);
        wait.until(ExpectedConditions.visibilityOf(waitingGif));
    }

    public void waitUntilTextChange() {
        WebDriverWait wait = new WebDriverWait(browser, 5);
        wait.until(ExpectedConditions.textToBePresentInElement(submitControl, "Form submited Successfully!"));
    }

    public String confirmSubmitControl() {
        return submitControl.getText();
    }
}
