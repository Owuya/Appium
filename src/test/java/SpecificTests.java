import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.Calendar;

public class SpecificTests extends Appium {

    private static final LoginPage loginPage = new LoginPage();
    private static final InventoryOnboardPage inventoryOnboardPage = new InventoryOnboardPage();
    private static final HomePage homePage = new HomePage();
    private static final DeliveriesPage deliveriesPage = new DeliveriesPage();
    private static final QuickOrderPage quickOrderPage = new QuickOrderPage();
    private static final StockCountPage stockCountPage = new StockCountPage();
    private static final MyAccountPage myAccountPage = new MyAccountPage();
    private static final AddCustomerPage addCustomerPage = new AddCustomerPage();
    private static final ShelfLabelPage shelflablePage = new ShelfLabelPage();
    private static final CustomerPage customerPage = new CustomerPage();

    @BeforeSuite
    public void start() {
        System.out.println("Time started: " + Calendar.getInstance().getTime());
        Appium.setAppPackage("com.menigo.menigogobeta");
    }

    @Test(description = "Loggar in med en kund och klickar förbi onboarding", priority = 1)
    public void LoginAndOnboarding() throws InterruptedException {
        loginPage.Login("325942", "Menigo123");
        WaitForContent(7000);
        //loginPage.Onboarding();
    }

    @Test(description = "SNabborder - Lägger till en produkt i varukorgen", priority = 2)
    public void QuickorderAddProductToCart() throws InterruptedException, AWTException {

        stockCountPage.clickQuickOrder();
        WaitForContent(4000);
        quickOrderPage.closeKeyboardToContinue();
        //WaitForContent(4000);
        quickOrderPage.clickAddButton();
        WaitForContent(2000);
    }


    /*@Test(description = "Navigera till alla sidor", priority = 2)
    public void NavigateBottomNavThroughPages() throws InterruptedException {
        //Thread.sleep(3000);
        homePage.clickDeliveries();
        WaitForContent(7000);
        deliveriesPage.clickQuickOrder();
        WaitForContent(3000);
        quickOrderPage.closeKeyboardToContinue();
        WaitForContent(7000);
        quickOrderPage.clickStockCount();
        WaitForContent(7000);
        stockCountPage.clickMyAccount();
        WaitForContent(4000);
    }

    /*@Test(description = "Loggar in med en kund och klickar förbi onboarding", priority = 1)
    public void LoginAndOnboarding() throws InterruptedException {
        loginPage.Login("325942", "Menigo123");
        //loginPage.Login("444867", "444867");
        Thread.sleep(7000);
        //loginPage.Onboarding();
    }

     */
    /*@Test(description = "Loggar in med en masterkund och loggar sedan in med alla Subkunder", priority = 2)
    public void LoginWithMasterAndSubCustomers() throws InterruptedException {
        Thread.sleep(3000);
        homePage.clickMyAccount();
        myAccountPage.ClickAddCustomerNumberMenu();
        addCustomerPage.Login("444867", "444867");
        System.out.println("Logged in with 444867");
        myAccountPage.ClickAddCustomerNumberMenu();
        addCustomerPage.Login("570431", "570431");
        System.out.println("Logged in with 570431");
        Thread.sleep(7000);
        myAccountPage.ClickAddCustomerNumberMenu2();
        addCustomerPage.Login("404320", "404320");
        System.out.println("Logged in with 404320");
        Thread.sleep(7000);
        myAccountPage.ClickAddCustomerNumberMenu2();
        addCustomerPage.Login("434477", "434477");
        System.out.println("Logged in with 434477");
        Thread.sleep(3000);
        homePage.clickMyAccount();
    }*/

    /*@Test(description = "Som en SVH kund 570431, beställer shelflabel", priority = 3)
    public void OrderOneShelflable() throws InterruptedException {
        //Thread.sleep(3000);
        homePage.clickMyAccount();
        myAccountPage.ClickShelflableMenu();
        shelflablePage.Search("Läkerol");
        //shelflablePage.Scan();
        //Thread.sleep(10000);
        shelflablePage.SearchResultClick();
        shelflablePage.AddButtonClick();
        Thread.sleep(3000);
        shelflablePage.OrderButtonClick();
        shelflablePage.Email("marcus.johansson@menigo.se");
        shelflablePage.SendOrderClick();
        shelflablePage.CheckSuccess();
    }

    @Test(description = "Beställ en Hyllkantsetikett med olika sätt: Barcode, Helt namn, etc - 570431", priority = 4)
    public void OrderMoreShelflables() throws InterruptedException {

        shelflablePage.MakeNewOrderButtonClick();
        //shelflablePage.ClearSearchResult();

        shelflablePage.Search("Standardmjölk");
        shelflablePage.FourthSearchResultClick();
        shelflablePage.AddButtonClick();

        shelflablePage.Search("123456");
        shelflablePage.SearchResultClick();
        shelflablePage.AddButtonClick();

        shelflablePage.Search("Nocco BCAA+ Äpple BRK");
        shelflablePage.SearchResultClick();
        shelflablePage.AddButtonClick();

        shelflablePage.Search("Standardmjölk");
        shelflablePage.FourthSearchResultClick();
        //shelflablePage.AddButtonClick();

        shelflablePage.Search("Ahlgrens bilar");
        shelflablePage.SearchResultClick();
        shelflablePage.AddButtonClick();

        shelflablePage.OrderButtonClick();
        shelflablePage.Email("marcus.johansson@menigo.se");
        shelflablePage.SendOrderClick();
        shelflablePage.CheckSuccess();
    }

    @Test(description = "Login with another SVH customer and select account to order Shelflabel with", priority = 5)
    public void LoginAndOrderShelflabel() throws InterruptedException {
        Thread.sleep(3000);
        homePage.clickMyAccount();
        myAccountPage.ClickAddCustomerNumberMenu2();
        addCustomerPage.Login("520917", "520917");
        System.out.println("Logged in with 520917");
        Thread.sleep(5000);
        myAccountPage.ClickShelflableMenu();
        myAccountPage.ClickSelectCustomer();
        shelflablePage.Search("Läkerol");
        shelflablePage.SearchResultClick();
        shelflablePage.AddButtonClick();
        shelflablePage.OrderButtonClick();
        shelflablePage.Email("marcus.johansson@menigo.se");
        shelflablePage.SendOrderClick();
        shelflablePage.CheckSuccess();
    }

    @Test(description = "Logout a customer from customer page", priority = 6)
    public void LogoutACustomerFromCustomerPage() throws InterruptedException {

        homePage.clickMyAccount();
        myAccountPage.clickOnCustomer();
        customerPage.clickLogout();
        customerPage.clickLogoutButton();
    }*/

    @Test(description = "Logout a customer from list on my account page", priority = 7)
    public void LogoutACustomerFromMyAccountPage() throws InterruptedException {
        ////*[contains(@class,'android.view.ViewGroup')][contains(@resource-id,'LogoutSingleContactButton_570431')]
        Thread.sleep(3000);
        myAccountPage.logoutSpecificCustomer("570431");
        Thread.sleep(3000);
    }

    /*@Test(description = "Logout all customers", priority = 8)
    public void LogoutAllCustomers() throws InterruptedException {
        homePage.clickMyAccount();
        myAccountPage.logout();
    }*/
}
