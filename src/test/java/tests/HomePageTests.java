package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PageBase;

public class HomePageTests extends TestBase{
    HomePage homePage;
    PageBase pageBase;
    String learningJavaScriptBook = "Learning";
    String url = "https://demoqa.com/books";


    @BeforeMethod
    public void precondition(){
        app.driver.get(url);
    }

    @Test
    public void searchBookTest(){
        homePage = new HomePage(app.driver);
        homePage.clickOnSearchField();
        homePage.fillTheSearchField(learningJavaScriptBook);
        int e = 1;
    }
}
