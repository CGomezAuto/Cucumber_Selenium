package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Waits;

public class TextBoxForm {
    Waits waits;

    public TextBoxForm(WebDriver driver) {
        waits = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /*@FindBy(xpath = "//input[@id='userName']")
    WebElement fullNameInput;  */
    @FindBy(id = "userName")
    WebElement fullNameInput;
    @FindBy(id = "userEmail")
    WebElement emailInput;
    @FindBy(id = "currentAddress")
    WebElement currentAddrsInput;
    @FindBy(id = "permanentAddress")
    WebElement permanentAddrsInput;
    @FindBy(id = "submit")
    WebElement submitBtn;

    public void inputFullNameText(String text) {
        waits.putText(fullNameInput, text, 30);
    }

    public void inputEmailText(String text) {
        waits.putText(emailInput, text, 30);
    }

    public void inputCurrentAddressText(String text) {
        waits.putText(currentAddrsInput, text, 30);
    }

    public void inputPermanentAddressText(String text) {
        waits.putText(permanentAddrsInput, text, 30);
    }

    public void submitForm() {
        waits.click(submitBtn, 30);
    }
}
