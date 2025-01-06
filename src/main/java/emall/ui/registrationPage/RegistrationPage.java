package emall.ui.registrationPage;

import emall.util.driver.Driver;
import emall.util.driver.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage {

    @FindBy(xpath = "//input[@name='name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@name='surname']")
    private WebElement surnameField;

    @FindBy(xpath = "//input[@name='patronymic']")
    private WebElement patronymicField;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='passwordRepeat']")
    private WebElement passwordRepeatField;

    @FindBy(xpath = "//div[@class='registration_form_footer__qfOyt']" +
            "//i[@class='icon-check-16 icon_icon__HiJyg checkbox_checkbox__icon__E8Iw1']")
    private WebElement checkBox;

    @FindBy(xpath = "//div[@class='body_content__qN87b']//span[contains(text(),'Далее')]/..")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='policy-consent_select_all__sB4P8']//span[@class='checkbox_checkbox__pseudo__c2vTZ']")
    private WebElement acceptAllCheckBox;

    @FindBy(xpath = "//span[contains(text(),'Согласен')]/..")
    private WebElement acceptButton;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement registrationButton;

    @FindBy(xpath = "//div[@class='registration_error___J4Zl']")
    private WebElement errorPasswordMessage;

    @FindBy(xpath = "//form//div[1]/div[@class='input_message__veX8F']")
    private WebElement errorNameMessage;

    @FindBy(xpath = "//form//div[2]/div[@class='input_message__veX8F']")
    private WebElement errorSurnameMessage;

    @FindBy(xpath = "//form//div[3]/div[@class='input_message__veX8F']")
    private WebElement errorPatronymicMessage;

    @FindBy(xpath = "//form//div[4]/div[@class='new-input-phone_message__H_yAc']")
    private WebElement errorPhoneMessage;

    @FindBy(xpath = "//form//div[5]/div[@class='input_message__veX8F']")
    private WebElement errorEmailMessage;

    public RegistrationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    private RegistrationPage inputName(String name) {
        Wait.setWait().until(ExpectedConditions.visibilityOf(nameField));
        nameField.sendKeys(name);
        return this;
    }

    private RegistrationPage inputSurname(String surname) {
        Wait.setWait().until(ExpectedConditions.visibilityOf(surnameField));
        surnameField.sendKeys(surname);
        return this;
    }

    private RegistrationPage inputPatronymic(String patronymic) {
        Wait.setWait().until(ExpectedConditions.visibilityOf(patronymicField));
        patronymicField.sendKeys(patronymic);
        return this;
    }

    private RegistrationPage inputEmail(String email) {
        Wait.setWait().until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
        return this;
    }

    private RegistrationPage inputPassword(String password) {
        Wait.setWait().until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
        passwordRepeatField.sendKeys(password);
        return this;
    }

    private RegistrationPage clickCheckBox() {
        Wait.setWait().until(ExpectedConditions.visibilityOf(checkBox));
        checkBox.click();
        return this;
    }

    private RegistrationPage clickContinueButton() {
        Wait.setWait().until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
        return this;
    }

    private RegistrationPage clickAcceptAllCheckBox() {
        Wait.setWait().until(ExpectedConditions.visibilityOf(acceptAllCheckBox));
        acceptAllCheckBox.click();
        return this;
    }

    private RegistrationPage clickAcceptButton() {
        Wait.setWait().until(ExpectedConditions.visibilityOf(acceptButton));
        acceptButton.click();
        return this;
    }

    private RegistrationPage clickRegistrationButton() {
        Wait.setWait().until(ExpectedConditions.visibilityOf(registrationButton));
        registrationButton.click();
        return this;
    }

    private RegistrationPage fillInAllFields(String name, String surname, String patronymic, String email, String password) {
        inputName(name);
        inputSurname(surname);
        inputPatronymic(patronymic);
        inputEmail(email);
        inputPassword(password);
        clickCheckBox();
        clickContinueButton();
        clickAcceptAllCheckBox();
        clickAcceptButton();
        clickRegistrationButton();
        return this;
    }

    public String getWrongPasswordMessage(String name, String surname, String patronymic, String email, String password){
        fillInAllFields(name,surname,patronymic,email,password);
        Wait.setWait().until(ExpectedConditions.visibilityOf(errorPasswordMessage));
        return errorPasswordMessage.getText();
    }

    public String getWrongNameMessage(String name, String surname, String patronymic, String email, String password){
        fillInAllFields(name,surname,patronymic,email,password);
        Wait.setWait().until(ExpectedConditions.visibilityOf(errorNameMessage));
        return errorNameMessage.getText();
    }

    public String getWrongSurnameMessage(String name, String surname, String patronymic, String email, String password){
        fillInAllFields(name,surname,patronymic,email,password);
        Wait.setWait().until(ExpectedConditions.visibilityOf(errorSurnameMessage));
        return errorSurnameMessage.getText();
    }

    public String getWrongPatronymicMessage(String name, String surname, String patronymic, String email, String password){
        fillInAllFields(name,surname,patronymic,email,password);
        Wait.setWait().until(ExpectedConditions.visibilityOf(errorPatronymicMessage));
        return errorPatronymicMessage.getText();
    }

    public String getWrongPhoneMessage(String name, String surname, String patronymic, String email, String password){
        fillInAllFields(name,surname,patronymic,email,password);
        Wait.setWait().until(ExpectedConditions.visibilityOf(errorPhoneMessage));
        return errorPhoneMessage.getText();
    }

    public String getWrongEmailMessage(String name, String surname, String patronymic, String email, String password){
        fillInAllFields(name,surname,patronymic,email,password);
        Wait.setWait().until(ExpectedConditions.visibilityOf(errorEmailMessage));
        return errorEmailMessage.getText();
    }
}
