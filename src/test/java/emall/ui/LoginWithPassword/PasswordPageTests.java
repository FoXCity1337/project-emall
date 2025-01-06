package emall.ui.LoginWithPassword;

import emall.BaseTest;
import emall.ui.homePage.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PasswordPageTests extends BaseTest {

    @DisplayName("Empty/incorrect phone")
    @Test
    public void test1(){
        HomePage homePage = new HomePage();
        String expected = "Значение поля \"Номер телефона\" должно начинаться с +375 затем код (25|29|33|44) " +
                "и далее 7 цифр (первая из которых не 0)";

        Assertions.assertEquals(expected,homePage.closeCookie()
                .clickLoginButton()
                .inputPhone("1232393")
                .clickPasswordButton()
                .inputPassword("qwerty12345")
                .clickSubmit()
                .getErrorMessage());
    }

    @DisplayName("Wrong phone/password")
    @Test
    public void test2(){
        HomePage homePage = new HomePage();
        String expected = "Неверный логин или пароль";

        Assertions.assertEquals(expected,homePage.closeCookie()
                .clickLoginButton()
                .inputPhone("291384195")
                .clickPasswordButton()
                .inputPassword("qwerty12345")
                .clickSubmit()
                .getErrorMessage());
    }

    @DisplayName("Empty password")
    @Test
    public void test3(){
        HomePage homePage = new HomePage();
        String expected = "Поле \"Пароль\" обязательно для заполнения.";

        Assertions.assertEquals(expected,homePage.closeCookie()
                .clickLoginButton()
                .inputPhone("291384195")
                .clickPasswordButton()
                .inputPassword("")
                .clickSubmit()
                .getErrorMessage());
    }
}
