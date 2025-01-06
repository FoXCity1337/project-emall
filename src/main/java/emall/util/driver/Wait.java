package emall.util.driver;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {
    private static WebDriverWait wait;

    public static WebDriverWait setWait() {
        if (wait == null) {
            wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        }
        return wait;
    }
}
