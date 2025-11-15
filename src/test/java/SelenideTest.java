import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import pages.SelenidePage;

import static constants.Constants.REPOSITORY;

public class SelenideTest extends TestBase {

    @Test
    public void testIssueSearch() {
        SelenidePage selenidePage = new SelenidePage();

        SelenideLogger.addListener("allure", new AllureSelenide());
        selenidePage.openPage()
                .openSearchInput()
                .textSearchInput(REPOSITORY)
                .setLink()
                .issuesCount()
                .spanClass();
    }
}
