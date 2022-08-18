import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;

import static io.appium.java_client.touch.TapOptions.tapOptions;

public class MyAccountPage {

    private Appium appium = new Appium();

    /*@AndroidFindBy(xpath = "//*[contains(@class,'android.widget.TextView')][contains(@text,'Lägg till kundnummer')]")
    WebElement element;*/

    public MyAccountPage() {
        PageFactory.initElements(new AppiumFieldDecorator(appium.driver),this);
    }
    private WebElement addCustomerNumberElement() throws InterruptedException {
        WebElement addCustomerNumber = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'Lägg till kundnummer')]",7000);
        return addCustomerNumber;
    }
    WebElement shelflableElement() throws InterruptedException {
        WebElement shelflableElement =  appium.driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"Hyllkantsetiketter\"))"));
        return shelflableElement;
    }

    WebElement logoutButtonElement() throws InterruptedException {
        WebElement logoutButton = appium.driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().resourceId(\"ProfileLogoutButton\"))"));
        //appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'LOGGA UT')]",7000);
        return logoutButton;
    }

    /*WebElement scrollToProfileLogoutButton() throws InterruptedException {
//        WebElement scrollView = appium.driver.findElement(MobileBy.AndroidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true))" +
//                        ".scrollIntoView(new UiSelector().classNameMatches(\"//*[contains(@class,'android.widget.ScrollView')]\"))"));
        WebElement scrollView = appium.driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().resourceId(\"ProfileLogoutButton\"))"));
        System.out.println(scrollView);
        System.out.println("Trying to scroll");
        return scrollView;
    }*/

    private WebElement logoutFromAppButtonElement() throws InterruptedException {
        WebElement logoutFromAppButton = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'LOGGA UT FRÅN APPEN')]",7000);
        return logoutFromAppButton;
    }

    public void ClickAddCustomerNumberMenu() throws InterruptedException {
        addCustomerNumberElement().click();
    }
    public void ClickShelflableMenu() throws InterruptedException {
        shelflableElement().click();
    }

    public void ClickLogoutButton() throws InterruptedException {
        //logoutButtonElement().click();

        int x = logoutButtonElement().getLocation().getX();
        int y = logoutButtonElement().getLocation().getY();

        Thread.sleep(7000);

        TouchAction action = new TouchAction((PerformsTouchActions) appium.driver)
                .tap(tapOptions().withPosition(PointOption.point(x, y)));
        action.perform();
    }

    public void ClickLogoutFromAppButton() throws InterruptedException {
        logoutFromAppButtonElement().click();
    }

    //public void ScrollPage(WebElement element) throws InterruptedException {
        //System.out.println("Inside MyAccountPage.Scrollpage()");
       // System.out.println("WebElement:" + element);
     //   appium.scrollPage(element);
    //}

    /*public void scrollPage() throws InterruptedException {
        Dimension dim = appium.driver.manage().window().getSize();
        System.out.println("Screen dimensions: " + dim);
        int height = dim.getHeight();
        int width = dim.getWidth();
        int x = width/2;
        int top_y = (int)(height*0.80);
        int bottom_y = (int)(height*0.20);
        System.out.println("coordinates :" + x + "  "+ top_y + " "+ bottom_y);
        TouchActions ts = new TouchActions(appium.driver);
        System.out.println("Last step before it fails?");
        //ts.clickAndHold().moveByOffset(x, bottom_y).release().perform();
        //appium.driver.wait(3000);
        ts.scroll(x, bottom_y);
        ts.scrollToElement(logoutButtonElement());
    }*/

    public void logout() throws InterruptedException {
        //scrollToProfileLogoutButton();
        ClickLogoutButton();
        ClickLogoutFromAppButton();
    }

}
