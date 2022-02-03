import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {
    public WebDriver driver;
    String URL = "https://www.google.com";
    String Node = "http://0.0.0.0:4444/";

    @Test
    public void main() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-setuid-sandbox");
        chromeOptions.addArguments("--lang=en-en");
        caps.setCapability(CapabilityType.BROWSER_NAME,"chrome");
        caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        driver = new RemoteWebDriver(new URL(Node), caps);
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        // run against chrome
        driver.get(URL);
        System.out.println(driver.getTitle());

        driver.quit();
    }
}
