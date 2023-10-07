import manager.NGListener;
import models.Car;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(NGListener.class)
public class AddNewCarTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        if(isLogged() == false){
            login(new User()
                    .withEmail("tlv_2460@cit.com")
                    .withPassword("$T234543a")
            );
        }
    }

    @Test
    public void addNewCarPositive(){

        int i = (int)(System.currentTimeMillis()/1000)%3600;

        Car car = Car.builder()
                .location("Tel Aviv")
                .manufacture("KIA")
                .model("Sportage")
                .year("2020")
                .fuel("Petrol")
                .seats("5")
                .carClass("B")
                .carRegNumber("100-200-" + i)
                .price("150")
                .about("New car")
                .build();

        openCarForm();
        fillCarForm(car);
        pause(5000);

    }

}