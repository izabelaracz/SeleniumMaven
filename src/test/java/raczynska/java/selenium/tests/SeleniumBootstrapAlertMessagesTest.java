package raczynska.java.selenium.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import raczynska.java.selenium.pageObject.AlertMsgPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SeleniumBootstrapAlertMessagesTest extends FunctionalTest {
    private static AlertMsgPage alertMsgPage = new AlertMsgPage(browser);

    @BeforeEach
    public void init() {
        alertMsgPage.navigateTo("bootstrap-alert-messages-demo.html");
    }

    @Test
    public void bootstrapAlertMessagesAutocloseSuccessMsgTest() {
        alertMsgPage.selectAutocloseSuccessMsg();

        assertFalse(alertMsgPage.ifAutocloseSuccessMsgEnable());
    }

    @Test
    public void bootstrapAlertMessagesAutocloseSuccessMsgWaitTest() {
        alertMsgPage.selectAutocloseSuccessMsg();
        alertMsgPage.waitUntilSuccessMsgDisappear();

        assertTrue(alertMsgPage.ifAutocloseSuccessMsgEnable());
    }

    @Test
    public void bootstrapAlertMessagesNormalSuccessMsgTest() {
        alertMsgPage.selectNormalSuccessMsg();

        assertTrue(alertMsgPage.ifNormalSuccessInfoXEnable());
    }

    @Test
    public void bootstrapAlertMessagesNormalSuccessMsgClickTest() {
        alertMsgPage.selectNormalSuccessMsg();

        assertTrue(alertMsgPage.ifNormalSuccessMsgEnable());
    }

    @Test
    public void bootstrapAlertMessagesNormalSuccessMsgXTest() {
        alertMsgPage.selectNormalSuccessMsg();
        alertMsgPage.closeNormalSuccessInfo();

        assertFalse(alertMsgPage.ifNormalSuccessInfoDisplayed());
    }

    @Test
    public void bootstrapAlertMessagesAutocloseWarnMsgTest() {
        alertMsgPage.selectAutocloseWarnMsg();

        assertFalse(alertMsgPage.ifAutocloseWarnMsgEnable());
    }

    @Test
    public void bootstrapAlertMessagesAutocloseWarnMsgWaitTest() {
        alertMsgPage.selectAutocloseWarnMsg();
        alertMsgPage.waitUntilWarnMsgDisappear();

        assertTrue(alertMsgPage.ifAutocloseWarnMsgEnable());
    }

    @Test
    public void bootstrapAlertMessagesNormalWarnMsgTest() {
        alertMsgPage.selectNormalWarnMsg();

        assertTrue(alertMsgPage.ifNormalWarnInfoXEnable());
    }

    @Test
    public void bootstrapAlertMessagesNormalWarnMsgClickTest() {
        alertMsgPage.selectNormalWarnMsg();

        assertTrue(alertMsgPage.ifNormalWarnMsgEnable());
    }

    @Test
    public void bootstrapAlertMessagesNormalWarnMsgXTest() {
        alertMsgPage.selectNormalWarnMsg();
        alertMsgPage.closeNormalWarnInfo();

        assertFalse(alertMsgPage.ifNormalWarnInfoDisplayed());
    }

    @Test
    public void bootstrapAlertMessagesAutocloseDangerMsgTest() {
        alertMsgPage.selectAutocloseDangerMsg();

        assertFalse(alertMsgPage.ifAutocloseDangerMsgEnable());
    }

    @Test
    public void bootstrapAlertMessagesAutocloseDangerMsgWaitTest() {
        alertMsgPage.selectAutocloseDangerMsg();
        alertMsgPage.waitUntilDangerMsgDisappear();

        assertTrue(alertMsgPage.ifAutocloseDangerMsgEnable());
    }

    @Test
    public void bootstrapAlertMessagesNormalDangerMsgTest() {
        alertMsgPage.selectNormalDangerMsg();

        assertTrue(alertMsgPage.ifNormalDangerInfoXEnable());
    }

    @Test
    public void bootstrapAlertMessagesNormalDangerMsgClickTest() {
        alertMsgPage.selectNormalDangerMsg();

        assertTrue(alertMsgPage.ifNormalDangerMsgEnable());
    }

    @Test
    public void bootstrapAlertMessagesNormalDangerMsgXTest() {
        alertMsgPage.selectNormalDangerMsg();
        alertMsgPage.closeNormalDangerInfo();

        assertFalse(alertMsgPage.ifNormalDangerInfoDisplayed());
    }

    @Test
    public void bootstrapAlertMessagesAutocloseInfoMsgTest() {
        alertMsgPage.selectAutocloseInfoMsg();

        assertFalse(alertMsgPage.ifAutocloseInfoMsgEnable());
    }

    @Test
    public void bootstrapAlertMessagesAutocloseInfoMsgWaitTest() {
        alertMsgPage.selectAutocloseInfoMsg();
        alertMsgPage.waitUntilInfoMsgDisappear();

        assertTrue(alertMsgPage.ifAutocloseInfoMsgEnable());
    }

    @Test
    public void bootstrapAlertMessagesNormalInfoMsgTest() {
        alertMsgPage.selectNormalInfoMsg();

        assertTrue(alertMsgPage.ifNormalInfoInfoXEnable());
    }

    @Test
    public void bootstrapAlertMessagesNormalInfoMsgClickTest() {
        alertMsgPage.selectNormalInfoMsg();

        assertTrue(alertMsgPage.ifNormalInfoMsgEnable());
    }

    @Test
    public void bootstrapAlertMessagesNormalInfoMsgXTest() {
        alertMsgPage.selectNormalInfoMsg();
        alertMsgPage.closeNormalInfoInfo();

        assertFalse(alertMsgPage.ifNormalInfoInfoDisplayed());
    }

}