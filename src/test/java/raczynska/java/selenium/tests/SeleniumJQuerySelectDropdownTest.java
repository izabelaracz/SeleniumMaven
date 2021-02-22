package raczynska.java.selenium.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import raczynska.java.selenium.pageObject.JQueryDropdownPage;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeleniumJQuerySelectDropdownTest extends FunctionalTest {
    private static JQueryDropdownPage jQueryDropdownPage = new JQueryDropdownPage(browser);

    @BeforeEach
    public void init() {
        jQueryDropdownPage.navigateTo("jquery-dropdown-search-demo.html");
    }

    @Test
    public void dropDownWithSearchBoxNoResultTest() {
        jQueryDropdownPage.dropdownCountrySelect();
        jQueryDropdownPage.enterCountry("Polska");

        assertEquals("No results found", jQueryDropdownPage.confirmResultSearchMessage());
    }

    @Test
    public void dropDownWithSearchBoxTest() {
        jQueryDropdownPage.dropdownCountrySelect();
        jQueryDropdownPage.enterAndSubmitCountry("Australia");

        assertEquals("Australia", jQueryDropdownPage.confirmCountry());
    }

    @Test
    public void dropDownWithSearchBoxMultipleOptionTest() {
        boolean flag = false;
        List<String> coutries = new ArrayList<>();
        coutries.add("Australia");
        coutries.add("India");
        coutries.add("South Africa");
        coutries.add("United States of America");

        jQueryDropdownPage.dropdownCountrySelect();
        jQueryDropdownPage.enterCountry("i");

        List<WebElement> items = browser.findElements(By.xpath("//ul[@id='select2-country-results']/li"));

        for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < coutries.size(); j++) {
                if (items.get(i).getText().equals(coutries.get(j))) {
                    flag = true;
                    break;
                }
            }
        }

        assertTrue(flag);
    }


    @Test
    public void selectMultipleValuesTest() {
        boolean flag = false;
        List<String> states = new ArrayList<>();
        states.add("Alabama");
        states.add("California");
        states.add("Virginia");

        jQueryDropdownPage.searchState("al");
        browser.findElement(By.cssSelector("[id*='-AL']")).click();

        jQueryDropdownPage.searchState("ca");
        browser.findElement(By.cssSelector("[id*='-CA']")).click();

        jQueryDropdownPage.searchState("v");
        browser.findElement(By.cssSelector("[id*='-VA']")).click();

        List<WebElement> items = browser.findElements(By.className("select2-selection__choice"));

        for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < states.size(); j++) {
                if (items.get(i).getAttribute("title").equals(states.get(j))) {
                    flag = true;
                    break;
                }
            }
        }

        assertTrue(flag);
    }

    @Test
    public void selectMultipleValuesRemoveFromListTest() {
        boolean flag = false;
        List<String> states = new ArrayList<>();
        states.add("Alabama");
        states.add("Virginia");

        jQueryDropdownPage.searchState("al");
        browser.findElement(By.cssSelector("[id*='-AL']")).click();

        jQueryDropdownPage.searchState("ca");
        browser.findElement(By.cssSelector("[id*='-CA']")).click();

        jQueryDropdownPage.searchState("v");
        browser.findElement(By.cssSelector("[id*='-VA']")).click();

        jQueryDropdownPage.closeCalifornia();

        List<WebElement> items = browser.findElements(By.className("select2-selection__choice"));

        for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < states.size(); j++) {
                if (items.get(i).getAttribute("title").equals(states.get(j))) {
                    flag = true;
                    break;
                }
            }
        }

        assertTrue(flag);
    }

    @Test
    public void dropDownWithDisabledValuesTest() {
        jQueryDropdownPage.dropdownUSTeritories();
        jQueryDropdownPage.enterUSTeritory("gu");
        browser.findElement(By.cssSelector("[id*='-GU']")).click();

        assertEquals("American Samoa", jQueryDropdownPage.confirmUSContainer());
    }


    @Test
    public void DropDownWithCategoryRelatedOptionsNotInteractableTest() {
        jQueryDropdownPage.dropdownFiles();

        assertThrows(ElementNotInteractableException.class, () -> {
            jQueryDropdownPage.selectScriptLanguages();
        });
    }
}