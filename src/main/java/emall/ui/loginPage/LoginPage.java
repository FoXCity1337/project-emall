package emall.ui.loginPage;

import emall.ui.loginWithPasswordPage.PasswordPage;
import emall.ui.registrationPage.RegistrationPage;
import emall.util.driver.Driver;
import emall.util.driver.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {
    @FindBy(xpath = "//input[@type='tel']")
    private WebElement phoneInput;

    @FindBy(xpath = "//span[contains(text(),'Войти по паролю')]/..")
    private WebElement passwordButton;

    @FindBy(xpath = "//span[contains(text(),'Зарегистрироваться')]/..")
    private WebElement registrationButton;

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public LoginPage inputPhone(String phone) {
        Wait.setWait().until(ExpectedConditions.visibilityOf(phoneInput));
        phoneInput.sendKeys(phone);
        return this;
    }

    public PasswordPage clickPasswordButton() {
        Wait.setWait().until(ExpectedConditions.visibilityOf(passwordButton));
        passwordButton.click();
        return new PasswordPage();
    }

    public RegistrationPage clickRegistrationButton(){
        Wait.setWait().until(ExpectedConditions.visibilityOf(registrationButton));
        registrationButton.click();
        return new RegistrationPage();
    }
}
