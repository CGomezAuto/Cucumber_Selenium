package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Waits;

public class Elements {
    Waits waits;

    public Elements(WebDriver driver) {
        waits = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Text Box']")
    WebElement textBoxMenuBtn;

    public void clickTextBoxMenuBtn() {
        waits.click(textBoxMenuBtn, 30);
    }
}