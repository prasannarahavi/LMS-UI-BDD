package Hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import DriverFactory.DriverFactory;
import Utilities.ConfigReader;
import Utilities.LoggerHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;

public class Hooks {
	private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;
    private Logger log = LoggerHelper.getLogger(Hooks.class);
    private static final String LOG_FILE_PATH = "target/logs/execution.log";

    @Before(order = 0)
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser() {
        String browserName = DriverFactory.getBrowser();
        if (browserName == null || browserName.isEmpty()) {
            browserName = prop.getProperty("browser");
        }
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
        log.info("Browser launched: " + browserName + " | Thread: " + Thread.currentThread().getId());
    }

    @Before(order = 2)
    public void beforeScenario(Scenario scenario) {
        log.info("Starting scenario: " + scenario.getName());
    }

    @After(order = 0)
    public void quitBrowser()
    {
        if (driver != null) {
            log.info("Closing the browser");
            DriverFactory.quitDriver();
        }
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            log.error("Scenario failed: " + scenario.getName());
            // Save screenshot file locally (optional)
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destDir = new File("target/screenshots");
            if (!destDir.exists()) {
                destDir.mkdirs();
            }

            String rawName = scenario.getName();
            if (rawName == null || rawName.trim().isEmpty()) {
                rawName = "unnamed_scenario";
            }
            
            String fileName = rawName.replaceAll("[^a-zA-Z0-9_-]", "_")
                    + "_" + System.currentTimeMillis() + ".png";
            File destFile = new File(destDir, fileName);
            Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Attach to Cucumber report (optional)
            byte[] fileContent = Files.readAllBytes(destFile.toPath());
            scenario.attach(fileContent, "image/png", scenario.getName());

            // Attach to Allure report
            saveScreenshotToAllure(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            
            //Attach to Extent report
            ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(destFile.getAbsolutePath());

            // Attach Log4j2 log file to Allure (if exists)
            if (Files.exists(Paths.get(LOG_FILE_PATH))) {
                attachLogFileToAllure(Files.readAllBytes(Paths.get(LOG_FILE_PATH)));
                log.info("Log file attached to Allure report: " + LOG_FILE_PATH);
            } else {
                log.warn("Log file not found: " + LOG_FILE_PATH);
            }
        } else {
            log.info("Scenario passed: " + scenario.getName());
        }

    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] saveScreenshotToAllure(byte[] screenshot) {
        return screenshot;
    }
    @Attachment(value = "Execution Log", type = "text/plain")
    public byte[] attachLogFileToAllure(byte[] logFile) {
        return logFile;
    }
}