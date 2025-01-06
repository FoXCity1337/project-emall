package emall.ui.catalogPages;

import emall.ui.homePage.HomePage;
import emall.util.driver.Driver;
import emall.util.driver.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ElectronicPage {

    @FindBy(xpath = "//div[1]/div[@class='vertical_actions__jBPxo']//button")
    private WebElement firstProduct;

    @FindBy(xpath = "//div[2]/div[@class='vertical_actions__jBPxo']//button")
    private WebElement secondProduct;

    public ElectronicPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public HomePage addProductsToCart() {
        Wait.setWait().until(ExpectedConditions.visibilityOf(firstProduct));
        firstProduct.click();
        secondProduct.click();
        return new HomePage();
    }
}
