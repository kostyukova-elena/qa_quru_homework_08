package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static constants.Constants.ISSUES;

public class SelenidePage {

    private final SelenideElement searchInput = $(".search-input");
    private final SelenideElement queryBuilderTest = $("#query-builder-test");
    private final SelenideElement setLink = $("a[href='/kostyukova-elena/qa_quru_homework_08']");
    private final SelenideElement issuesCount = $("#issues-tab");
    private final SelenideElement spanClass = $("div[data-testid='list-row-repo-name-and-number']");

    public SelenidePage openPage() {
        open("/");
        return this;
    }

    public SelenidePage openSearchInput() {
        searchInput.click();
        return this;
    }

    public SelenidePage textSearchInput(String value) {
        queryBuilderTest.setValue(value).pressEnter();
        return this;
    }

    public SelenidePage setLink() {
        setLink.shouldBe(visible, Duration.ofSeconds(10)).shouldBe(clickable).click();
        return this;
    }

    public SelenidePage issuesCount() {
        issuesCount.click();
        return this;
    }

    public SelenidePage spanClass() {
        spanClass.$(withText(ISSUES)).shouldBe(visible);
        return this;
    }
}
