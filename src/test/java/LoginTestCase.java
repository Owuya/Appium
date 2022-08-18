import org.testng.annotations.Test;

public class LoginTestCase extends Appium {
    private static final LoginPage loginPage = new LoginPage();
    private static final InventoryOnboardPage inventoryOnboardPage = new InventoryOnboardPage();
    private static final HomePage homePage = new HomePage();
    private static final MyAccountPage myAccountPage = new MyAccountPage();
    private static final AddCustomerPage addCustomerPage = new AddCustomerPage();

    //private static final ShelfLabelPage shelflablePage = new ShelfLabelPage();

    @Test(description = "Loggar in med en kund och klickar förbi onboarding")
    public void LoginAndOnboarding() throws InterruptedException {
        loginPage.Login("325942", "Menigo123");
        Thread.sleep(3000);
        //logout();
        loginPage.Onboarding();
        inventoryOnboardPage.CloseInventoryOnboarding();
    }

    @Test(description = "Loggar in med en masterkund och loggar sedan in med alla Subkunder")
    public void LoginWithMasterAndSubCustomers() throws InterruptedException {
        //loginPage.Login("444867", "444867");
        //loginPage.Onboarding();
        //inventoryOnboardPage.CloseInventoryOnboarding();
        homePage.ClickMyAccount();
        //homePage.ClickMyAccount();
        myAccountPage.ClickAddCustomerNumberMenu();
        addCustomerPage.Login("444867", "444867");
        myAccountPage.ClickAddCustomerNumberMenu();
        addCustomerPage.Login("570431", "570431");
        myAccountPage.ClickAddCustomerNumberMenu();
        addCustomerPage.Login("404320", "404320");
        myAccountPage.ClickAddCustomerNumberMenu();
        addCustomerPage.Login("434477", "434477");
    }

    public void logout() throws InterruptedException {
        homePage.ClickMyAccount();
        myAccountPage.logout();
    }

    //@Test(description = "Order shelf label")
    //public void shelf() throws InterruptedException {
    //    myAccountPage.ClickShelflableMenu();
    //    shelflablePage.Search("Läkerol");
    //    shelflablePage.SearchResultClick();
    //}
}
