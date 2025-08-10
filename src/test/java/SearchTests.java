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
        $("[id=searchInput]").setValue("Кепка").pressEnter();
        $("[class=searching-results__title]").shouldHave(text("Кепка"));
    }

    @Test
    @DisplayName("Проверка поиска в яндексе")
    void successfulSearchYandexTest() {
        open("https://ya.ru/");
        $("[class=search3__input-inner-container]").click();
        $("[aria-label=Запрос]").setValue("qa guru").pressEnter();
        $("[id=search-result]").shouldHave(text("qa.guru"));
    }
}