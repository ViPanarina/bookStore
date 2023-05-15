package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public static Logger logger = LoggerFactory.getLogger(TestBase.class);
    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setupTest(){
        app.init();
    }

    @AfterMethod
    public void tearDown(){
        app.stop();
    }

    @AfterMethod
    public void stopTest(ITestResult result){
        if(result.isSuccess()){
            logger.info("PASSED" + result.getMethod().getMethodName());
        } else {
          logger.info("FAILeD" + result.getMethod().getMethodName());
        }
        logger.info("=========================================================================");
    }

}
