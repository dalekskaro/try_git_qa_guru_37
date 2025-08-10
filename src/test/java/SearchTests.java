import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests {
    @Test
    @DisplayName("Проверка, что поиск не прошел")
    void notSuccessfulSearchTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("html").shouldNotHave(text("https://selenide.org"));
    }

    @Test
    @DisplayName("Проверка капчи в google")
    void capchaTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("html").shouldHave(text("Об этой странице"));
    }

    @Test
    @DisplayName("Проверка поиска на вб")
    void successfulSearchWbTest() {
        open("https://www.wildberries.ru/");
        $("[id=searchInput]").setValue("qa").pressEnter();
        $("[class=searching-results__title]").shouldHave(text("Qa"));
    }
}