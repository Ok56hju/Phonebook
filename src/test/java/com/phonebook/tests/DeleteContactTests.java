package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){

        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSingOutButton();
        }

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegistreForm(new User().setEmail((UserData.EMAIL))
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();

        app.getContact().clickOnAddLink();

        app.getContact().fillAddContactForm(new Contact()
                .setName("Loli")
                .setLastName("Johns")
                .setPhone("1233214567")
                .setEmail("kiu78@gm.com")
                .setAddress("TestB")
                .setDescription("kokokoko"));
        app.getContact().clickOnSaveButton();
    }

    @Test
     public void deleteContactPositiveTest() {
            int sizeBefore = app.getContact().sizeOfContacts();
            app.getContact().removeContact();

        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore-1);
        }
}
