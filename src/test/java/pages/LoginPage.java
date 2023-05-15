package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='userName']")
    protected WebElement userNameField;

    @FindBy(xpath = "//input[@id='password']")
    protected WebElement  passwordField;

    @FindBy(xpath = "//button[@id='login']")
    protected WebElement loginButton;

    @FindBy(xpath = "//button[@id='newUser']")
    protected WebElement newUserButton;


}
