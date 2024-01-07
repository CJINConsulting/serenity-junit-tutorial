package todomvc;

import common.pageobjects.FormPages;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import common.actions.NavigateActions;
import todomvc.actions.TodoListActions;
import todomvc.pageobjects.TodoListPage;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class WhenAddingATask {

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
    void addingASingleItemToAList() {

        todoList.addItem("walk the dog");

        Serenity.reportThat("Then the added item should be in the list",
                () -> assertThat(todoList.items()).containsExactly("walk the dog")
        );

    }

    @Test
    void addingMultipleItemsToAList() {

        todoList.addItems("walk the dog", "feed the cat");

        Serenity.reportThat("Then the task list actions should match the selected items",
                () -> assertThat(todoList.items()).containsExactly("walk the dog", "feed the cat")
        );

    }




}
