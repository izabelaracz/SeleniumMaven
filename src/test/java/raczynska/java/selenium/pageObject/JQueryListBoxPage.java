package raczynska.java.selenium.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JQueryListBoxPage extends PageObject{

    @FindBy(xpath = "//*[@id=\"pickList\"]/div/div[2]/button[1]")
    private WebElement btnAdd;

    @FindBy(xpath = "//*[@id=\"pickList\"]/div/div[2]/button[2]")
    private WebElement btnAddAll;

    @FindBy(xpath = "//*[@id=\"pickList\"]/div/div[2]/button[3]")
    private WebElement btnRemove;

    @FindBy(xpath = "//*[@id=\"pickList\"]/div/div[2]/button[4]")
    private WebElement btnRemoveAll;

    @FindBy(xpath = "//*[@id=\"pickList\"]/div/div[1]/select/option[4]")
    private WebElement isabella;

    @FindBy(xpath = "//*[@id=\"pickList\"]/div/div[1]/select/option[2]")
    private WebElement sophia;

    @FindBy(xpath = "//*[@id=\"pickList\"]/div/div[3]/select/option")
    private WebElement sophiaOnOtherList;

    public JQueryListBoxPage(WebDriver browser) {
        super(browser);
    }

    public void addItem() {
        this.btnAdd.click();;
    }

    public void addAll() {
        this.btnAddAll.click();
    }

    public void removeItem() {
        this.btnRemove.click();
    }

    public void removeAll() {
        this.btnRemoveAll.click();
    }

    public void chooseIsabella() {
        this.isabella.click();
    }

    public void chooseSophia() {
        this.sophia.click();
    }

    public void chooseSophiaOnOtherList() {
        this.sophiaOnOtherList.click();
    }
}
