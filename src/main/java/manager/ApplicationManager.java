package manager;


import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public interface ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    EventFiringWebDriver wd = new EventFiringWebDriver(new ChromeDriver());

    default void init(){

        String link = "https://ilcarro.web.app/search";
        wd.register(new WDListener());
        wd.navigate().to(link);
        logger.info("Navigated to the link ---> " + link);
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    default void tearDown(){
        wd.quit();
        logger.info("Tests completed");}

}




