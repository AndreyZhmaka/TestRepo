import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {
    public WebDriver driver;
    String URL = "https://demoqa.com/";
    String Node = "http://0.0.0.0:4444/";

    @Test
    public void main() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.addArguments("--no-sandbox");
        firefoxOptions.addArguments("--disable-infobars");
        firefoxOptions.addArguments("--disable-popup-blocking");
        firefoxOptions.addArguments("--disable-notifications");
        firefoxOptions.addArguments("--disable-dev-shm-usage");
        firefoxOptions.addArguments("--disable-setuid-sandbox");
        caps.setCapability(ChromeOptions.CAPABILITY, firefoxOptions);

        driver = new RemoteWebDriver(new URL(Node), caps);
        driver.get(URL);
        System.out.println(driver.getTitle());

        driver.quit();
    }
}
