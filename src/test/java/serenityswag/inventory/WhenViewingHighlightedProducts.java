package serenityswag.inventory;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import serenityswag.actions.LoginActions;
import serenityswag.actions.ViewProductDetailsActions;
import serenityswag.pages.ProductDetailsPage;
import serenityswag.pages.ProductListPage;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static serenityswag.authentication.User.STANDARD_USER;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenViewingHighlightedProducts {
    @Managed
    private WebDriver driver;

    @Steps
    LoginActions login;

    @Steps
    ViewProductDetailsActions viewProductDetails;

    ProductListPage productList;

    ProductDetailsPage productDetails;

    @Test
    public void shouldDisplayHighlightedProductsOnTheWelcomePage() {

        login.as(STANDARD_USER);

        // Should see product catalogue
        Serenity.reportThat("There are 6 highlighted products on the page",
                () -> assertThat(productList.getProductTitles())
                        .hasSize(6)
                        .contains("Sauce Labs Backpack")
        );
    }

    @Test
    public void shouldDisplayCorrectProductDetailsPage() {

        login.as(STANDARD_USER);

        String firstItemName = productList.getProductTitles().get(0);
        productList.openProductDetailsFor(firstItemName);

        // Should see product catalogue
        Serenity.reportThat("The product detail title is correct",
                () -> assertThat(productDetails.getProductName())
                        .isEqualTo(firstItemName)
        );

        Serenity.reportThat("The product image alt text is correct",
                () -> productDetails.getProductImageWithAltValueOf(firstItemName).shouldBeVisible()
        );
    }

    @Test
    public void shouldDisplayCorrectProductDetails() {

        login.as(STANDARD_USER);

        String firstItemName = productList.getProductTitles().get(0);
        viewProductDetails.forProductWithName(firstItemName);

        // Should see product catalogue
        Serenity.reportThat("The product detail title is correct",
                () -> assertThat(productDetails.getProductName())
                        .isEqualTo(firstItemName)
        );

        Serenity.reportThat("The product image alt text is correct",
                () -> productDetails.getProductImageWithAltValueOf(firstItemName).shouldBeVisible()
        );
    }
}
