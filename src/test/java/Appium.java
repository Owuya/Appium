import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Appium {
    public static AppiumDriver driver;
    public WebDriverWait wait;
    public Duration duration = Duration.ofSeconds(30);

    public Appium() {
    }

    @BeforeSuite
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("deviceName", "Pixel 5 API 31");
        //caps.setCapability("deviceName", "8 Fold-out API 31");
        //caps.setCapability("deviceName", "XQ-AT51");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "12.0");
        //caps.setCapability("platformVersion", "11.0");
        //caps.setCapability("app", "C://Users//1111//Downloads//59-1.apk");
        caps.setCapability("appPackage", "com.menigo.menigogobeta");
        //caps.setCapability("appPackage", "com.menigo.menigogo");
        caps.setCapability("appActivity", "com.menigo.menigogo.MainActivity");
        caps.setCapability("automationName", "Appium");
        caps.setCapability("noReset", true);
        caps.setCapability("printPageSourceOnFindFailure", true);
        caps.setCapability("unlockType", "pin");
        caps.setCapability("unlockKey", "0710");

        System.out.println("Capabilities used: " + caps.getCapabilityNames());
        System.out.println("deviceName: " + caps.getCapability("deviceName"));
        System.out.println("appPackage: " + caps.getCapability("appPackage"));

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    public void WaitForElementByXpath(String element, int sleep) throws InterruptedException {
        try {
            driver.findElement(By.xpath(element));
        }
        catch (Exception e) {

            Thread.sleep(sleep);
            //wait.wait(sleep);
            //System.out.println("Appium class: Inside Try/catch sequence, sleeping for milliseconds: " + sleep);
        }
    }

    public void WaitForElementById(String element, int sleep) throws InterruptedException {
        try {
            driver.findElement(By.id(element));
        }
        catch (Exception e) {
            Thread.sleep(sleep);
        }
    }

    public WebElement GetElementByXpath (String element, int sleep) throws InterruptedException {
        WaitForElementByXpath(element, sleep);
        WebElement xpath = driver.findElement(By.xpath(element));
        return xpath;
    }

    public WebElement GetElementById(String element, int sleep) throws InterruptedException {
        WaitForElementById(element, sleep);
        WebElement xpath = driver.findElement(By.id(element));
        return xpath;
    }

    public void WaitForContent(long milliseconds) throws InterruptedException {
        synchronized (driver)
        {
            driver.wait(milliseconds);
        }
    }

    @AfterSuite
    public void teardown() {
        //System.out.println("Is device Locked:" + driver.isDe);

        driver.quit();
        System.out.println("teardown() - Testcase done");
    }

/*    public void scrollPage(WebElement element) throws InterruptedException {

        // Get your screen size to set properly start point (startX, startY)
        // and end point (endX, endY) for scrolling
        //Dimension screenSize = driver.manage().window().getSize();

        //new TouchActions(driver).down(screenSize.width, screenSize.height);

        //System.out.println("Trying to scroll");

        //TouchActions action = new TouchActions(driver);
        //action.scrollToElement(element);

        //System.out.println("Trying to scroll - before action.perform()");
        //action.perform();
        Dimension dim = driver.manage().window().getSize();
        int height = dim.getHeight();
        int width = dim.getWidth();
        int x = width/2;
        int top_y = (int)(height*0.80);
        int bottom_y = (int)(height*0.20);
        System.out.println("coordinates :" + x + "  "+ top_y + " "+ bottom_y);
        TouchActions ts = new TouchActions(driver);
        ts.clickAndHold().moveByOffset(x, bottom_y).release().perform();
    }*/
}