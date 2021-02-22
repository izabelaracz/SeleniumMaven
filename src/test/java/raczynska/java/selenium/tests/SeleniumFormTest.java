package raczynska.java.selenium.tests;

import org.junit.jupiter.api.*;
import raczynska.java.selenium.pageObject.FormPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeleniumFormTest extends FunctionalTest {
    private static FormPage formPage = new FormPage(browser);

    @BeforeEach
    public void init() {
        formPage.navigateTo("basic-first-form-demo.html");
    }

    @Test
    public void singleInputFieldTest() {
        if (formPage.ifDarkenerIsDisplayed()) {
            formPage.closeDarkener();
        }

        formPage.enterMessage("This is Iza");
        formPage.submitMessage();

        assertEquals("This is Iza", formPage.confirmationYourMessage());
    }

    @Test
    public void twoInputFieldTest() {
        formPage.enterValueOne("2");
        formPage.enterValueTwo("4");
        formPage.submitValues();

        assertEquals("6", formPage.confirmationTotal());
    }

    @Test
    public void twoInputFieldOpositeTest() {
        formPage.enterValueOne("-2");
        formPage.enterValueTwo("4");
        formPage.submitValues();

        assertEquals("2", formPage.confirmationTotal());
    }

    @Test
    public void twoInputFieldBelowZeroTest() {
        formPage.enterValueOne("-2");
        formPage.enterValueTwo("-4");
        formPage.submitValues();

        assertEquals("-6", formPage.confirmationTotal());
    }

    @Test
    public void twoInputFieldNaNTest() {
        formPage.enterValueOne("a");
        formPage.enterValueTwo("4");
        formPage.submitValues();

        assertEquals("NaN", formPage.confirmationTotal());
    }
}