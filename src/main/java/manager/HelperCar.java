package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface HelperCar extends HelperBase{


    default void openCarForm(){
        pause(5000);
        click(By.xpath("//a[.=' Let the car work ']"));
    }

    default void fillCarForm(Car car){
        if(isCarFormPresent()==false) return;
        typeLocation(car.getLocation());
        type(By.id("make"), car.getManufacture());
//        typeSerialNumber(car.getManufacture());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        select(By.id("fuel"), car.getFuel());
        type(By.id("seats"), car.getSeats());
        type(By.id("class"), car.getCarClass());
//        type(By.id("serialNumber"), car.getCarRegNumber());
        typeSerialNumber(car.getCarRegNumber());
        type(By.id("price"), car.getPrice());
        type(By.id("about"), car.getAbout());
        logger.info("FillCarForm finished");
    }

    default void typeLocation(String location){
//        pause(5000);
        type(By.id("pickUpPlace"), location);
        click(By.className("pac-item"));
    }

    default void typeSerialNumber(String text){
//        Rectangle rect = wd.findElement(By.id("serialNumber")).getRect();
//        Rectangle rect = wd.findElement(By.id("make")).getRect();
//        int x = rect.getX() + rect.getWidth() * 7 / 8;
//        int y = rect.getY() + rect.getHeight() / 2;
        WebElement element = wd.findElement(By.id("serialNumber"));
        Actions actions = new Actions(wd);
//        actions.moveByOffset(x, y).click().sendKeys(text).perform();
//        wd.switchTo().activeElement().sendKeys(text);
        actions.moveToElement(element).click().perform();
        element.clear();
        element.sendKeys(text);
    }

    default boolean isCarFormPresent(){
        return new WebDriverWait(wd, 10)
                .until(ExpectedConditions.textToBePresentInElement(
                        wd.findElement(By.cssSelector("h2")), "details"
                ));
    }

    default void select(By locator, String option){
        new Select(wd.findElement(locator)).selectByValue(option);
    }
}
