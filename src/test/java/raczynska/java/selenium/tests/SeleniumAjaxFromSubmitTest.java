package raczynska.java.selenium.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import raczynska.java.selenium.pageObject.AjaxFromSubmitPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeleniumAjaxFromSubmitTest extends FunctionalTest {
    private static AjaxFromSubmitPage ajaxFromSubmitPage = new AjaxFromSubmitPage(browser);

    @BeforeEach
    public void init() {
        ajaxFromSubmitPage.navigateTo("ajax-form-submit-demo.html");
    }

    @Test
    public void ajaxFromSubmitIfNameIsEmptyBorderlineTest() {
        ajaxFromSubmitPage.submit();

        assertEquals("border: 1px solid rgb(255, 0, 0);", ajaxFromSubmitPage.confirmChangeBorder());
    }

    @Test
    public void ajaxFromSubmitIfNameIsEmptyTest() {
        ajaxFromSubmitPage.submit();

        assertEquals("*", ajaxFromSubmitPage.confirmLabelStar());
    }

    @Test
    public void ajaxFromSubmitLoadingTest() {
        ajaxFromSubmitPage.enterUsername("AlaMaKota");
        ajaxFromSubmitPage.submit();
        ajaxFromSubmitPage.waitUntilGifAppears();

        assertEquals("Ajax Request is Processing!", ajaxFromSubmitPage.confirmSubmitControl());
    }

    @Test
    public void ajaxFromSubmitOnlyNameTest() {
        ajaxFromSubmitPage.enterUsername("AlaMaKota");
        ajaxFromSubmitPage.submit();
        ajaxFromSubmitPage.waitUntilTextChange();

        assertEquals("Form submited Successfully!", ajaxFromSubmitPage.confirmSubmitControl());
    }

}