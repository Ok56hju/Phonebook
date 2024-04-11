package com.phonebook.tests;


import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSingOutButton();
        }
    }

    @Test(enabled = false)
    public void createNewAccountPositiveTest(){
//        Random random = new Random();
//        int i = random.nextInt(1000)+1000;
//        type(By.name("email"), "test2024" + i + "@gm.com");

        // click on Login link
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillLoginRegistreForm(new User().setEmail((UserData.EMAIL)).setPassword(UserData.PASSWORD));
        //click on Registration button
        app.getUser().clickOnRegistrationButton();
        //assert Sing Out button is present
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }

    @Test
    public void createNewAccountWhithExistedNegativeTest(){
        // click on Login link
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillLoginRegistreForm(new User().setEmail(("test2024@gm.com")).setPassword("Qwe123123$"));
        //click on Registration button
        app.getUser().clickOnRegistrationButton();
        //assert Alert is present
       Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
