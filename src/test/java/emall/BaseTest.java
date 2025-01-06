package emall;

import emall.util.driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    @BeforeEach
    public void setUp(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://emall.by/");
    }

    @AfterEach
    public void tearDown(){
        Driver.quitDriver();
    }
}
