package emall.ui.cartPage;

import emall.util.driver.Driver;
import emall.util.driver.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage {

    @FindBy(xpath = "//h1/span")
    private WebElement cartCounter;

    @FindBy(xpath = "//span[@class='product_adult__MgqBA']")
    private WebElement selectItem;

    @FindBy(xpath = "//div[1]/div[1]/div[3]/div[2]//span[2]/span/button")
    private WebElement deleteItem;

    @FindBy(xpath = "//h3[@class='empty_title__DVNkZ']")
    private WebElement emptyBasketMessage;

    public CartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String deleteItemsFromCart() {
        Actions action = new Actions(Driver.getDriver());
        Wait.setWait().until(ExpectedConditions.visibilityOf(selectItem));
        action.moveToElement((selectItem)).perform();
        deleteItem.click();

        Wait.setWait().until(ExpectedConditions.visibilityOf(emptyBasketMessage));
        return emptyBasketMessage.getText();
    }

    public String getQuantityOfItems() {
        Wait.setWait().until(ExpectedConditions.visibilityOf(cartCounter));
        return cartCounter.getText();
    }
}
