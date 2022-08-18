import org.openqa.selenium.WebElement;

public class ShelfLabelPage {
    private Appium appium = new Appium();
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_RESET = "\u001B[0m";
    public ShelfLabelPage() {

    }
    private WebElement searchFieldElement() throws InterruptedException {
        WebElement searchField = appium.GetElementByXpath("//*[contains(@class,'android.widget.EditText')][contains(@text,'Sök')]",6000);
        return searchField;
    }
    private WebElement searchResultElement() throws InterruptedException {
        WebElement searchResult = appium.GetElementByXpath("//*[contains(@class,'android.view.ViewGroup')][contains(@resource-id,'TouchableOpacitySearchResultItem')][@index='3']",6000);
        return searchResult;
    }

    private WebElement fourthSearchResultElement() throws InterruptedException {
        WebElement searchResult = appium.GetElementByXpath("//*[contains(@class,'android.view.ViewGroup')][contains(@resource-id,'TouchableOpacitySearchResultItem')][@index='9']",6000);
        return searchResult;
    }
    private WebElement addButtonElement() throws InterruptedException {
        WebElement addButton = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'LÄGG TILL')]",6000);
        return addButton;
    }
    private WebElement orderButtonElement() throws InterruptedException {
        WebElement orderButton = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'BESTÄLL')]",6000);
        return orderButton;
    }
    private WebElement emailFieldElement() throws InterruptedException {
        WebElement emailField = appium.GetElementByXpath("//*[contains(@class,'android.widget.EditText')]",6000);
        return emailField;
    }
    private WebElement sendButtonElement() throws InterruptedException {
        WebElement sendButton = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'SKICKA BESTÄLLNING')]",6000);
        return sendButton;
    }

    private WebElement success() throws InterruptedException {
        WebElement sucessMessege = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'Din order är skapad')]", 7000);
        return sucessMessege;
    }
    private WebElement makeNewOrderButtonElement() throws InterruptedException {
        WebElement makeNewOrderButton = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'SKAPA NY ORDER')]",6000);
        //WebElement makeNewOrderButton = appium.GetElementByXpath("//android.view.ViewGroup/android.view.ViewGroup[3]",6000);
        return makeNewOrderButton;
    }

    public void Search(String criteria) throws InterruptedException {
        searchFieldElement().sendKeys(criteria);
        System.out.println("Search criteria entered: " + criteria);
    }
    public void SearchResultClick() throws InterruptedException {
        searchResultElement().click();
    }
    public void FourthSearchResultClick() throws InterruptedException {
        fourthSearchResultElement().click();
    }

    public void AddButtonClick() throws InterruptedException {
        addButtonElement().click();
    }
    public void OrderButtonClick() throws InterruptedException {
        orderButtonElement().click();
    }
    public void Email(String email) throws InterruptedException {
        emailFieldElement().click();
        emailFieldElement().clear();
        emailFieldElement().sendKeys(email);
    }
    public void SendOrderClick() throws InterruptedException {
        sendButtonElement().click();
    }
    public void CheckSuccess() throws InterruptedException {
        if (success().isDisplayed()) {
            System.out.println(ANSI_GREEN + "Hyllkant success! :)"+ ANSI_RESET);
        }
        else {
            System.out.println("Hyllkant not succes, Check error message :(");
        }

    }
    public void MakeNewOrderButtonClick() throws InterruptedException {
        makeNewOrderButtonElement().click();
    }





    //public void orderAShelflabel(String criteria) throws InterruptedException {
      // Search(criteria);
    //}
}
