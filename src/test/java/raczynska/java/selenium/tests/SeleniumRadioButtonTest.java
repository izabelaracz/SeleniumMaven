package raczynska.java.selenium.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import raczynska.java.selenium.pageObject.RadioButtonPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeleniumRadioButtonTest extends FunctionalTest {
    private static RadioButtonPage radioButtonPage = new RadioButtonPage(browser);

    @BeforeEach
    public void init() {
        radioButtonPage.navigateTo("basic-radiobutton-demo.html");
    }

    @Test
    public void radioButtonDemoTest() {
        radioButtonPage.femaleCheck();
        radioButtonPage.buttonCheckedValue();

        assertEquals("Radio button 'Female' is checked", radioButtonPage.submitYourChoice());
    }

    @Test
    public void groupRadioButtonsDemoTest() {
        radioButtonPage.maleGroupCheck();
        radioButtonPage.ageGroup5to15Check();
        radioButtonPage.submitYourGroupChoice();

        assertEquals("Sex : Male\nAge group: 5 - 15", radioButtonPage.confirmYourGroupChoice());
    }

    @Test
    public void groupRadioButtonsDemoOnlyOneValueTest() {
        radioButtonPage.maleGroupCheck();
        radioButtonPage.femaleGroupCheck();
        radioButtonPage.ageGroup5to15Check();
        radioButtonPage.submitYourGroupChoice();

        assertEquals("Sex : Female\nAge group: 5 - 15", radioButtonPage.confirmYourGroupChoice());
    }

}