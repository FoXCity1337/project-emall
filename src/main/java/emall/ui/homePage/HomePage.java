package emall.ui.homePage;

import emall.ui.cartPage.CartPage;
import emall.ui.catalogPages.ElectronicPage;
import emall.ui.catalogPages.FurniturePage;
import emall.ui.loginPage.LoginPage;
import emall.util.driver.Driver;
import emall.util.driver.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//button[@class='touchable_button__GJNQZ actions_action__button__OiPrx']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@href='https://emall.by/cart']")
    private WebElement cartButton;

    @FindBy(xpath = "//a[@href='https://emall.by/favorites'']")
    private WebElement favoriteButton;

    @FindBy(xpath = ("//span[contains(text(),'Принять')]/.."))
    private WebElement closeCookie;

    @FindBy(xpath = "//button[@class='catalog_button__Wv6EG']")
    private WebElement catalogButton;

    @FindBy(xpath = "//span[contains(text(),'Электроника')]")
    private WebElement electronicsPageButton;

    @FindBy(xpath = "//span[contains(text(),'Мебель')]")
    private WebElement furniturePageButton;

    public HomePage() {
        this.driver = Driver.getDriver();
        this.wait = Wait.setWait();
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage();
    }

    public CartPage clickCartButton() {
        cartButton.click();
        return new CartPage();
    }

    public void clickFavoriteButton() {
        favoriteButton.click();
    }

   public ElectronicPage openElectronicsPage(){
        clickCatalogButton();
        electronicsPageButton.click();
        wait.until(ExpectedConditions.urlToBe("https://emall.by/category/4757"));
        return new ElectronicPage();
   }
    public FurniturePage openFurniturePage(){
        clickCatalogButton();
        furniturePageButton.click();
        wait.until(ExpectedConditions.urlToBe("https://emall.by/category/3704"));
        return new FurniturePage();
    }

    public HomePage closeCookie() {
        wait.until(ExpectedConditions.visibilityOf(closeCookie));
        closeCookie.click();
        return this;
    }

    private HomePage clickCatalogButton(){
        wait.until(ExpectedConditions.visibilityOf(catalogButton));
        catalogButton.click();
        return this;
    }
}
