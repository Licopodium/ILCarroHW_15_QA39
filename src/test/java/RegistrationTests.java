
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void precondition() { refresh();
        if (isLogged()) logout(); }


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


    @Test
    public void registrationNegativeInvalidName() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User(
                "",
                "Viva",
                "tlv_" + i + "@cit.com",
                "$T234543a"
        );

        openRegistrationForm();
        fillRegistrationForm1(user);
        submitRegistration();

        boolean isErrorMessageDisplayed = isErrorMessageDisplayed1();
        if (isErrorMessageDisplayed) {
            logger.info("Registration with invalid name failed as expected.");
        } else {
            logger.error("Registration with invalid name did not display the expected error message.");
        }
        Assert.assertTrue(isErrorMessageDisplayed);
    }

    @Test
    public void registrationNegativeInvalidLastName() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User(
                "Teli",
                "",
                "tlv_" + i + "@cit.com",
                "$T234543a"
        );

        openRegistrationForm();
        fillRegistrationForm1(user);
        submitRegistration();
        boolean isErrorMessageDisplayed = isErrorMessageDisplayed2();
        if (isErrorMessageDisplayed) {
            logger.info("Registration with invalid last name failed as expected.");
        } else {
            logger.error("Registration with invalid last name did not display the expected error message.");
        }
        Assert.assertTrue(isErrorMessageDisplayed);
    }


    @Test
    public void registrationNegativeInvalidEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User(
                "Teli",
                "Viva",
                "t@lv_" + i + "@cit.com",
                "$T234543a"
        );

        openRegistrationForm();
        fillRegistrationForm1(user);
        Assert.assertTrue(isErrorMessageDisplayed3());
    }

    @Test
    public void registrationNegativeInvalidPassword() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User(
                "Mila",
                "Vara",
                "tlv_" + i + "@lav.com",
                "тек2345096"
        );

        openRegistrationForm();
        fillRegistrationForm1(user);
        submitRegistration();
        Assert.assertTrue(isErrorMessageDisplayed4());

    }
}