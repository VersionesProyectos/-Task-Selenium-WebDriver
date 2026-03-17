package com.epam.automation.pages;

import com.epam.automation.base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompleteWebFormPage extends BasePage {

    @FindBy(css = "a.nav-link[href='/form']")
    private WebElement formLink;

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "job-title")
    private WebElement jobTitleField;

    @FindBy(id = "radio-button-2")
    private WebElement radioCollege;

    @FindBy(id = "checkbox-1")
    private WebElement genderMale;

    @FindBy(css = "option[value='1']")
    private WebElement yearsOfExperienceDropdown;

    @FindBy(id = "datepicker")
    private WebElement datePicker;

    @FindBy(css = ".btn.btn-lg.btn-primary")
    private WebElement submitButton;

    @FindBy(css = ".alert.alert-success")
    private WebElement alertSuccess;

    public CompleteWebFormPage(WebDriver driver) {
        super(driver);
    }

    public void clickLinkForm() {
        click(formLink);
    }

    public void enterFirstName(String firstName) {
        sendText(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        sendText(lastNameField, lastName);
    }

    public void enterJobTitle(String jobTitle) {
        sendText(jobTitleField, jobTitle);
    }

    public void selectEducationLevel() {
        click(radioCollege);
    }

    public void selectGender() {
        click(genderMale);
    }

    public void selectExperience() {
        click(yearsOfExperienceDropdown);
    }

    public void enterDate(String date) {
        sendText(datePicker, date);
        datePicker.sendKeys(Keys.RETURN);
    }

    public void clickSubmit() {
        click(submitButton);
    }

    public String getAlertText() {
        waitForElementToBeVisible(alertSuccess);
        return alertSuccess.getText();
    }
}
