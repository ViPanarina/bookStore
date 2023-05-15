package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.xml.sax.Locator;
import wait.Wait;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[@id=\"login\"]")
    protected WebElement loginButton;

    @FindBy(xpath = "//input[@id=\"searchBox\"]")
    protected WebElement searchField;

    @FindBy(xpath = "//span[@id='see-book-Learning JavaScript Design Patterns']//a")
    protected WebElement theBook;


   public void waitForLoading(){
        wait = new Wait(driver);
        wait.forVisibility(loginButton);
        wait.forVisibility(searchField);
    }


    public void clickOnSearchField() {
       searchField.click();
    }

    public void fillTheSearchField(String text){
        searchField.sendKeys(text);
    }




}
