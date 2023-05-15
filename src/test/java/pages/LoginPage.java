package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wait.Wait;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//form[@id='userForm']//div//h5")
    protected WebElement loginInBookStore;

    @FindBy(xpath = "//input[@id='userName']")
    protected WebElement userNameField;

    @FindBy(xpath = "//input[@id='password']")
    protected WebElement  passwordField;

    @FindBy(xpath = "//button[@id='login']")
    protected WebElement loginButton;

    @FindBy(xpath = "//button[@id='newUser']")
    protected WebElement newUserButton;
    @FindBy(xpath = "//div[@id='books-wrapper']//div[1]//label[1]")
    protected WebElement books;

    public void waitForLoading(){
        wait = new Wait(driver);
       wait.forVisibility(loginInBookStore);
       wait.forVisibility(books);
    }

    public void fillUserNameField(String text){
        userNameField.click();
        userNameField.sendKeys(text);
    }

    public void fillPasswordField(String password){
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }








}
