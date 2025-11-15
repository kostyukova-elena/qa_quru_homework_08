package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static constants.Constants.ISSUES;
import static constants.Constants.REPOSITORY;

public class WebStepsPage {

    private final SelenideElement searchInput = $(".search-input");
    private final SelenideElement queryBuilderTest = $("#query-builder-test");
    private final SelenideElement setLink = $("a[href='/kostyukova-elena/qa_quru_homework_08']");
    private final SelenideElement issuesCount = $("#issues-tab");
    private final SelenideElement spanClass = $("div[data-testid='list-row-repo-name-and-number']");

    @Step("Открываем главную страницу")
    public WebStepsPage openPage() {
        open("/");
        return this;
    }

    @Step("Ищем репозиторий " + REPOSITORY)
    public WebStepsPage openSearchInput() {
        searchInput.click();
        return this;
    }

    @Step("Кликаем по ссылке репозитория " + REPOSITORY)
    public WebStepsPage textSearchInput(String value) {
        queryBuilderTest.setValue(value).pressEnter();
        return this;
    }

    @Step("Кликаем по ссылке репозитория " + REPOSITORY)
    public WebStepsPage setLink() {
        setLink.shouldBe(visible, Duration.ofSeconds(10)).shouldBe(clickable).click();
        return this;
    }

    @Step("Открываем таб Issues")
    public WebStepsPage issuesCount() {
        issuesCount.click();
        return this;
    }

    @Step("Проверяем наличие Issues с номером " + ISSUES)
    public WebStepsPage spanClass() {
        spanClass.$(withText(ISSUES)).shouldBe(visible);
        return this;
    }
}
