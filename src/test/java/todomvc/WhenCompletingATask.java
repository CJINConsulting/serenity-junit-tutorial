package todomvc;

import common.actions.NavigateActions;
import common.pageobjects.FormPages;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import todomvc.actions.TodoListActions;
import todomvc.pageobjects.TodoListPage;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class WhenCompletingATask {

    @Managed(driver = "chrome")
    WebDriver driver;

    TodoListPage todoListPage;

    NavigateActions navigate;

    @Steps
    TodoListActions todoList;

    @BeforeEach
    void openList() {
        navigate.to(FormPages.ToDoPage);
    }

    @AfterEach
    void closeBrowser() {
        driver.close();
    }

    @Test
    void activeTasksShouldNotShowCompletedTasks() {
        todoList.addItems("walk the dog", "feed the cat");
        todoList.completeItems("feed the cat");
        todoList.filterBy("Active");

        Serenity.reportThat("Then the task list actions should match the active items",
                () -> assertThat(todoList.items()).containsExactly("walk the dog")
        );
    }

    @Test
    void completedTasksShouldNotShowActiveTasks() {
        todoList.addItems("walk the dog", "feed the cat");
        todoList.completeItems("feed the cat");
        todoList.filterBy("Completed");

        Serenity.reportThat("Then the task list actions should match the completed items",
                () -> assertThat(todoList.items()).containsExactly("feed the cat")
        );
    }

    @Test
    void allTasksShouldNotShowActiveAndCompletedTasks() {
        todoList.addItems("walk the dog", "feed the cat");
        todoList.completeItems("feed the cat");
        todoList.filterBy("All");

        Serenity.reportThat("Then the task list actions should match all items",
                () -> assertThat(todoList.items()).containsExactly("walk the dog", "feed the cat")
        );
    }

    @ParameterizedTest(name = "Should correctly filter the values '{3}' from '{0}' using filter '{2}' after completing item '{1}'")
    @MethodSource("generateData")
    void tasksShouldFilterCorrectly(List<String> items,
                                    String itemToComplete,
                                    String filterName,
                                    List<String> visibleItems) {
        todoList.addItems(items);
        todoList.completeItems(itemToComplete);
        todoList.filterBy(filterName);

        Serenity.reportThat("Then the task list actions should match all items",
                () -> assertThat(todoList.items()).containsExactlyElementsOf(visibleItems)
        );
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(asList("feed the cat","walk the dog"), "feed the cat", "Completed", asList("feed the cat")),
                Arguments.of(asList("feed the cat","walk the dog"), "feed the cat", "Active", asList("walk the dog")),
                Arguments.of(asList("feed the cat","walk the dog"), "feed the cat", "All", asList("feed the cat","walk the dog"))
        );
    }
}
