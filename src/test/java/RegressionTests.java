import org.testng.annotations.Test;

public class RegressionTests extends Appium {
    private static final LoginPage loginPage = new LoginPage();
    private static final InventoryOnboardPage inventoryOnboardPage = new InventoryOnboardPage();
    private static final HomePage homePage = new HomePage();
    private static final MyAccountPage myAccountPage = new MyAccountPage();
    private static final AddCustomerPage addCustomerPage = new AddCustomerPage();
    private static final ShelfLabelPage shelflablePage = new ShelfLabelPage();

    @Test(description = "Loggar in med en kund och klickar förbi onboarding", priority = 1)
    public void LoginAndOnboarding() throws InterruptedException {
        loginPage.Login("325942", "Menigo123");
        Thread.sleep(3000);
        loginPage.Onboarding();
    }
    @Test(description = "Loggar in med en masterkund och loggar sedan in med alla Subkunder", priority = 2)
    public void LoginWithMasterAndSubCustomers() throws InterruptedException {
        Thread.sleep(3000);
        homePage.ClickMyAccount();
        myAccountPage.ClickAddCustomerNumberMenu();
        addCustomerPage.Login("444867", "444867");
        System.out.println("Logged in with 444867");
        myAccountPage.ClickAddCustomerNumberMenu();
        addCustomerPage.Login("570431", "570431");
        System.out.println("Logged in with 570431");
        myAccountPage.ClickAddCustomerNumberMenu();
        addCustomerPage.Login("404320", "404320");
        System.out.println("Logged in with 404320");
        myAccountPage.ClickAddCustomerNumberMenu();
        addCustomerPage.Login("434477", "434477");
        System.out.println("Logged in with 434477");
        Thread.sleep(3000);
        homePage.ClickMyAccount();
    }

    @Test(description = "Loggar in med en SVH kund och beställer shelflabel", priority = 3)
    public void OrderOneShelflable() throws InterruptedException {
        Thread.sleep(3000);
        homePage.ClickMyAccount();
        myAccountPage.ClickShelflableMenu();
        shelflablePage.Search("Läkerol");
        shelflablePage.SearchResultClick();
        shelflablePage.AddButtonClick();
        shelflablePage.OrderButtonClick();
        shelflablePage.Email("marcus.johansson@menigo.se");
        shelflablePage.SendOrderClick();
        shelflablePage.CheckSuccess();
    }

    @Test(description = "Beställ en Hyllkantsetikett med eg.570431", priority = 4)
    public void OrderMoreShelflables() throws InterruptedException {

        shelflablePage.MakeNewOrderButtonClick();

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

    @Test(description = "Login with another SVH customer and choose account to order Shelflabel with", priority = 5)
    public void LoginAndOrderShelflabel() throws InterruptedException {
        Thread.sleep(3000);
        homePage.ClickMyAccount();
        myAccountPage.ClickAddCustomerNumberMenu();
        addCustomerPage.Login("520917", "520917");
        System.out.println("Logged in with 520917");
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

    }

    @Test(description = "Logout a customer from my account page", priority = 7)
    public void LogoutACustomerFromMyAccountPage() throws InterruptedException {

    }

    @Test(description = "Logout all customers", priority = 8)
    public void LogoutAllCustomers() throws InterruptedException {

    }
}
