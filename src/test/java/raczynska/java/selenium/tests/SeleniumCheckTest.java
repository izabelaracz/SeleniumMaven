package raczynska.java.selenium.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import raczynska.java.selenium.pageObject.CheckboxPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SeleniumCheckTest extends FunctionalTest {
    private static CheckboxPage checkboxPage = new CheckboxPage(browser);

    @BeforeEach
    public void init() {
        checkboxPage.navigateTo("basic-checkbox-demo.html");
    }

    @Test
    public void singleCheckboxDemoTest() {
        checkboxPage.checkAgeSelector();

        assertTrue(checkboxPage.ifAgeSelected());
    }

    @Test
    public void multipleCheckboxDemoButtonChangeTextTest() {
        checkboxPage.chooseAll();

        assertEquals("Uncheck All", checkboxPage.textOnBtnCheck());
    }

    @Test
    public void multipleCheckboxDemoChkAllAtOnceTest() {
        checkboxPage.chooseAll();

        assertTrue(checkboxPage.ifAllCheck());
    }

    @Test
    public void multipleCheckboxDemoUnchkOneTest() {
        checkboxPage.chooseAll();
        checkboxPage.checkOption2();

        assertEquals("Check All", checkboxPage.textOnBtnCheck());
    }

}