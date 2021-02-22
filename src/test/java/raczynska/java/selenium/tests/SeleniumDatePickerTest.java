package raczynska.java.selenium.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import raczynska.java.selenium.pageObject.BootstrapDatePickerPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SeleniumDatePickerTest extends FunctionalTest {
    private static BootstrapDatePickerPage bootstrapDatePickerPage = new BootstrapDatePickerPage(browser);
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @BeforeEach
    public void init() {
        bootstrapDatePickerPage.navigateTo("bootstrap-date-picker-demo.html");
    }

    @Test
    public void datePickerTodayTest() {
        bootstrapDatePickerPage.showCalendar();
        bootstrapDatePickerPage.selectToday();

        assertEquals(LocalDate.now().format(dtf), bootstrapDatePickerPage.confirmSelectedDate());
    }

    @Test
    public void datePickerClearTest() {
        bootstrapDatePickerPage.showCalendar();
        bootstrapDatePickerPage.selectToday();
        bootstrapDatePickerPage.showCalendar();
        bootstrapDatePickerPage.clearDateDisplay();

        assertEquals("", bootstrapDatePickerPage.confirmSelectedDate());
    }

    @Test
    public void datePickerFutureIsDisabledTest() {
        bootstrapDatePickerPage.showCalendar();
        bootstrapDatePickerPage.selectFuture();

        assertFalse(bootstrapDatePickerPage.ifFutureSelected());
    }

    @Test
    public void datePickerSundayIsDisabledTest() {
        bootstrapDatePickerPage.showCalendar();
        bootstrapDatePickerPage.selectSunday();

        assertFalse(bootstrapDatePickerPage.ifSundaySelected());
    }


    @Test
    public void dateRangeStartEqualEndTest() {
        bootstrapDatePickerPage.selectStartDate();
        bootstrapDatePickerPage.selectFirstSaturday();

        assertEquals(bootstrapDatePickerPage.confirmSelectedStartDate(), bootstrapDatePickerPage.confirmSelectedEndDate());
    }

    @Test
    public void dateRangeEndEqualStartTest() {
        bootstrapDatePickerPage.selectStartDate();
        bootstrapDatePickerPage.selectFirstSaturday();
        bootstrapDatePickerPage.selectEndDate();
        bootstrapDatePickerPage.selectFirstMonday();

        assertEquals(bootstrapDatePickerPage.confirmSelectedEndDate(), bootstrapDatePickerPage.confirmSelectedStartDate());
    }

}