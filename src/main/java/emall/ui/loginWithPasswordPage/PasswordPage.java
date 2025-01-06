package emall.ui.loginWithPasswordPage;

import emall.util.driver.Driver;
import emall.util.driver.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PasswordPage {

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//div[@class='password_error_message__KRNDP']")
    WebElement errorMessage;

    public PasswordPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public PasswordPage inputPassword(String password) {
        Wait.setWait().until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
        return this;
    }

    public PasswordPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public String getErrorMessage(){
        Wait.setWait().until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }
}
