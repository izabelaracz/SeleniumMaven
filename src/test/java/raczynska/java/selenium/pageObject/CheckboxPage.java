package raczynska.java.selenium.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxPage extends PageObject {

    @FindBy(id = "isAgeSelected")
    private WebElement ageSelector;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label/input")
    private WebElement option1;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label/input")
    private WebElement option2;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[3]/label/input")
    private WebElement option3;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[4]/label/input")
    private WebElement option4;

    @FindBy(id = "check1")
    private WebElement btnCheck;

    public CheckboxPage(WebDriver browser) {
        super(browser);
    }

    public void checkAgeSelector() {
        this.ageSelector.click();
    }

    public boolean ifAgeSelected() {
        return ageSelector.isSelected();
    }

    public void chooseAll() {
        this.btnCheck.click();
    }

    public String textOnBtnCheck() {
        return btnCheck.getAttribute("value");
    }

    public boolean ifAllCheck() {
        if (option1.isSelected() &&
                option2.isSelected() &&
                option3.isSelected() &&
                option4.isSelected()) return true;
        else return false;
    }

    public void checkOption1() {
        if (!option1.isSelected())
            this.option1.click();
    }

    public void checkOption2() {
        if (!option2.isSelected())
            this.option2.click();
    }

    public void checkOption3() {
        if (!option3.isSelected())
            this.option3.click();
    }

    public void checkOption4() {
        if (!option4.isSelected())
            this.option4.click();
    }
}
