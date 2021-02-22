package raczynska.java.selenium.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import raczynska.java.selenium.pageObject.SelectDropdownListPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeleniumSelectDropdownListTest extends FunctionalTest {
    private static SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage(browser);

    @BeforeEach
    public void init() {
        selectDropdownListPage.navigateTo("basic-select-dropdown-demo.html");
    }

    @Test
    public void selectListDemoTest() {
        selectDropdownListPage.dropdownDaysList();
        selectDropdownListPage.selectFriday();

        assertEquals("Day selected :- Friday", selectDropdownListPage.confirmSelectedDay());
    }

    @Test
    public void multiSelectListDemoFirstClickTest() {
        selectDropdownListPage.selectWithCTRL();
        selectDropdownListPage.showFirstSelected();

        assertEquals("First selected option is : Texas", selectDropdownListPage.confirmSelectedStates());
    }

    @Test
    public void multiSelectListDemoClickAllTest() {
        selectDropdownListPage.selectWithCTRL();
        selectDropdownListPage.showAllSelected();

        assertEquals("Options selected are : Ohio,Texas,Florida", selectDropdownListPage.confirmSelectedStates());
    }

}