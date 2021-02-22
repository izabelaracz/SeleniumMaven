package raczynska.java.selenium.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertMsgPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"autoclosable-btn-success\"]")
    private WebElement autocloseSuccessMsg;

    @FindBy(xpath = "//*[@id=\"normal-btn-success\"]")
    private WebElement normalSuccessMsg;

    @FindBy(xpath = "//*[@id=\"autoclosable-btn-warning\"]")
    private WebElement autocloseWarnMsg;

    @FindBy(xpath = "//*[@id=\"normal-btn-warning\"]")
    private WebElement normalWarnMsg;

    @FindBy(xpath = "//*[@id=\"autoclosable-btn-danger\"]")
    private WebElement autocloseDangerMsg;

    @FindBy(xpath = "//*[@id=\"normal-btn-danger\"]")
    private WebElement normalDangerMsg;

    @FindBy(xpath = "//*[@id=\"autoclosable-btn-info\"]")
    private WebElement autocloseInfoMsg;

    @FindBy(xpath = "//*[@id=\"normal-btn-info\"]")
    private WebElement normalInfoMsg;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[1]")
    private WebElement acSucWindow;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[2]/button")
    private WebElement nsmInfoX;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[3]")
    private WebElement acWarnWindow;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[4]/button")
    private WebElement nwmInfoX;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[5]")
    private WebElement acDangerWindow;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[6]/button")
    private WebElement ndmInfoX;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[7]")
    private WebElement acInfoWindow;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[8]/button")
    private WebElement nimInfoX;

    public AlertMsgPage(WebDriver browser) {
        super(browser);
    }

    public void selectAutocloseSuccessMsg() {
        this.autocloseSuccessMsg.click();
    }

    public void selectNormalSuccessMsg() {
        this.normalSuccessMsg.click();
    }

    public void selectAutocloseWarnMsg() {
        this.autocloseWarnMsg.click();
    }

    public void selectNormalWarnMsg() {
        this.normalWarnMsg.click();
    }

    public void selectAutocloseDangerMsg() {
        this.autocloseDangerMsg.click();
    }

    public void selectNormalDangerMsg() {
        this.normalDangerMsg.click();
    }

    public void selectAutocloseInfoMsg() {
        this.autocloseInfoMsg.click();
    }

    public void selectNormalInfoMsg() {
        this.normalInfoMsg.click();
    }

    public boolean ifAutocloseSuccessMsgEnable() {
        return autocloseSuccessMsg.isEnabled();
    }

    public boolean ifNormalSuccessMsgEnable() {
        return normalSuccessMsg.isEnabled();
    }

    public boolean ifAutocloseWarnMsgEnable() {
        return autocloseWarnMsg.isEnabled();
    }

    public boolean ifNormalWarnMsgEnable() {
        return normalWarnMsg.isEnabled();
    }

    public boolean ifAutocloseDangerMsgEnable() {
        return autocloseDangerMsg.isEnabled();
    }

    public boolean ifNormalDangerMsgEnable() {
        return normalDangerMsg.isEnabled();
    }

    public boolean ifAutocloseInfoMsgEnable() {
        return autocloseInfoMsg.isEnabled();
    }

    public boolean ifNormalInfoMsgEnable() {
        return normalInfoMsg.isEnabled();
    }

    public void waitUntilSuccessMsgDisappear() {
        WebDriverWait wait = new WebDriverWait(browser, 15);
        wait.until(ExpectedConditions.invisibilityOf(acSucWindow));
    }

    public void waitUntilWarnMsgDisappear() {
        WebDriverWait wait = new WebDriverWait(browser, 5);
        wait.until(ExpectedConditions.invisibilityOf(acWarnWindow));
    }

    public void waitUntilDangerMsgDisappear() {
        WebDriverWait wait = new WebDriverWait(browser, 15);
        wait.until(ExpectedConditions.invisibilityOf(acDangerWindow));
    }

    public void waitUntilInfoMsgDisappear() {
        WebDriverWait wait = new WebDriverWait(browser, 15);
        wait.until(ExpectedConditions.invisibilityOf(acInfoWindow));
    }

    public boolean ifNormalSuccessInfoXEnable() {
        return nsmInfoX.isEnabled();
    }

    public void closeNormalSuccessInfo() {
        this.nsmInfoX.click();
    }

    public boolean ifNormalSuccessInfoDisplayed() {
        return nsmInfoX.isDisplayed();
    }

    public boolean ifNormalWarnInfoXEnable() {
        return nwmInfoX.isEnabled();
    }

    public void closeNormalWarnInfo() {
        this.nwmInfoX.click();
    }

    public boolean ifNormalWarnInfoDisplayed() {
        return nwmInfoX.isDisplayed();
    }

    public boolean ifNormalDangerInfoXEnable() {
        return ndmInfoX.isEnabled();
    }

    public void closeNormalDangerInfo() {
        this.ndmInfoX.click();
    }

    public boolean ifNormalDangerInfoDisplayed() {
        return ndmInfoX.isDisplayed();
    }

    public boolean ifNormalInfoInfoXEnable() {
        return nimInfoX.isEnabled();
    }

    public void closeNormalInfoInfo() {
        this.nimInfoX.click();
    }

    public boolean ifNormalInfoInfoDisplayed() {
        return nimInfoX.isDisplayed();
    }
}
