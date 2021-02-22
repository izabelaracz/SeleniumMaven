package raczynska.java.selenium.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import raczynska.java.selenium.pageObject.BootstrapListBoxPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SeleniumBootstrapListBoxTest extends FunctionalTest {
    private static BootstrapListBoxPage bootstrapListBoxPage = new BootstrapListBoxPage(browser);

    @BeforeEach
    public void init() {
        bootstrapListBoxPage.navigateTo("bootstrap-dual-list-box-demo.html");
    }

    @Test
    public void dualListBoxOneElementTest() {
        boolean flag = false;

        List<WebElement> items = browser.findElements(By.xpath("//div[@class='well text-right']/ul[@class='list-group']/li"));

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getText().equals("Morbi leo risus"))
                items.get(i).click();
        }

        bootstrapListBoxPage.throwToOtherList();

        List<WebElement> items2 = browser.findElements(By.xpath("//div[@class='well']/ul[@class='list-group']/li"));
        for (int i = 0; i < items2.size(); i++) {
            if (items2.get(i).getText().equals("Morbi leo risus")) {
                flag = true;
                break;
            }
        }

        assertTrue(flag);
    }

    @Test
    public void dualListBoxAllElementsTest() {
        bootstrapListBoxPage.selectAll();
        bootstrapListBoxPage.throwToOtherList();
        List<WebElement> items = browser.findElements(By.xpath("//div[@class='well text-right']/ul[@class='list-group']/li"));

        assertTrue(items.isEmpty());
    }

    @Test
    public void dualListBoxSearchElementTest() {
        boolean flag = false;

        bootstrapListBoxPage.enterItemName("boo");
        bootstrapListBoxPage.selectAll();
        bootstrapListBoxPage.throwToOtherList();

        List<WebElement> items = browser.findElements(By.xpath("//div[@class='well']/ul[@class='list-group']/li"));
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getText().equals("bootstrap-duallist")) {
                flag = true;
                break;
            }
        }

        assertTrue(flag);
    }

    @Test
    public void dualListBoxRightToLeftTest() {
        boolean flag = false;

        bootstrapListBoxPage.enterItemName("boo");
        bootstrapListBoxPage.selectAll();
        bootstrapListBoxPage.throwToOtherList();
        bootstrapListBoxPage.backToOriginalList();

        List<WebElement> items2 = browser.findElements(By.xpath("//div[@class='well']/ul[@class='list-group']/li"));
        for (int i = 0; i < items2.size(); i++) {
            if (items2.get(i).getText().equals("bootstrap-duallist")) {
                flag = false;
            } else flag = true;
        }

        assertTrue(flag);
    }

}