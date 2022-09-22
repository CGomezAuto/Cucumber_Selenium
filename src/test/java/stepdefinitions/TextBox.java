package stepdefinitions;

import base.DriverInstance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Elements;
import pages.Home;
import pages.TextBoxForm;

public class TextBox extends DriverInstance {
    Home home;
    Elements elements;
    TextBoxForm textBoxForm;

    @Given("The user navigates to Elements page and text box tab")
    public void theUserNavigatesToElementsPageAndTextBoxTab() throws Exception {
        DriverInstance.getDriverInstance();
        home = new Home(driver);
        elements = new Elements(driver);
        home.clickElementsMenuBtn();
        elements.clickTextBoxMenuBtn();
    }

    @When("The user fills out and submits the Text box form with {string} & {string} & {string} & {string}")
    public void theUserFillsOutAndSubmitsTheTextBoxFormWith(String fullName, String email, String crrntAddrss, String permntAddrss) {
        textBoxForm = new TextBoxForm(driver);
        textBoxForm.fillForm(fullName, email, crrntAddrss, permntAddrss);
        textBoxForm.submitForm();
    }

    @Then("The user checks the submit response is the same as the information inputted {string} & {string} & {string} & {string}")
    public void theUserChecksTheSubmitResponseIsTheSameAsTheInformationInputted(String fullName, String email, String crrntAddrss, String permntAddrss) {
        Assert.assertEquals("Name:" + fullName, textBoxForm.getFullName());
        Assert.assertEquals("Email:" + email, textBoxForm.getEmail());
        Assert.assertEquals("Current Address :" + crrntAddrss, textBoxForm.getCurrntAddress());
        Assert.assertEquals("Permananet Address :" + permntAddrss, textBoxForm.getPermanentAddress());
        driver.quit();
    }

}