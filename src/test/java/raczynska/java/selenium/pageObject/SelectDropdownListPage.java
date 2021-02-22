package raczynska.java.selenium.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SelectDropdownListPage extends PageObject{

    @FindBy(xpath = "//*[@id=\"select-demo\"]")
    private WebElement daySelect;

    @FindBy(xpath = "//*[@id=\"select-demo\"]/option[2]")
    private WebElement sunday;

    @FindBy(xpath = "//*[@id=\"select-demo\"]/option[3]")
    private WebElement monday;

    @FindBy(xpath = "//*[@id=\"select-demo\"]/option[4]")
    private WebElement tuesday;

    @FindBy(xpath = "//*[@id=\"select-demo\"]/option[5]")
    private WebElement wednesday;

    @FindBy(xpath = "//*[@id=\"select-demo\"]/option[6]")
    private WebElement thursday;

    @FindBy(xpath = "//*[@id=\"select-demo\"]/option[8]")
    private WebElement saturday;

    @FindBy(xpath = "//*[@id=\"select-demo\"]/option[7]")
    private WebElement friday;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/p[2]")
    private WebElement yourSelectedDay;

    @FindBy(xpath = "//*[@id=\"multi-select\"]/option[5]")
    private WebElement ohio;

    @FindBy(xpath = "//*[@id=\"multi-select\"]/option[2]")
    private WebElement florida;

    @FindBy(xpath = "//*[@id=\"multi-select\"]/option[6]")
    private WebElement texas;

    @FindBy(id = "printMe")
    private WebElement btnFirstSelected;

    @FindBy(id = "printAll")
    private WebElement btnAllSelected;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]")
    private WebElement yourSelectedStates;

    public SelectDropdownListPage(WebDriver browser) {
        super(browser);
    }

    public void dropdownDaysList() {
        this.daySelect.click();
    }

    public void selectFriday() {
        this.friday.click();
    }

    public void selectSunday() {
        this.sunday.click();
    }

    public void selectMonday() {
        this.monday.click();
    }

    public void selectThursday() {
        this.thursday.click();
    }

    public void selectWednesday() {
        this.wednesday.click();
    }

    public void selectTuesday() {
        this.tuesday.click();
    }

    public void selectSaturday() {
        this.saturday.click();
    }

    public String confirmSelectedDay() {
        return yourSelectedDay.getText();
    }

    public void selectOhio() {
        this.ohio.click();
    }

    public void selectFlorida() {
        this.florida.click();
    }

    public void selectTexas() {
        this.texas.click();
    }

    public void selectWithCTRL() {
        Actions actions = new Actions(browser);
        actions.keyDown(Keys.LEFT_CONTROL)
                .click(ohio)
                .click(texas)
                .click(florida)
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
    }

    public void showFirstSelected() {
        this.btnFirstSelected.click();
    }

    public void showAllSelected() {
        this.btnAllSelected.click();
    }

    public String confirmSelectedStates() {
        return yourSelectedStates.getText();
    }
}
