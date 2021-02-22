package raczynska.java.selenium.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RadioButtonPage extends PageObject{

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[1]/input")
    private WebElement maleBtn;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[2]/input")
    private WebElement femaleBtn;

    @FindBy(id = "buttoncheck")
    private WebElement btnCheckValue;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/p[3]")
    private WebElement yourchoice;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label[1]/input")
    private WebElement maleBtnGroup;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label[2]/input")
    private WebElement femaleBtnGroup;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label[1]/input")
    private WebElement ageGroup0to5;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label[2]/input")
    private WebElement ageGroup5to15;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label[3]/input")
    private WebElement ageGroup15to50;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button")
    private WebElement btnGetValues;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]")
    private WebElement yourGroupChoice;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]")
    private WebElement yourGroupSexChoice;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]/br")
    private WebElement yourGroupAgeChoice;

    public RadioButtonPage(WebDriver browser) {
        super(browser);
    }

    public void maleCheck() {
        this.maleBtn.click();
    }

    public void femaleCheck() {
        this.femaleBtn.click();
    }

    public void buttonCheckedValue() {
        this.btnCheckValue.click();
    }

    public String submitYourChoice() {
        return yourchoice.getText();
    }

    public void femaleGroupCheck() {
        this.femaleBtnGroup.click();
    }

    public void maleGroupCheck() {
        this.maleBtnGroup.click();
    }

    public void ageGroup0to5Check() {
        this.ageGroup0to5.click();
    }

    public void ageGroup5to15Check() {
        this.ageGroup5to15.click();
    }

    public void ageGroup15to50Check() {
        this.ageGroup15to50.click();
    }

    public boolean isFemaleSelected() {
        return femaleBtnGroup.isSelected();
    }

    public boolean isMaleSelected() {
        return maleBtnGroup.isSelected();
    }

    public boolean isAgeGroup0to5Selected() {
        return ageGroup0to5.isSelected();
    }

    public boolean isAgeGroup5to15Selected() {
        return ageGroup5to15.isSelected();
    }

    public boolean isAgeGroup15to50Selected() {
        return ageGroup15to50.isSelected();
    }

    public void submitYourGroupChoice() {
        this.btnGetValues.click();
    }

    public String confirmYourGroupChoice() {
        return yourGroupChoice.getText();
    }

    public String confirmYourGroupSexChoice() {
        return yourGroupSexChoice.getText();
    }

    public String confirmYourGroupAgeChoice() {
        return yourGroupAgeChoice.getText();
    }

}
