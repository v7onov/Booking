package driver;

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RemoteDriverManager extends DriverManager {

    @Override
    public void createDriver() throws MalformedURLException {
        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setCapability("platformName", "Windows 11");
        browserOptions.setCapability("browserVersion", "79");
        Map<String, Object> sauceOptions = new HashMap<>();
        browserOptions.setCapability("sauce:options", sauceOptions);
        driver = new RemoteWebDriver( new URL("https://oauth-nddpmailbox-9e0b1:af1ac9c7-3c51-4833-959a-a5aeb87be1d4@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), browserOptions);
    }
}
