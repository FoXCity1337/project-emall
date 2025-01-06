package emall.ui.catalogPages;

import emall.ui.homePage.HomePage;
import emall.util.driver.Driver;
import emall.util.driver.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FurniturePage {
    @FindBy(xpath = "//div[1]/div[@class='vertical_actions__jBPxo']//button")
    private WebElement item;

    public FurniturePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public HomePage addItemsToCart() {
        Wait.setWait().until(ExpectedConditions.visibilityOf(item));
        item.click();
        return new HomePage();
    }
}
