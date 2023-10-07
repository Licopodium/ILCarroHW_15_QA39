import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(isLogged()) logout();
    }

    @Test
    public void loginPositiveTest(){
        openLoginForm();
        fillLoginForm("tlv_2460@cit.com", "$T234543a");
        submitLogin();
        Assert.assertTrue(isLoggedSuccess());
    }
    @Test
    public void loginPositiveTestModel(){
        User user = new User()
                .withEmail("tlv_2460@cit.com")
                .withPassword("$T234543a");
        openLoginForm();
        fillLoginForm(user.getEmail(), user.getPassword());
        submitLogin();
        Assert.assertTrue(isLoggedSuccess());
    }

    @AfterMethod
    public void postcondition(){
        clickOkButton();
    }

}