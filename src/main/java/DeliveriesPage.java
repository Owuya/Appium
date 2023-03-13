import org.openqa.selenium.WebElement;

public class DeliveriesPage {
    private Appium appium = new Appium();

    public DeliveriesPage() {    }

    private WebElement quickOrder() throws InterruptedException {

        WebElement mycAccountElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'Snabborder')]",7000);

        return mycAccountElement;
    }
    private WebElement myAccount() throws InterruptedException {
        WebElement mycAccountElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'Mitt konto')]",7000);
        return mycAccountElement;
    }
    public void clickQuickOrder() throws InterruptedException {

        quickOrder().click();
    }
    public void clickMyAccount() throws InterruptedException {
        myAccount().click();
    }
}
