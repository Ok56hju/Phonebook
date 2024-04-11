package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebook.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSingOutButton();
        }
        // click on Login link
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillLoginRegistreForm(new User().setEmail((UserData.EMAIL)).setPassword(UserData.PASSWORD));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //assert Sing out button is present

    }

    @Test
    public void addContactPositiveTest(){
        // click on Add link
        app.getContact().clickOnAddLink();
        //enter name
        app.getContact().fillAddContactForm(new Contact()
                            .setName("Loli")
                        .setLastName("Johns")
                        .setPhone("1233214567")
                        .setEmail("kiu78@gm.com")
                        .setAddress("TestB")
                        .setDescription("kokokoko"));
        //click on Save button
        app.getContact().clickOnSaveButton();
        //assert Contact is added by text //assert Contact is added be text
        Assert.assertTrue(app.getContact().isContactCreated("Loli"));
    }

    @AfterMethod
    public void postCondition(){
        app.getContact().removeContact();
    }

    @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromDataProvider(String name,String lastname,String phone,
                                                       String email, String address, String description){
        // click on Add link
        app.getContact().clickOnAddLink();
        //enter name
        app.getContact().fillAddContactForm(new Contact()
                .setName(name)
                .setLastName(lastname)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(description));
        //click on Save button
        app.getContact().clickOnSaveButton();
        //assert Contact is added by text //assert Contact is added be text
        Assert.assertTrue(app.getContact().isContactCreated(name));
    }


    @Test(dataProvider = "addNewContactFromCsvFile", dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromDataProviderWhithCsvFile(Contact contact) {

        app.getContact().clickOnAddLink();

        app.getContact().fillAddContactForm(contact);

        app.getContact().clickOnSaveButton();

        Assert.assertTrue(app.getContact().isContactCreated(contact.getName()));
    }

    }
