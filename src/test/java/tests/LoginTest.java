package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends TestBase{
    LoginPage loginPage;
    String url = "https://demoqa.com/login";
    String userName = "PanVi";
    String password = "12345vP!";

    @BeforeMethod
    public void precondition(){
        app.driver.get(url);
    }

    @Test
    public void loginTest(){
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.fillUserNameField(userName);
        loginPage.fillPasswordField(password);
        loginPage.clickOnLoginButton();
        loginPage.waitForLoading();
    }

}
