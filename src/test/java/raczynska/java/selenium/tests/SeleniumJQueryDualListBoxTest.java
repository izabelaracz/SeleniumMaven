package raczynska.java.selenium.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import raczynska.java.selenium.pageObject.JQueryListBoxPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeleniumJQueryDualListBoxTest extends FunctionalTest {
    private static JQueryListBoxPage jQueryListBoxPage = new JQueryListBoxPage(browser);

    @BeforeEach
    public void init() {
        jQueryListBoxPage.navigateTo("jquery-dual-list-box-demo.html");
    }

    @Test
    public void jQueryDualListBoxAddTest() {
        String[] expected = {"Sophia", "Isabella"};

        jQueryListBoxPage.chooseSophia();
        jQueryListBoxPage.chooseIsabella();
        jQueryListBoxPage.addItem();

        List<WebElement> items = browser.findElements(By.xpath("//*[@id=\"pickList\"]/div/div[3]/select/option"));
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], items.get(i).getText());
        }
    }

    @Test
    public void jQueryDualListBoxAddAllTest() {
        String[] expected = {"Isis", "Sophia", "Alice", "Isabella", "Manuela", "Laura", "Luiza", "Valentina", "Giovanna", "Maria Eduarda", "Helena", "Beatriz", "Maria Luiza", "Lara", "Julia"};

        jQueryListBoxPage.addAll();

        List<WebElement> items = browser.findElements(By.xpath("//*[@id=\"pickList\"]/div/div[3]/select/option"));
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], items.get(i).getText());
        }
    }

    @Test
    public void jQueryDualListBoxRemoveTest() {
        jQueryListBoxPage.chooseSophia();
        jQueryListBoxPage.addItem();
        jQueryListBoxPage.chooseSophiaOnOtherList();
        jQueryListBoxPage.removeItem();

        List<WebElement> firstList = browser.findElements(By.xpath("//*[@id=\"pickList\"]/div/div[1]/select/option"));

        assertEquals("Sophia", firstList.get(firstList.size() - 1).getText());
    }

    @Test
    public void jQueryDualListBoxRemoveAllTest() {
        String[] expected = {"Isabella", "Sophia"};

        jQueryListBoxPage.chooseSophia();
        jQueryListBoxPage.chooseIsabella();
        jQueryListBoxPage.addItem();
        jQueryListBoxPage.removeAll();

        List<WebElement> firstList = browser.findElements(By.xpath("//*[@id=\"pickList\"]/div/div[1]/select/option"));
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], firstList.get(firstList.size() - (1 + i)).getText());
        }
    }

}