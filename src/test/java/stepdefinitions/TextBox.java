package stepdefinitions;

import base.DriverInstance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
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
    public void theUserFillsOutAndSubmitsTheTextBoxFormWith(String fullName, String email, String crrntAddrss, String permntAddrss) throws Exception {
        textBoxForm = new TextBoxForm(driver);
        textBoxForm.inputFullNameText(fullName);
        textBoxForm.inputEmailText(email);
        textBoxForm.inputCurrentAddressText(crrntAddrss);
        textBoxForm.inputPermanentAddressText(permntAddrss);
        textBoxForm.submitForm();
        //assert strings fullName equals to waits de getText de la respuesta
    }
}