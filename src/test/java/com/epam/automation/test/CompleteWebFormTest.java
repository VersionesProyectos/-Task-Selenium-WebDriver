package com.epam.automation.test;

import com.epam.automation.base.BaseTest;
import com.epam.automation.pages.CompleteWebFormPage;
import com.epam.automation.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompleteWebFormTest extends BaseTest {

    private CompleteWebFormPage completeWebFormPage;

    @BeforeMethod
    public void setUpPage() {
        completeWebFormPage = new CompleteWebFormPage(driver);
    }

    @Test(description = "Scenario 1: Complete the Formy registration form")
    public void testCompleteWebForm(){

        completeWebFormPage.clickLinkForm();
        completeWebFormPage.enterFirstName(Constants.FIRST_NAME);
        completeWebFormPage.enterLastName(Constants.LAST_NAME);
        completeWebFormPage.enterJobTitle(Constants.JOB_TITLE);
        completeWebFormPage.selectEducationLevel();
        completeWebFormPage.selectGender();
        completeWebFormPage.selectExperience();
        completeWebFormPage.enterDate(Constants.DATE);
        completeWebFormPage.clickSubmit();

        Assert.assertEquals(completeWebFormPage.getAlertText(), Constants.SUCCESS_MESSAGE);

    }

}
