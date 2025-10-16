package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasePage {

    public WebDriver driver;
    private Properties prop;
    private String browser;
    private String baseUrl;

    @BeforeClass
    public void setUp() {
        
        prop = new Properties();
        try {
            // Load the properties from the configuration file
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/resources/config/configuration.properties");
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read browser and URL from the properties file
        browser = prop.getProperty("browser");
        baseUrl = prop.getProperty("url");

        // Initialize WebDriver based on the browser specified in the properties
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }

        // Maximize the browser window and configure timeouts
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Open the base URL
        driver.get(baseUrl);

    }

    @AfterClass
    public void tearDown() {       
        if (driver != null) {
            driver.quit();
        }
    }
}
