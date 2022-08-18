import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
//import io.appium.java_client.pagefactory.AndroidBy;
//import io.appium.java_client.pagefactory.AppiumFieldDecorator;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.PageFactory;
//import java.time.Duration;

public class LoginPage {// extends Appium {
    /*private AppiumDriver driver;
    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        //PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        //this.driver = driver;
    }*/

    //@AndroidBy(xpath = "//*[contains(@class,'android.widget.TextView')][contains(@text,'LOGGA IN')]")
    //private WebElement login;
    //@AndroidFindBy(xpath = "//*[contains(@class,'android.widget.TextView')][contains(@text,'LOGGA IN')]")
    // private WebElement login;

    private Appium appium = new Appium();

    private WebElement loginButton() throws InterruptedException {
        WebElement loginButton = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'LOGGA IN')]",5000);
        return loginButton;
    }
    private WebElement customerNumber() throws InterruptedException {
        WebElement element =  appium.GetElementByXpath("(//*[contains(@class,'android.widget.EditText')])[1]", 5000);
        return element;
    }
    private WebElement password() throws InterruptedException {
        WebElement element =  appium.GetElementByXpath("(//*[contains(@class,'android.widget.EditText')])[2]", 1000);
        return element;
    }
    private WebElement nextStepButton() throws InterruptedException {
        WebElement element =  appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'NÄSTA STEG')]", 1000);
        return element;
    }
    private WebElement beginToUseApp() throws InterruptedException {
        WebElement element =  appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'BÖRJA ANVÄNDA APPEN')]", 3000);
        return element;
    }
    private void ClickLoginButton() throws InterruptedException {
        loginButton().click();
    }
    private void EnterCustomerId(String customerId) throws InterruptedException {
        customerNumber().sendKeys(customerId);
    }
    private void EnterPassword(String password) throws InterruptedException {
        password().sendKeys(password);
    }
    private void ClickNextButton() throws InterruptedException {
        nextStepButton().click();
    }
    private void ClickBeginUseApp() throws InterruptedException{
        beginToUseApp().click();
    }
    public void Login(String username, String password) throws InterruptedException {
        ClickLoginButton();
        EnterCustomerId(username);
        EnterPassword(password);
        ClickLoginButton();
    }
    public void Onboarding() throws InterruptedException {
        ClickNextButton();
        Thread.sleep(500);
        ClickNextButton();
        Thread.sleep(500);
        ClickBeginUseApp();
    }
}
