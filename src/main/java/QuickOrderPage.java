import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.*;

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
    private WebElement closeKeyboard() throws InterruptedException {
        //WebElement closeKeyboardElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'0')]",7000);
        WebElement closeKeyboardElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'ART.NR 207322')]",7000);
        return closeKeyboardElement;
    }

    private WebElement addButton() throws InterruptedException {
        //WebElement addButtonElement = appium.GetElementByXpath("//android.view.ViewGroup[4]/android.view.ViewGroup[2]",7000);
        WebElement addButtonElement = appium.GetElementByXpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]",7000);
        return addButtonElement;
    }

    public void clickStockCount() throws InterruptedException {
        stockCount().click();
    }
    public void closeKeyboardToContinue() throws InterruptedException { //, AWTException {
        //boolean isKeyboardOpen = ((AndroidDriver)appium.driver).isKeyboardShown();
        //Robot robot= new Robot();

        //robot.keyPress(KeyEvent.VK_ALT);
        //robot.keyPress(KeyEvent.VK_S);

        //System.out.println("Boolean is: " + isKeyboardOpen);

        //if(isKeyboardOpen) {
          //  System.out.println("Inside if statement. Element visible");
            //System.out.println("Barcode scanned");
            closeKeyboard().click();
        //} else {
         //   System.out.println(" ---- Barcode not scanned! -------");
         //   System.out.println(" ---- Test continue -------");
            //robot.keyPress(KeyEvent.VK_ALT);
            //robot.keyPress(KeyEvent.VK_S);
        //}


    }
    public void clickMyAccount() throws InterruptedException {
        myAccount().click();
    }

    public void clickAddButton() throws InterruptedException {
        addButton().click();
    }
}
