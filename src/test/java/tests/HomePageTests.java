package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.PageBase;

public class HomePageTests extends TestBase{
    HomePage homePage;
    PageBase pageBase;
    String learningJavaScriptBook = "Learning";


    @Test
    public void searchBookTest(){
        homePage = new HomePage(app.driver);
        homePage.clickOnSearchField();
        homePage.fillTheSearchField(learningJavaScriptBook);
        int e = 1;
    }
}
