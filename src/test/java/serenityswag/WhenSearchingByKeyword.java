package serenityswag;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import serenityswag.actions.NavigateSwagActions;
import serenityswag.actions.SearchActions;
import serenityswag.pages.SearchResultSidebar;

import static org.assertj.core.api.Assertions.assertThat;

//@ExtendWith(SerenityJUnit5Extension.class)
class WhenSearchingByKeyword {

    @Managed(driver = "chrome")
    WebDriver driver;

    NavigateSwagActions navigate;
    SearchActions search;
    SearchResultSidebar searchResultSidebar;

    @Test
    void theKeywordShouldAppearInTheResultsSidebar() {
        navigate.toTheDuckDuckGoSearchPage();
        search.byKeyword("Cucumber");

        Serenity.reportThat("Then the keyword should appear in the sidebar heading",
                () -> assertThat(searchResultSidebar.heading()).isEqualTo("Cucumber")
        );

    }
}
