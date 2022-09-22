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

    @FindBy(id = "userName")
    WebElement fullNameTxtBx;
    @FindBy(id = "userEmail")
    WebElement emailTxtBx;
    @FindBy(id = "currentAddress")
    WebElement currentAddrsTxtBx;
    @FindBy(id = "permanentAddress")
    WebElement permanentAddrsTxtBx;
    @FindBy(id = "submit")
    WebElement submitBtn;
    @FindBy(id = "name")
    WebElement responseFullNameLb;
    @FindBy(id = "email")
    WebElement responseEmailLb;
    @FindBy(xpath = "//p[@id='currentAddress']")
    WebElement responseCurrntAddressLb;
    @FindBy(xpath = "//p[@id='permanentAddress']")
    WebElement responsePermanentAddressLb;

    public void fillForm(String fullName, String email, String currentAddress, String permanenAddress) {
        waits.putText(fullNameTxtBx, fullName, 30);
        waits.putText(emailTxtBx, email, 30);
        waits.putText(currentAddrsTxtBx, currentAddress, 30);
        waits.putText(permanentAddrsTxtBx, permanenAddress, 30);
    }

    public void submitForm() {
        waits.click(submitBtn, 30);
    }

    public String getFullName() {
        return waits.getText(responseFullNameLb, 30);
    }

    public String getEmail() {
        return waits.getText(responseEmailLb, 30);
    }

    public String getCurrntAddress() {
        return waits.getText(responseCurrntAddressLb, 30);
    }

    public String getPermanentAddress() {
        return waits.getText(responsePermanentAddressLb, 30);
    }

}