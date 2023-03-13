import org.openqa.selenium.WebElement;

public class QuickOrderPage {

    private Appium appium = new Appium();

    public QuickOrderPage() {    }

    private WebElement stockCount() throws InterruptedException {
        WebElement stockCountElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'Inventering')]",7000);
        return stockCountElement;
    }

    private WebElement myAccount() throws InterruptedException {
        WebElement mycAccountElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'Mitt konto')]",7000);
        return mycAccountElement;
    }

    public void clickStockCount() throws InterruptedException {
        stockCount().click();
    }

    public void clickMyAccount() throws InterruptedException {
        myAccount().click();
    }
}
