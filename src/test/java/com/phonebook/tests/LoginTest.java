package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSingOutButton();
        }
    }
    @Test
    public void loginPositiveTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegistreForm(new User().setEmail("test2024@gm.com").setPassword("Qwe123123$"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //assert Sing out button is present
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }
    @Test
    public void loginNegativeTestWithoutEmail(){
        // click on Login link
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillLoginRegistreForm(new User().setPassword("Qwe123123$"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //assert Sing out button is present
        Assert.assertTrue(app.getUser().isAlertPresent());

    }

}
