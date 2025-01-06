package emall.ui.cartPage;

import emall.BaseTest;
import emall.ui.homePage.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CartPageTests extends BaseTest {

    @DisplayName("Add 3 items to cart")
    @Test
    public void test1() {
        HomePage homePage = new HomePage();
        String expected = "3";

        Assertions.assertEquals(expected, homePage
                .closeCookie()
                .openElectronicsPage()
                .addProductsToCart()
                .openFurniturePage()
                .addItemsToCart()
                .clickCartButton()
                .getQuantityOfItems());
    }

    @DisplayName("Delete items from basket")
    @Test
    public void test2() {
        HomePage homePage = new HomePage();
        String expected = "В корзине пусто";

        Assertions.assertEquals(expected, homePage
                .closeCookie()
                .openFurniturePage()
                .addItemsToCart()
                .clickCartButton()
                .deleteItemsFromCart());
    }
}
