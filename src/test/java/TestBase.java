
import manager.HelperCar;
import manager.HelperUser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class TestBase implements HelperUser, HelperCar {

    WebDriver wd;

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startTest(Method method) {
        logger.info("Started test ----> " + method.getName());
    }

    @AfterMethod
    public void stopTest(Method method) {
        logger.info("Finished test ----> " + method.getName());
    }

    @BeforeSuite

    public void setup() {
        init();
    }

    @AfterSuite

    public void stop() {
        pause(5000);
        tearDown();
    }
}




