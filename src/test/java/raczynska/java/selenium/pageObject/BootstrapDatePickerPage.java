package raczynska.java.selenium.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BootstrapDatePickerPage extends PageObject{

    @FindBy(xpath = "//*[@id=\"sandbox-container1\"]/div/span/i")
    private WebElement btnCalendar;

    @FindBy(xpath = "//*[@id=\"sandbox-container1\"]/div/input")
    private WebElement selectedDateDisplay;

    @FindBy(xpath = "/html/body/div[3]/div[1]/table/tfoot/tr[1]/th")
    private WebElement today;

    @FindBy(xpath = "/html/body/div[3]/div[1]/table/tfoot/tr[2]/th")
    private WebElement clear;

    @FindBy(xpath = "/html/body/div[3]/div[1]/table/tbody/tr[6]/td[6]")
    private WebElement futureMonthDay;

    @FindBy(xpath = "/html/body/div[3]/div[1]/table/tbody/tr[2]/td[7]")
    private WebElement sunday;

    @FindBy(xpath = "//*[@id=\"datepicker\"]/input[1]")
    private WebElement startDate;

    @FindBy(xpath = "//*[@id=\"datepicker\"]/input[2]")
    private WebElement endDate;

    @FindBy(xpath = "/html/body/div[3]/div[1]/table/tbody/tr[1]/td[7]")
    private WebElement firstSaturday;

    @FindBy(xpath = "/html/body/div[3]/div[1]/table/tbody/tr[1]/td[2]")
    private WebElement firstMonday;

    public BootstrapDatePickerPage(WebDriver browser) {
        super(browser);
    }

    public void showCalendar() {
        this.btnCalendar.click();
    }

    public void selectToday() {
        this.today.click();
    }

    public void clearDateDisplay() {
        this.clear.click();
    }

    public String confirmSelectedDate() {
        return selectedDateDisplay.getAttribute("value");
    }

    public void selectFuture() {
        this.futureMonthDay.click();
    }

    public boolean ifFutureSelected() {
        return futureMonthDay.isSelected();
    }

    public void selectSunday() {
        this.sunday.click();
    }

    public boolean ifSundaySelected() {
        return sunday.isSelected();
    }

    public void selectStartDate() {
        this.startDate.click();
    }

    public String confirmSelectedStartDate() {
        return startDate.getAttribute("value");
    }

    public void selectEndDate() {
        this.endDate.click();
    }

    public String confirmSelectedEndDate() {
        return endDate.getAttribute("value");
    }

    public void selectFirstSaturday() {
        this.firstSaturday.click();
    }

    public void selectFirstMonday() {
        this.firstMonday.click();
    }

    public void enterDate(String date) {
        this.selectedDateDisplay.clear();
        this.selectedDateDisplay.sendKeys(date, Keys.ENTER);
    }
}
