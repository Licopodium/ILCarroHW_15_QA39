
import models.User;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @Test
    public void registrationPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;

        User user = new User(
                "Teli",
                "Viva",
                "tlv_" + i + "@cit.com",
                "$T234543a"
        );

        openRegistrationForm();
        fillRegistrationForm(user);
        submitRegistration();
    }


}