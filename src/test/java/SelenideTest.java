import org.junit.jupiter.api.Test;
import pages.SelenidePage;

import static constants.Constants.REPOSITORY;

public class SelenideTest extends TestBase {

    SelenidePage selenidePage = new SelenidePage();

    @Test
    public void testIssueSearch() {
        selenidePage.openPage()
                .openSearchInput()
                .textSearchInput(REPOSITORY)
                .setLink()
                .issuesCount()
                .spanClass();
    }
}
