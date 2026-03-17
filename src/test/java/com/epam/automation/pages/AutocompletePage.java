package com.epam.automation.pages;

import com.epam.automation.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutocompletePage extends BasePage {

    @FindBy(css = ".btn.btn-lg")
    private WebElement autocompleteLink;

    @FindBy(id = "autocomplete")
    private WebElement adressField;

    @FindBy(id = "street_number")
    private WebElement streetAddressField;

    @FindBy(id = "route" )
    private WebElement streetAddressDosField;

    @FindBy(id = "locality")
    private WebElement cityField;

    @FindBy(id = "administrative_area_level_1")
    private WebElement stateField;

    @FindBy(id = "postal_code")
    private WebElement postalCodeField;

    @FindBy(id = "country")
    private WebElement countryField;

    public AutocompletePage(WebDriver driver) {
        super(driver);
    }

    public void clickAutocompleteLink() {
        click(autocompleteLink);
    }

    public void enterAddress(String address) {
        sendText(adressField, address);
    }

    public void enterStreetAddress(String streetAddress) {
        sendText(streetAddressField, streetAddress);
    }

    public void enterStreetAddressDos(String streetAddressDos) {
        sendText(streetAddressDosField, streetAddressDos);
    }

    public void enterCity(String city) {
        sendText(cityField, city);
    }

    public void enterState(String state) {
        sendText(stateField, state);
    }

    public void enterPostalCode(String postalCode) {
        sendText(postalCodeField, postalCode);
    }

    public void enterCountry(String country) {
        sendText(countryField, country);
    }

    public String getCityValue() { return cityField.getAttribute("value"); }

    public String getStateValue() { return stateField.getAttribute("value"); }

    public String getCountryValue() { return countryField.getAttribute("value"); }
}
