package com.epam.automation.test;

import com.epam.automation.base.BaseTest;
import com.epam.automation.pages.AutocompletePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutocompleteTest extends BaseTest {

    private AutocompletePage autocompletePage;

    @BeforeMethod
    public void setUpPage(){
        autocompletePage = new AutocompletePage(driver);
    }

    @Test(description = "Scenario 3: Ten‑step Autocomplete procedure")
    public void autocompleteTest(){

        autocompletePage.clickAutocompleteLink();
        autocompletePage.enterAddress("1600 Amphitheatre Parkway, Mountain View, CA");
        autocompletePage.enterStreetAddress("1600");
        autocompletePage.enterStreetAddressDos("Amphitheatre Parkway");
        autocompletePage.enterCity("Mountain View");
        autocompletePage.enterState("California");
        autocompletePage.enterPostalCode("94043");
        autocompletePage.enterCountry("United States");

        Assert.assertEquals(autocompletePage.getCityValue(), "Mountain View");
        Assert.assertEquals(autocompletePage.getStateValue(), "California");
        Assert.assertEquals(autocompletePage.getCountryValue(), "United States");
    }
}
