package com.epam.automation.pages;

import com.epam.automation.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


public class SwitchWindowPage extends BasePage {

    @FindBy(id = "logo")
    private WebElement logoHome;

    @FindBy(css = "a.btn-lg[href='/switch-window']")
    private WebElement switchWindowLink;

    @FindBy(id = "new-tab-button")
    private WebElement openNewTabButton;

    private String mainWindowHandle;

    @FindBy(id = "alert-button")
    private WebElement openAlertButton;

    @FindBy(css = ".navbar-brand")
    private WebElement logoFormy;

    @FindBy(css = ".display-3")
    private WebElement mainTitle;

    public SwitchWindowPage(WebDriver driver) {
        super(driver);
    }

    public void clickLogo() {
        click(logoHome);
    }

    public void scrollToAndClickSwitchWindow() {

        refreshPageElements();
        waitForElementToBeVisible(switchWindowLink);
        try {
            scrollToElement(switchWindowLink);
        } catch (StaleElementReferenceException e) {
            refreshPageElements();
            scrollToElement(switchWindowLink);
        }
        click(switchWindowLink);
    }

    public void clickOpenNewTab () {
        mainWindowHandle = driver.getWindowHandle();
        click(openNewTabButton);
    }

    public void switchToNewTab() {
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public void switchToMainTab() {
        driver.close();
        driver.switchTo().window(mainWindowHandle);
    }

    public void clickOpenAlert() {
        click(openAlertButton);
    }

    public void switchAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void clickLogoFormy() {
        click(logoFormy);
    }

    public String getMainTitleText() {
        try {
            refreshPageElements();
            waitForElementToBeVisible(mainTitle);
            return mainTitle.getText();

        } catch (StaleElementReferenceException e) {
            refreshPageElements();
            return mainTitle.getText();
        }
    }

}
