package emall.ui.RegistrationPage;

import emall.BaseTest;
import emall.ui.homePage.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationPageTests extends BaseTest {

    @DisplayName("IncorrectPassword")
    @Test
    public void test1() {
        HomePage homePage = new HomePage();
        String expected = "Пароли не соответствуют правилам";

        Assertions.assertEquals(expected,
                homePage
                        .closeCookie()
                        .clickLoginButton()
                        .inputPhone("291384195")
                        .clickRegistrationButton()
                        .getWrongPasswordMessage("Арсений","Александрович","Андреевич","123@mail.ru",
                                "qwerty12345"));
    }

    @DisplayName("Empty email")
    @Test
    public void test2() {
        HomePage homePage = new HomePage();
        String expected = "Email обязателен для заполнения";

        Assertions.assertEquals(expected,
                homePage
                        .closeCookie()
                        .clickLoginButton()
                        .inputPhone("291384195")
                        .clickRegistrationButton()
                        .getWrongEmailMessage("Арсений","Александрович","Андреевич","",
                "Qwerty12345"));
    }

    @DisplayName("Empty name field")
    @Test
    public void test3() {
        HomePage homePage = new HomePage();
        String expected = "Имя обязательно для заполнения";

        Assertions.assertEquals(expected,
                homePage
                        .closeCookie()
                        .clickLoginButton()
                        .inputPhone("291384195")
                        .clickRegistrationButton()
                        .getWrongNameMessage("","Александрович","Андреевич","123@mail.ru",
                                "Qwerty12345"));
    }

    @DisplayName("Empty surname field")
    @Test
    public void test4() {
        HomePage homePage = new HomePage();
        String expected = "Фамилия обязательна для заполнения";

        Assertions.assertEquals(expected,
                homePage
                        .closeCookie()
                        .clickLoginButton()
                        .inputPhone("291384195")
                        .clickRegistrationButton()
                        .getWrongSurnameMessage("Арсений","","Андреевич","123@mail.ru",
                                "Qwerty12345"));
    }

    @DisplayName("Empty patronymic field")
    @Test
    public void test5() {
        HomePage homePage = new HomePage();
        String expected = "Отчество обязательно для заполнения";

        Assertions.assertEquals(expected,
                homePage
                        .closeCookie()
                        .clickLoginButton()
                        .inputPhone("291384195")
                        .clickRegistrationButton()
                        .getWrongPatronymicMessage("Арсений","Александрович","","123@mail.ru",
                                "Qwerty12345"));
    }

    @DisplayName("Empty patronymic field")
    @Test
    public void test6() {
        HomePage homePage = new HomePage();
        String expected = "Номер телефона введён некорректно";

        Assertions.assertEquals(expected,
                homePage
                        .closeCookie()
                        .clickLoginButton()
                        .inputPhone("")
                        .clickRegistrationButton()
                        .getWrongPhoneMessage("Арсений","Александрович","Андреевич","123@mail.ru",
                                "Qwerty12345"));
    }
}
