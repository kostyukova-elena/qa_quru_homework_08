import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import pages.SelenidePage;
import pages.WebStepsPage;

import static constants.Constants.ISSUES;
import static constants.Constants.REPOSITORY;
import static io.qameta.allure.Allure.step;

public class StepsTest extends TestBase {

    @Test
    public void testLambdaStep() {
        SelenidePage selenidePage = new SelenidePage();

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            selenidePage.openPage();
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            selenidePage.openSearchInput()
                    .textSearchInput(REPOSITORY);
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            selenidePage.setLink();
        });
        step("Открываем таб Issues", () -> {
            selenidePage.issuesCount();
        });
        step("Проверяем наличие Issues с номером " + ISSUES);
        selenidePage.issuesCount()
                .spanClass();
    }

    @Test
    public void testAnnotatedStep() {
        WebStepsPage webStepsPage = new WebStepsPage();

        SelenideLogger.addListener("allure", new AllureSelenide());

        webStepsPage.openPage();
        webStepsPage.openSearchInput();
        webStepsPage.textSearchInput(REPOSITORY);
        webStepsPage.setLink();
        webStepsPage.issuesCount();
        webStepsPage.spanClass();
    }
}
