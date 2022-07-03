package homeWork;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class homeWorkTest extends BaseTests {
    WelcomePage welcomePage;
    ShareDataPage shareDataPage;
    SetPasswordPage setPasswordPage;
    BackUpInstructionPage backUpInstructionPage;
    SecretPhrasePage secretPhrasePage;
    ConfirmSecretPhrasePage confirmSecretPhrasePage;
    OpenWalletPage openWalletPage;

    @Test
    public void testTrustWalletHapyPath() throws InterruptedException {
        welcomePage = new WelcomePage(driver);
        assertTrue(welcomePage.welcomePageIsLoaded());
        shareDataPage = welcomePage.getShareDataPage(driver);
        assertTrue(shareDataPage.shareDataPageIsLoaded());
        setPasswordPage = shareDataPage.getPasswordPage(driver);
        setPasswordPage.setPasswordPageIsLoaded();
        setPasswordPage.setPassword("Bin@nce10");
        setPasswordPage.confirmPassword("Bin@nce10");
        setPasswordPage.confirmCheckbox();
        backUpInstructionPage = setPasswordPage.getBackUpInstructionPage(driver);
        assertTrue(backUpInstructionPage.backUpInstructionPageIsLoaded());
        secretPhrasePage = backUpInstructionPage.getSecretPhrasePage(driver);
        assertTrue(secretPhrasePage.secretPhraseIsLoaded());
        secretPhrasePage.revealPhrase();
        List<String> phrase = secretPhrasePage.getSecretPhrase();
        confirmSecretPhrasePage = secretPhrasePage.getConfirmSecretPhrasePage(driver);
        assertTrue(confirmSecretPhrasePage.confirmSecretPhrasePageIsLoaded());
        confirmSecretPhrasePage.printSecretPhrase(phrase);
        openWalletPage = confirmSecretPhrasePage.getOpenWalletPage(driver);
        assertTrue(openWalletPage.openWalletPageIsLoaded());

    }

}
