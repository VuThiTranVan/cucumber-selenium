package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class DriverInitializer {

	private static Properties properties = null;

	static {
		try {
			properties = new Properties();
			properties.load(DriverInitializer.class.getClassLoader().getResourceAsStream("application.properties"));
			System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.path"));
			System.setProperty("webdriver.gecko.driver", properties.getProperty("gecko.path"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver(String browser) {
		WebDriver driver = null;
		switch (getProperty("browser")) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver",
					"/home/vu.thi.tran.van/Training/AutomationTest/selenium/Sources/Selenium-Maven-Template-master/src/test/resources/selenium_standalone_binaries/linux/googlechrome/64bit/chromedriver");

			driver = new ChromeDriver();
		}
		return driver;
	}

	public static String getProperty(String key) {
		return properties == null ? null : properties.getProperty(key, "");
	}
}
