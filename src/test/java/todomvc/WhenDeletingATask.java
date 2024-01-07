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
import org.openqa.selenium.WebDriver;
import todomvc.actions.TodoListActions;
import todomvc.pageobjects.TodoListPage;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class WhenDeletingATask {

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
    void deletedItemsShouldDisappearFromTheList() {
        todoList.addItems("walk the dog", "feed the cat");
        todoList.deleteItems("walk the dog");

        Serenity.reportThat("Then the task list actions should match the active items",
                () -> assertThat(todoList.items()).containsExactly("feed the cat")
        );
    }

}
